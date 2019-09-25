package com.gk.newsapp.presentation.user

import kotlinx.android.synthetic.main.activity_add_user.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddUserActivity : UserBaseActivity() {

    override fun initView() {
        super.initView()
        btnSubmit.setOnClickListener {
            viewModel.addUser(getUser())
        }
    }
}
