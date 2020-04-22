package com.ivanyankov.irishrail.ui.trains.information

import com.ivanyankov.irishrail.data.RetrofitInstance
import com.ivanyankov.irishrail.data.service.IrishRailService
import com.ivanyankov.irishrail.ui.BasePresenter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class TrainInformationPresenter : BasePresenter<TrainInformationContract.View>(),
    TrainInformationContract.Presenter {

    override fun loadTrainInformation(trainCode: String, trainDate: String) {
        view.showProgress()
        val service: IrishRailService = RetrofitInstance.getInstance().create(
            IrishRailService::class.java
        )

        addDisposable(
            service.getTrainInformation(trainCode, trainDate)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    view.apply {
                        hideProgress()
                        displayTrainInformation(response.trainMovementList)
                    }
                }, this::handleError)
        )
    }
}