package com.example.mohammadchhipa.techchallengeapp.view.datalist

import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import com.example.mohammadchhipa.techchallengeapp.data.Result
import com.example.mohammadchhipa.techchallengeapp.domain.repository.State
import com.example.mohammadchhipa.techchallengeapp.domain.usecases.BaseUseCases
import com.example.mohammadchhipa.techchallengeapp.model.DeliveryData
import com.example.mohammadchhipa.techchallengeapp.utils.AppConstant
import com.example.mohammadchhipa.techchallengeapp.utils.NetworkUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.net.UnknownHostException

class BoundaryCallback(private val useCase: BaseUseCases<DeliveryData, Int>,
                       private val disposable: CompositeDisposable,
                       private val networkUtils: NetworkUtils
) : PagedList.BoundaryCallback<DeliveryData>() {

    var totalCount: Int = 0
    private var isLoaded: Boolean = false
    private var loadingFirstPage: Boolean = false
    var state: MutableLiveData<String> = MutableLiveData()

    override fun onZeroItemsLoaded() {
        loadingFirstPage = true
        fetchFromNetwork(0, AppConstant.Const.PAGE_SIZE)

    }

    override fun onItemAtFrontLoaded(itemAtFront: DeliveryData) {
        super.onItemAtFrontLoaded(itemAtFront)
        disposable.add(useCase.getCount()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { result ->
                    if (totalCount < result) totalCount = result
                })
    }

    override fun onItemAtEndLoaded(itemAtEnd: DeliveryData) {
        super.onItemAtEndLoaded(itemAtEnd)
        if (!isLoaded) {
            loadingFirstPage = totalCount <= 0
            fetchFromNetwork(totalCount, AppConstant.Const.PAGE_SIZE)
        }
    }

    private fun fetchFromNetwork(offset: Int, limit: Int) {
        if (!networkUtils.internetAvailability()) {
            updateState(State.NETWORK_ERROR)
            return
        }
        if (offset == 0) {
            updateState(State.LOADING)
        } else {
            updateState(State.PAGE_LOADING)
        }

        disposable.add(
                useCase.fetchItemList(offset, limit)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({ result ->
                            when (result) {
                                is Result.Success -> {
                                    @Suppress("UNCHECKED_CAST")
                                    success(result.response as List<DeliveryData>)
                                }
                                is Result.Failure -> {
                                    error(result.throwable)
                                }
                            }
                        }, { e -> error(e) })
        )

    }

    private fun success(list: List<DeliveryData>) {
        totalCount += list.size
        if (list.size < AppConstant.Const.PAGE_SIZE) {
            isLoaded = true
            updateState(State.LOADED)

        } else
            updateState(State.DONE)
        // EspressoIdlingResource.decrement()
    }

    private fun error(throwable: Throwable) {
        if (throwable is UnknownHostException) {
            updateState(State.NETWORK_ERROR)
        } else {
            updateState(State.ERROR)
        }
        // EspressoIdlingResource.decrement()
    }

    fun updateState(state: String) {
        this.state.postValue(state)
    }

    fun retry() {
        loadingFirstPage = true
        fetchFromNetwork(totalCount, AppConstant.Const.PAGE_SIZE)
    }

    fun onRefresh() {
        totalCount = 0
        isLoaded = false
        disposable.clear()
        onZeroItemsLoaded()
    }
}