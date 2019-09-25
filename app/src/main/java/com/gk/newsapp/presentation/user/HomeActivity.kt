package com.gk.newsapp.presentation.user

import android.content.Intent
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gk.newsapp.R
import com.gk.newsapp.core.base.MVVMBaseActivity
import com.gk.newsapp.db.User
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class HomeActivity : MVVMBaseActivity<HomeRepo, HomeViewModel>() {

    override fun getLayout(): Int {
        return R.layout.activity_home
    }


    override fun getViewMoel(): HomeViewModel {
        return ViewModelProviders.of(this).get(HomeViewModel::class.java)
    }

    override fun initView() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar2)
        toolbar.title = getString(R.string.app_name)
        toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.colorTextWhite))
        setSupportActionBar(toolbar)
        recyclerView.layoutManager = LinearLayoutManager(this) as RecyclerView.LayoutManager?
        viewModel.getUserObserver().observe(this, object : Observer<List<User>> {
            override fun onChanged(t: List<User>?) {
                t?.let { setAdapter(it) }
            }

        })

        floatingActionButton.setOnClickListener {
            startActivity(Intent(this@HomeActivity, AddUserActivity::class.java))
        }

        pullToRefresh.isRefreshing = true

        pullToRefresh.setOnRefreshListener {
            getLatestData()
        }
        getLatestData()

    }

    private fun setAdapter(userList: List<User>) {
        recyclerView.adapter = UserAdapter(userList)
        pullToRefresh.isRefreshing = false
        tvNoItemFound.visibility = if (userList.isEmpty()) View.VISIBLE else View.GONE

    }

    private fun getLatestData() {

        viewModel.getUserList()

    }


}
