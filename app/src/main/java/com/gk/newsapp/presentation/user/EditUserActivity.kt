package com.gk.newsapp.presentation.user

import com.gk.newsapp.R
import com.gk.newsapp.core.IntentKey
import com.gk.newsapp.db.User
import kotlinx.android.synthetic.main.activity_add_user.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EditUserActivity : UserBaseActivity() {

    override fun initView() {
        super.initView()
        val user = intent.getParcelableExtra<User>(IntentKey.PARAM_ONE)
        etFirstName.setText(user.firstName)
        etSecondName.setText(user.lastName)
        etEmail.setText(user.email)
        btnSubmit.text = getString(R.string.edit_user)
        setToolbarTitle(getString(R.string.edit_user))
        btnSubmit.setOnClickListener {
            val user = getUser(user.uid)
            viewModel.editUser(user)

        }
    }

}
