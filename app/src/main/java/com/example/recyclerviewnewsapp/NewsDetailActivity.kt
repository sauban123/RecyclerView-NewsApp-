package com.example.recyclerviewnewsapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class NewsDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_news_detail)

        val heading = intent.getStringExtra("heading")
        val newsContent = intent.getStringExtra("newscontent")
        val imageId = intent.getIntExtra("imageId", R.drawable.img1)

        val headingTv = findViewById<TextView>(R.id.newsHeading)
        val headingIv = findViewById<ImageView>(R.id.newsImage)
        val newsContentTv = findViewById<TextView>(R.id.newsContent)

        headingTv.text = heading
        newsContentTv.text = newsContent
        headingIv.setImageResource(imageId)

    }
}