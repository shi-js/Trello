package com.example.trello.activities.adapters

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.trello.R
import com.example.trello.activities.models.Board
import kotlinx.android.synthetic.main.item_board.view.*

open class BoardItemAdapter(private val context: Context,
        private var list: ArrayList<Board>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>(), Parcelable {

    private var onClickListener: OnClickListener? = null

    constructor(parcel: Parcel) : this(
        TODO("context"),
        TODO("list")
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BoardItemAdapter> {
        override fun createFromParcel(parcel: Parcel): BoardItemAdapter {
            return BoardItemAdapter(parcel)
        }

        override fun newArray(size: Int): Array<BoardItemAdapter?> {
            return arrayOfNulls(size)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.item_board,
                parent,
                false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val model = list[position]
        if(holder is MyViewHolder){
            Glide
                .with(context)
                .load(model.image)
                .centerCrop()
                .placeholder(R.drawable.ic_board_place_holder)
                .into(holder.itemView.iv_board_image)

            holder.itemView.tv_name.text = model.name
            holder.itemView.tv_created_by.text = "Created by: ${model.createdBy}"

            holder.itemView.setOnClickListener{

                if(onClickListener != null){
                    onClickListener!!.onClick(position,model)
                }

            }
        }
    }

    interface  OnClickListener{
        fun onClick(position: Int, model: Board)
    }

   private class MyViewHolder(view:View) : RecyclerView.ViewHolder(view)

    override fun getItemCount(): Int {
        return list.size
    }

}