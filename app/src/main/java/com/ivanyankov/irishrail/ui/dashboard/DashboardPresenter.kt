package com.ivanyankov.irishrail.ui.dashboard

import com.ivanyankov.irishrail.data.enums.TrainType
import com.ivanyankov.irishrail.ui.BasePresenter

class DashboardPresenter : BasePresenter<DashboardContract.View>(), DashboardContract.Presenter {

    override fun onStationsAllClicked() = view.openAllStationsActivity()

    override fun onGoToTrainTypeClicked(type: TrainType) {
        when (type) {
            TrainType.TRAIN_ALL -> view.openTrainActivityWithTypeAll()
            TrainType.TRAIN_MAINLINE -> view.openTrainActivityWithTypeMainline()
            TrainType.TRAIN_SUBURBAN -> view.openTrainActivityWithTypeSuburban()
            TrainType.TRAIN_DART -> view.openTrainActivityWithTypeDart()
        }
    }
}