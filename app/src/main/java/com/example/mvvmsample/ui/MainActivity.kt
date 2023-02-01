package com.example.mvvmsample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmsample.R
import com.example.mvvmsample.databinding.ActivityMainBinding
import com.example.mvvmsample.ui.base.BaseActivity
import com.example.mvvmsample.utils.LoadingStatusType
import com.example.mvvmsample.viewmodels.MedicineViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private lateinit var medicineViewModel: MedicineViewModel

    override fun setActivityLayout(): Int = R.layout.activity_main

    override fun initialize(savedInstanceState: Bundle?) {

        medicineViewModel = ViewModelProvider(this)[MedicineViewModel::class.java]

        bindings().textView.setOnClickListener {
            medicineViewModel.getMedicineList()
        }

        observeLiveData()
    }

    /**
     * Method to return Data binding associated with current class
     */
    private fun bindings() = mDataBinding as ActivityMainBinding

    private fun observeLiveData() {
        medicineViewModel.medicineLiveData.observe(this, {
            Log.d("paras", "List size: "+it.size)
        })

        medicineViewModel.loadingStatusLiveData.observe(this, {
            when(it){
                is LoadingStatusType.Loading -> showProgressBar()
                is LoadingStatusType.Loaded -> hideProgressLoader()
            }
        })

        medicineViewModel.responseErrorLiveData.observe(this, {

        })
    }

}