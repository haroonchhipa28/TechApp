package com.example.mohammadchhipa.techchallengeapp.viewmodel


import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.mohammadchhipa.techchallengeapp.domain.usecases.DataUseCase
import com.example.mohammadchhipa.techchallengeapp.model.DeliveryData
import com.example.mohammadchhipa.techchallengeapp.utils.AppConstant
import com.example.mohammadchhipa.techchallengeapp.utils.NetworkUtils
import com.example.mohammadchhipa.techchallengeapp.view.BaseViewModel
import com.example.mohammadchhipa.techchallengeapp.view.datalist.BoundaryCallback
import javax.inject.Inject


class MainViewModel @Inject constructor(
        private val useCase: DataUseCase,
        private val networkUtils: NetworkUtils) : BaseViewModel() {

    var itemList: LiveData<PagedList<DeliveryData>>
    var item = ObservableField<DeliveryData>()
    var noData = ObservableBoolean(false)
    var boundaryCallback: BoundaryCallback

    init {

        val config = PagedList.Config.Builder()
                .setPageSize(AppConstant.Const.PAGE_SIZE)
                .setInitialLoadSizeHint(AppConstant.Const.PAGE_SIZE)
                .setEnablePlaceholders(false)
                .build()

        boundaryCallback =
                BoundaryCallback(useCase, getDisposable(), networkUtils)

        itemList = LivePagedListBuilder(useCase.getItemList(), config)
                .setBoundaryCallback(boundaryCallback).build()

    }

    fun retry() = boundaryCallback.retry()

    fun onRefresh() {
        isLoading.set(true)
        boundaryCallback.onRefresh()
    }

}