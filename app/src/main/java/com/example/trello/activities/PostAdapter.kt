package com.example.trello.activities

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.trello.R
import kotlinx.android.synthetic.main.item_board.view.*

class PostAdapter(val post: ArrayList<String>) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txt_name_rv: TextView = itemView.findViewById(R.id.txt_name_rv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostAdapter.ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_board, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostAdapter.ViewHolder, position: Int) {
        holder.txt_name_rv.text = post[position]
    }
    override fun getItemCount() : Int{return post.size}

    private class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }
}