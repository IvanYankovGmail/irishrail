package com.ivanyankov.irishrail.ui.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.DialogFragment
import com.ivanyankov.irishrail.R

object ProgressDialog : DialogFragment() {

    const val TAG_PROGRESS_DIALOG = "progress_dialog"

    init {
        isCancelable = false
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val view: View = LayoutInflater.from(context).inflate(R.layout.view_progress_bar, null)

        return AlertDialog.Builder(context).setView(view).create()
    }
}