package com.ivanyankov.irishrail.ui.trains.all

import android.content.res.Resources
import com.ivanyankov.irishrail.data.RetrofitInstance
import com.ivanyankov.irishrail.data.enums.TrainType
import com.ivanyankov.irishrail.data.service.IrishRailService
import com.ivanyankov.irishrail.ui.BasePresenter
import com.ivanyankov.irishrail.ui.trains.uimodel.TrainUiModelMapper
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers

class TrainsPresenter : BasePresenter<TrainsContract.View>(), TrainsContract.Presenter {

    override fun loadTrains(trainType: TrainType, resources: Resources) {
        view.showProgress()
        val service: IrishRailService = RetrofitInstance.getInstance().create(
            IrishRailService::class.java
        )
        val mapper = TrainUiModelMapper(resources)

        addDisposable(
            service.getTrainsByType(trainType.type)
                .map { it.trainPositionList }
                .flatMapPublisher { Flowable.fromIterable(it) }
                .map { mapper.mapTrainUiModel(it) }
                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    view.hideProgress()
                    view.displayTrains(response)
                }, this::handleError)
        )
    }
}