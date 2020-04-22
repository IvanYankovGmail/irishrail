package com.ivanyankov.irishrail.ui.stations

import com.ivanyankov.irishrail.data.RetrofitInstance
import com.ivanyankov.irishrail.data.service.IrishRailService
import com.ivanyankov.irishrail.ui.BasePresenter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class StationsPresenter : BasePresenter<StationsContract.View>(), StationsContract.Presenter {

    override fun loadStations() {
        view.showProgress()
        val service: IrishRailService = RetrofitInstance.getInstance().create(
            IrishRailService::class.java
        )

        addDisposable(
            service.getAllStations()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    view.apply {
                        hideProgress()
                        displayStations(response.stationObjectList)
                    }
                }, this::handleError)
        )
    }
}
