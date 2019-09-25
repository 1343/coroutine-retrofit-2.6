package com.gk.newsapp.core.base

import android.os.Bundle
import android.view.MenuItem
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.gk.newsapp.R

abstract class BaseActivity : AppCompatActivity() {

    @LayoutRes
    protected abstract fun getLayout(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        initView()
    }

    protected abstract fun initView()

    protected fun setToolbarTitle(title: String) {
        val mToolbar = findViewById<Toolbar>(R.id.toolbar2)
        mToolbar.title = title
        mToolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.colorTextWhite))
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_24dp)
        setSupportActionBar(mToolbar)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }


}