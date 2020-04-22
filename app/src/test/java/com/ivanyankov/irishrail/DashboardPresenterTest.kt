package com.ivanyankov.irishrail

import com.ivanyankov.irishrail.data.enums.TrainType
import com.ivanyankov.irishrail.ui.dashboard.DashboardContract
import com.ivanyankov.irishrail.ui.dashboard.DashboardPresenter
import com.nhaarman.mockitokotlin2.inOrder
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DashboardPresenterTest {

    @Mock
    lateinit var view: DashboardContract.View

    private lateinit var dashboardPresenter: DashboardPresenter

    @Before
    fun before() {
        dashboardPresenter = DashboardPresenter()
        dashboardPresenter.attachView(view)
    }

    @Test
    fun onStationAllClicked() {
        dashboardPresenter.onStationsAllClicked()

        inOrder(view) {
            verify(view).openAllStationsActivity()
            verifyNoMoreInteractions()
        }
    }

    @Test
    fun onGoToTrainTypeAllClicked() {
        dashboardPresenter.onGoToTrainTypeClicked(TrainType.TRAIN_ALL)

        inOrder(view) {
            verify(view).openTrainActivityWithTypeAll()
            verifyNoMoreInteractions()
        }
    }

    @Test
    fun onGoToTrainTypeMainlineClicked() {
        dashboardPresenter.onGoToTrainTypeClicked(TrainType.TRAIN_MAINLINE)

        inOrder(view) {
            verify(view).openTrainActivityWithTypeMainline()
            verifyNoMoreInteractions()
        }
    }

    @Test
    fun onGoToTrainTypeSuburbanClicked() {
        dashboardPresenter.onGoToTrainTypeClicked(TrainType.TRAIN_SUBURBAN)

        inOrder(view) {
            verify(view).openTrainActivityWithTypeSuburban()
            verifyNoMoreInteractions()
        }
    }

    @Test
    fun onGoToTrainTypeDartClicked() {
        dashboardPresenter.onGoToTrainTypeClicked(TrainType.TRAIN_DART)

        inOrder(view) {
            verify(view).openTrainActivityWithTypeDart()
            verifyNoMoreInteractions()
        }
    }
}
