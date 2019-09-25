package com.gk.newsapp.presentation.user

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.gk.newsapp.R
import com.gk.newsapp.core.IntentKey
import com.gk.newsapp.core.ext.concatLastName
import com.gk.newsapp.db.User


class UserAdapter internal constructor(private val userList: List<User>) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.row_user,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val data = userList[position]
        holder.tvName.text = data.lastName?.let { data.firstName?.concatLastName(it) }
        holder.tvEmail.text = data.email
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tvName)
        val tvEmail: TextView = itemView.findViewById(R.id.tvEmail)
        val ivEdit: ImageView = itemView.findViewById(R.id.ivEdit)

        init {
            ivEdit.setOnClickListener {
                val intent = Intent(
                    itemView.context,
                    EditUserActivity::class.java
                )
                intent.putExtra(IntentKey.PARAM_ONE, userList.get(adapterPosition))
                itemView.context.startActivity(intent)

            }
        }
    }
}
