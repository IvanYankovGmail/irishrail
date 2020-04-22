package com.ivanyankov.irishrail

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.ivanyankov.irishrail.ui.dashboard.DashboardActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ExampleUiTest {

    @JvmField
    @Rule
    var rule = ActivityTestRule(DashboardActivity::class.java)

    @Test
    fun testGoToAllStations() {
        DashboardRobot()
            .assertDashboardIsDisplayed()
            .clickOnAllStations()
    }
}
