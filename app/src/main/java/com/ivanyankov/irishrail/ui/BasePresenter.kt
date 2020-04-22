package com.ivanyankov.irishrail.ui

import androidx.annotation.CallSuper
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import java.net.UnknownHostException

abstract class BasePresenter<V : MvpContract.View> :
    MvpContract.Presenter<V> {

    private val disposableBag: CompositeDisposable = CompositeDisposable()
    protected lateinit var view: V

    override fun attachView(toBeAttachedView: V) {
        view = toBeAttachedView
    }

    protected fun addDisposable(disposable: Disposable) = disposableBag.add(disposable)

    @CallSuper
    override fun cleanUp() = disposableBag.clear()

    protected fun handleError(throwable: Throwable) {
        view.hideProgress()
        if (throwable is UnknownHostException) {
            view.showNoInternetConnection()
        } else {
            view.showSomethingWentWrong()
        }
    }
}