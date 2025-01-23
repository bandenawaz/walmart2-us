package com.example.userprofilemanagement

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.userprofilemanagement.data.model.UserProfile

//data class UserProfile(val name: String, val email: String)

class UserProfileAdapter(val userList: MutableList<UserProfile>): RecyclerView.Adapter<UserProfileAdapter.UserProfileViewHolder>() {

    class UserProfileViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val nameTextView: TextView = itemView.findViewById(R.id.textViewName)
        val emailTextView: TextView = itemView.findViewById(R.id.textViewEmail)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserProfileViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user_profile, parent, false)
        return UserProfileViewHolder(view)
    }



    override fun onBindViewHolder(holder: UserProfileViewHolder, position: Int) {

        val userProfile = userList[position]
        holder.nameTextView.text = userProfile.userName
        holder.emailTextView.text = userProfile.userEmail
    }

    override fun getItemCount(): Int {

        return userList.size
    }
}