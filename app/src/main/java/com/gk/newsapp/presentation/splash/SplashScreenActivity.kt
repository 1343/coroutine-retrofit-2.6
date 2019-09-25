package com.gk.newsapp.presentation.splash

import android.content.Intent
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.gk.newsapp.R
import com.gk.newsapp.core.base.MVVMBaseActivity

class SplashScreenActivity :
    MVVMBaseActivity<SplashRepo, SplashViewModel>() {

    override fun getLayout(): Int {
        return R.layout.activity_splash_screen
    }

    override fun getViewMoel(): SplashViewModel {
        return ViewModelProviders.of(this).get(SplashViewModel::class.java)
    }

    override fun initView() {
        viewModel.navigateToHomePage().observe(this, object : Observer<Class<*>> {
            override fun onChanged(t: Class<*>?) {

                startActivity(Intent(this@SplashScreenActivity, t))
                finish()
            }

        })
    }

}
