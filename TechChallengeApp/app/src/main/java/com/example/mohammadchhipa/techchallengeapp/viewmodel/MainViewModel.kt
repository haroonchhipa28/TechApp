package com.example.mohammadchhipa.techchallengeapp.viewmodel


import android.view.View
import androidx.lifecycle.MutableLiveData
import com.example.mohammadchhipa.techchallengeapp.R
import com.example.mohammadchhipa.techchallengeapp.adapter.ListAdapter
import com.example.mohammadchhipa.techchallengeapp.database.DeliveriesDao
import com.example.mohammadchhipa.techchallengeapp.model.DeliveryData
import com.example.mohammadchhipa.techchallengeapp.model.WebServices
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class MainViewModel(private val deliveriesDao: DeliveriesDao) : BaseViewModel() {

//    @Inject
//    protected lateinit var repository: DataRepository

    @Inject
    lateinit var webServices: WebServices

    private lateinit var subscription: Disposable
    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage: MutableLiveData<Int> = MutableLiveData()
    val errorClickListener = View.OnClickListener { callNetworkApi() }
    val listAdapter: ListAdapter = ListAdapter()

    init {
        callNetworkApi()
    }

    private fun callNetworkApi() {
        subscription =
//                Observable.fromCallable { deliveriesDao.getAll() }
//                .concatMap { dbDataList ->
//                    if (dbDataList.isEmpty())
//                        webServices.getDeliveryData().concatMap { apiDataList ->
//                            deliveriesDao.insertData(apiDataList)
//                            Observable.just(apiDataList)
//                        }
//                    else
//                        Observable.just(dbDataList)
//                }

                webServices.getDeliveryData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { onRetrievePostListStart() }
                .doOnTerminate { onRetrievePostListFinish() }
                .subscribe(
                        { result -> onRetrievePostListSuccess(result) },
                        { onRetrievePostListError() })
    }


    private fun onRetrievePostListStart() {
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    private fun onRetrievePostListFinish() {
        loadingVisibility.value = View.GONE
    }

    private fun onRetrievePostListSuccess(result: List<DeliveryData>) {
        listAdapter.updatePostList(result)
    }

    private fun onRetrievePostListError() {
        errorMessage.value = R.string.post_error
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

//    interface MainView {
//        fun getData(data: ArrayList<DeliveriesData>)
//    }
//
//    fun makeNetworkCall() {
//        repository.getDeliveryData()
//                .subscribeOn(Schedulers.io())
//                ?.observeOn(AndroidSchedulers.mainThread())
//                ?.doOnError({ throwable -> Log.e(MainViewModel::class.java.simpleName, "Error in network call") })
//                ?.subscribe { model ->
//                    if (model.size > 0) {
//                        repository.insertData(model)
//                    }
//                }
//    }
}