package com.snapnoob.myapplication

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PhotosAdapter : RecyclerView.Adapter<PhotosAdapter.ViewHolder>() {

    private lateinit var photoUrls: List<String>

    @SuppressLint("NotifyDataSetChanged")
    fun setData(photoUrls: List<String>) {
        this.photoUrls = photoUrls
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_photo, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding(photoUrls[position])
    }

    override fun getItemCount(): Int = photoUrls.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun binding(url: String) {
            val imageView = itemView.findViewById<ImageView>(R.id.imgPhotos)

            Glide.with(itemView)
                .load(url)
                .centerCrop()
                .into(imageView)
        }
    }
}