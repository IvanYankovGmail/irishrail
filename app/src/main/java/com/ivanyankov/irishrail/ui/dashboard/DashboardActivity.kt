package com.ivanyankov.irishrail.ui.dashboard

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.ivanyankov.irishrail.R
import com.ivanyankov.irishrail.data.enums.TrainType
import com.ivanyankov.irishrail.databinding.ActivityDashboardBinding
import com.ivanyankov.irishrail.ui.BaseActivity
import com.ivanyankov.irishrail.ui.stations.StationsActivity
import com.ivanyankov.irishrail.ui.trains.all.TrainsActivity

class DashboardActivity : BaseActivity<DashboardContract.View, DashboardContract.Presenter>(),
    DashboardContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityDashboardBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_dashboard)
        presenter = DashboardPresenter()
        presenter.attachView(this)
        binding.presenter = presenter
    }

    override fun openAllStationsActivity() {
        StationsActivity.start(this)
    }

    override fun openTrainActivityWithTypeAll() {
        TrainsActivity.start(this, TrainType.TRAIN_ALL)
    }

    override fun openTrainActivityWithTypeMainline() {
        TrainsActivity.start(this, TrainType.TRAIN_MAINLINE)
    }

    override fun openTrainActivityWithTypeSuburban() {
        TrainsActivity.start(this, TrainType.TRAIN_SUBURBAN)
    }

    override fun openTrainActivityWithTypeDart() {
        TrainsActivity.start(this, TrainType.TRAIN_DART)
    }
}
