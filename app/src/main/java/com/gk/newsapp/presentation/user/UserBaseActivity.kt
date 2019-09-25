package com.gk.newsapp.presentation.user

import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.gk.newsapp.R
import com.gk.newsapp.core.base.MVVMBaseActivity
import com.gk.newsapp.core.ext.showToast
import com.gk.newsapp.db.User
import kotlinx.android.synthetic.main.activity_add_user.*

open class UserBaseActivity : MVVMBaseActivity<UserRepo, UserViewModel>() {


    override fun getLayout(): Int {
        return R.layout.activity_add_user
    }

    override fun initView() {
        setToolbarTitle(getString(R.string.add_user))
        viewModel.getUserObserver().observe(this, object : Observer<String> {
            override fun onChanged(t: String) {
                showToast(t)
                if (t.equals("Success")) {
                    finish()
                }

            }

        })
        btnSubmit.setOnClickListener {

        }

    }

    override fun getViewMoel(): UserViewModel {
        return ViewModelProviders.of(this).get(UserViewModel::class.java)
    }

    fun getUser(userID: Int? = null): User {
        return User(
            userID, etFirstName.text.toString(),
            etSecondName.text.toString(),
            etEmail.text.toString()
        )
    }

}
