package com.codingblocks.restapi.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.codingblocks.restapi.R
import com.codingblocks.restapi.models.User

import java.util.ArrayList

/**
 * Created by championswimmer on 12/07/17.
 */

class UsersAdapter(private var users: ArrayList<User>?) : RecyclerView.Adapter<UsersAdapter.UserViewHolder>() {

    fun setUsers(users: ArrayList<User>) {
        this.users = users
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val li = LayoutInflater.from(parent.context)
        return UserViewHolder(li.inflate(R.layout.list_item_user, parent, false))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bindView(users!![position])
    }

    override fun getItemCount(): Int {
        return users!!.size
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvUserName: TextView
        var tvUserUsername: TextView
        var tvUserPhone: TextView
        var tvUserEmail: TextView

        init {
            tvUserEmail = itemView.findViewById<View>(R.id.tvUserEmail) as TextView
            tvUserUsername = itemView.findViewById<View>(R.id.tvUserUsername) as TextView
            tvUserName = itemView.findViewById<View>(R.id.tvUserName) as TextView
            tvUserPhone = itemView.findViewById<View>(R.id.tvUserPhone) as TextView
        }

        fun bindView(user: User) {
            tvUserPhone.text = user.phone
            tvUserEmail.text = user.email
            tvUserUsername.text = user.username
            tvUserName.text = user.name
        }
    }
}
