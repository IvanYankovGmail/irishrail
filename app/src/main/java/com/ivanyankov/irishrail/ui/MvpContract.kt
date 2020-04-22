package com.ivanyankov.irishrail.ui

interface MvpContract {

    interface View {

        fun showProgress()

        fun hideProgress()

        fun showNoInternetConnection()

        fun showSomethingWentWrong()
    }

    interface Presenter<V : View> {

        fun attachView(toBeAttachedView: V)

        fun cleanUp()
    }
}