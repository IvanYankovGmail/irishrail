package com.ivanyankov.irishrail

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed

class DashboardRobot {

    fun assertDashboardIsDisplayed(): DashboardRobot {
        onView(ALL_STATIONS_TEXT_MATCHER).check(matches(isDisplayed()))
        onView(ALL_TRAINS_TEXT_MATCHER).check(matches(isDisplayed()))

        return this
    }

    fun clickOnAllStations(): DashboardRobot {
        onView(ALL_STATIONS_TEXT_MATCHER).perform(click())

        return this
    }

    companion object {
        private val ALL_STATIONS_TEXT_MATCHER = ViewMatchers.withId(R.id.tv_all_stations)
        private val ALL_TRAINS_TEXT_MATCHER = ViewMatchers.withId(R.id.tv_running_trains)
    }
}