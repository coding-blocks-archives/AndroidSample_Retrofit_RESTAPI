package com.codingblocks.restapi.utils.kotlin

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by championswimmer on 12/07/17.
 */

fun <T> callback(fn: (Throwable?, Response<T>?) -> Unit): Callback<T> {
    return object : Callback<T> {
        override fun onResponse(call: Call<T>, response: retrofit2.Response<T>) = fn(null, response)
        override fun onFailure(call: Call<T>, t: Throwable) = fn(t, null)
    }
}

abstract class VersatileHolder<ObType>(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    abstract fun bindView(obj: ObType, itemView: View)
}


fun <ObjType> createAdapter (
        dataUpdate: (ObjType, View) -> Unit,
        itemLayoutId: Int,
        objList: ArrayList<ObjType>)
        : RecyclerView.Adapter<VersatileHolder<ObjType>> {

    return object: RecyclerView.Adapter<VersatileHolder<ObjType>> () {

        var itemList = objList

        override fun onBindViewHolder(holder: VersatileHolder<ObjType>, position: Int) {
            holder.bindView(objList[position], holder.itemView)
        }

        override fun getItemCount(): Int = itemList.size

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VersatileHolder<ObjType> =
                object: VersatileHolder<ObjType>(LayoutInflater.from(parent.context).inflate(
                        itemLayoutId, parent, false
                )) {
                    override fun bindView(obj: ObjType, itemView: View) {
                        dataUpdate(obj, itemView)
                    }
                }

    }
}