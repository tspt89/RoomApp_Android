package com.tspt.roomapp.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tspt.roomapp.data.User
import com.tspt.roomapp.databinding.CustomRowBinding

class ListAdapter : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    private var users = emptyList<User>()

    inner class ViewHolder(private val binding : CustomRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindView(user: User){
            binding.textView.text = user.id.toString()
            binding.firstNameTV.text = user.firstName
            binding.lastNameTV.text = user.lastName
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        CustomRowBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(users[position])
    }

    override fun getItemCount(): Int = users.size

    fun setData(u : List<User>){
        this.users = u
        notifyDataSetChanged()
    }
}