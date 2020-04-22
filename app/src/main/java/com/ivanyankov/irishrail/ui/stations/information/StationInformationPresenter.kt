package com.ivanyankov.irishrail.ui.stations.information

import android.content.res.Resources
import com.ivanyankov.irishrail.data.RetrofitInstance
import com.ivanyankov.irishrail.data.service.IrishRailService
import com.ivanyankov.irishrail.ui.BasePresenter
import com.ivanyankov.irishrail.ui.trains.uimodel.TrainUiModelMapper
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers

class StationInformationPresenter : BasePresenter<StationInformationContract.View>(),
    StationInformationContract.Presenter {

    override fun loadStationData(stationCode: String, resources: Resources) {
        view.showProgress()
        val service: IrishRailService = RetrofitInstance.getInstance().create(
            IrishRailService::class.java
        )
        val mapper = TrainUiModelMapper(resources)

        addDisposable(
            service.getStationsByCode(stationCode)
                .map { it.stationDataList }
                .flatMapPublisher { Flowable.fromIterable(it) }
                .map { mapper.mapTrainUiModel(it) }
                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    view.apply {
                        hideProgress()
                        displayTrains(response)
                    }
                }, this::handleError)
        )
    }

}