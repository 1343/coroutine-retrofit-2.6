package com.gk.newsapp.core.base

import android.os.Bundle

abstract class MVVMBaseActivity<R : BaseRepo, T : BaseViewModel<R>> : BaseActivity() {


    protected lateinit var viewModel: T

    protected abstract fun getViewMoel(): T

    override fun onCreate(savedInstanceState: Bundle?) {
        viewModel = getViewMoel()
        super.onCreate(savedInstanceState)

    }

}