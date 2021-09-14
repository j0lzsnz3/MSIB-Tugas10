package com.snapnoob.myapplication

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GalleryAdapter : RecyclerView.Adapter<GalleryAdapter.ViewHolder>() {

    private lateinit var photoCollections: List<PhotoCollection>

    @SuppressLint("NotifyDataSetChanged")
    fun setData(photoCollections: List<PhotoCollection>) {
        this.photoCollections = photoCollections
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_gallery, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding(photoCollections[position])
    }

    override fun getItemCount(): Int = photoCollections.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun binding(photoCollection: PhotoCollection) {
            val context = itemView.context
            val tvDate = itemView.findViewById<TextView>(R.id.tvPhotoDate)
            val rvPhotos = itemView.findViewById<RecyclerView>(R.id.rvPhotos)

            tvDate.text = photoCollection.date

            rvPhotos.apply {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                val photosAdapter = PhotosAdapter()
                adapter = photosAdapter
                photosAdapter.setData(photoCollection.imageUrls)
            }
        }
    }
}