package com.snapnoob.myapplication

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.snapnoob.myapplication.databinding.ActivityGalleryBinding

class GalleryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGalleryBinding
    private lateinit var view: View

    private val galleryAdapter: GalleryAdapter by lazy { GalleryAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGalleryBinding.inflate(layoutInflater)
        view = binding.root
        setContentView(view)
        initView()
    }

    private fun initView() {
        val data = DataGenerator.createGalleryData()
        binding.rvGallery.apply {
            layoutManager = LinearLayoutManager(this@GalleryActivity, LinearLayoutManager.VERTICAL, false)
            adapter = galleryAdapter
            galleryAdapter.setData(data)
        }.also { it.scrollToPosition(0) }
    }
}