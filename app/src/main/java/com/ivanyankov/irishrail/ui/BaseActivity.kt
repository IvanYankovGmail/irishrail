package com.ivanyankov.irishrail.ui

import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import com.ivanyankov.irishrail.R
import com.ivanyankov.irishrail.ui.dialog.ProgressDialog

abstract class BaseActivity<V : MvpContract.View, P : MvpContract.Presenter<V>> :
    AppCompatActivity(),
    MvpContract.View {

    protected lateinit var presenter: P

    override fun onStop() {
        super.onStop()

        presenter.cleanUp()
    }

    override fun showProgress() =
        ProgressDialog.showNow(supportFragmentManager, ProgressDialog.TAG_PROGRESS_DIALOG)

    override fun hideProgress() {
        val progressDialog: DialogFragment? =
            supportFragmentManager.findFragmentByTag(ProgressDialog.TAG_PROGRESS_DIALOG) as DialogFragment
        progressDialog?.dismiss()
    }

    override fun showNoInternetConnection() {
        AlertDialog.Builder(this).apply {
            setTitle(getString(R.string.no_internet_connection))
            setNeutralButton(R.string.ok) { dialogInterface, _ -> dialogInterface.dismiss() }
        }.also { it.show() }
    }

    override fun showSomethingWentWrong() {
        AlertDialog.Builder(this).apply {
            setTitle(getString(R.string.something_went_wrong))
            setNeutralButton(R.string.ok) { dialogInterface, _ -> dialogInterface.dismiss() }
        }.also { it.show() }
    }
}