package com.codingblocks.restapiretrofitjson.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codingblocks.restapiretrofitjson.R
import com.codingblocks.restapiretrofitjson.interfaces.OnItemClickListener
import com.codingblocks.restapiretrofitjson.models.User
import kotlinx.android.synthetic.main.list_item_user.view.*
import java.util.*

/**
 * Created by championswimmer on 29/06/17.
 */

class UserAdapter(private val context: Context,
                  private var users: ArrayList<User>?)
    : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    internal var onItemClickListener: OnItemClickListener? = null

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        this.onItemClickListener = onItemClickListener
    }

    fun updateUsers(newUserList: ArrayList<User>) {
        this.users = newUserList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_user, parent, false)

        return UserViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bindUser(users!![position])
    }

    override fun getItemCount(): Int {
        return users!!.size
    }

    inner class UserViewHolder(
            public var thisView: View
    ) : RecyclerView.ViewHolder(thisView) {

        fun bindUser(user: User) {
            thisView.tvUserUsername.text = user.username
            thisView.tvUserName.text = user.name
            thisView.tvUserPhone.text = user.phone
            thisView.tvUserEmail.text = user.email
            thisView.btnUserPosts.setOnClickListener {
                onItemClickListener?.onItemClick(user.id,
                        itemView.btnUserPosts)
            }
            thisView.btnUserComments.setOnClickListener {
                onItemClickListener?.onItemClick(user.id,
                        itemView.btnUserComments)
            }

        }

    }

    companion object {

        val TAG = "UA"
    }
}
