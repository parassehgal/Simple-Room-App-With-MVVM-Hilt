package com.example.mvvmsample.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.mvvmsample.R

/**
 * Base class for all the activities
 * Created by paras Sehgal
 */
abstract class BaseActivity: AppCompatActivity() {

    private var alertDialogProgress: AlertDialog? = null
    lateinit var mDataBinding: ViewDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mDataBinding = DataBindingUtil.setContentView(this, setActivityLayout())
        initialize(savedInstanceState)
    }

    /**
     * Method to set layout xml
     *
     * @return layout id
     */
    abstract fun setActivityLayout(): Int

    /**
     * Method to initialize the class data
     *
     * @param savedInstanceState - savedInstanceState
     */
    abstract fun initialize(savedInstanceState: Bundle?)

    /**
     * Method to show progress loader
     */
     fun showProgressBar() {
         if (alertDialogProgress == null) {
             var alertDialogBuilderProgress: AlertDialog.Builder? = null
             val li = LayoutInflater.from(this)
             val promptsView: View = li.inflate(R.layout.progress_bar_layout, null)
             alertDialogBuilderProgress = AlertDialog.Builder(
                 this
             )
             alertDialogBuilderProgress.setView(promptsView)
             alertDialogBuilderProgress
                 .setCancelable(false)

             // create alert dialog
             alertDialogProgress = alertDialogBuilderProgress.create()
             alertDialogProgress!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
             alertDialogProgress!!.setContentView(R.layout.progress_bar_layout)
             alertDialogProgress!!.window!!.setBackgroundDrawable(null)
         }

        // show it
        alertDialogProgress!!.show()
    }

    /**
     * Method to hide progress loader
     */
    fun hideProgressLoader() {
        if (alertDialogProgress != null && alertDialogProgress!!.isShowing) {
            alertDialogProgress?.dismiss()
        }
    }

}