package com.example.recyclerviewnewsapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {


    lateinit var myRecyclerView: RecyclerView
    lateinit var newsArrayList : ArrayList<News>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        myRecyclerView = findViewById(R.id.recyclerView)

        val newsImageArray = arrayOf(
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6,
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
        )

        val newsHeadingArray = arrayOf(
            "Police say terror suspect was inspired by Zakir Naik; behind BJP office blast",
            "The next Anna Wintour? LinkedIn users think they know who it should be",
            "‘Free-good promises don’t work’: Ex-AOC supporter sounds alarm for Mamdani",
            "Historic! Neeraj Chopra clinches inaugural NC Classic title with 86.18m throw",
            "Viral: Reddit post reveals how sweat stains trigger TSA body scanners",
            "India plans supersonic firepower upgrade: IAF eyes Israeli AIR LORA missile",
            "Patna Sahib declares Sukhbir Badal ‘tankhaiya’: Accused of ignoring summons",
            "Police say terror suspect was inspired by Zakir Naik; behind BJP office blast",
            "The next Anna Wintour? LinkedIn users think they know who it should be",
            "‘Free-good promises don’t work’: Ex-AOC supporter sounds alarm for Mamdani",
            "Historic! Neeraj Chopra clinches inaugural NC Classic title with 86.18m throw"
        )

        val newsContent = arrayOf(
            getString(R.string.news_content), getString(R.string.news_content),
            getString(R.string.news_content), getString(R.string.news_content),
            getString(R.string.news_content), getString(R.string.news_content),
            getString(R.string.news_content), getString(R.string.news_content),
            getString(R.string.news_content), getString(R.string.news_content)
        )
        // to set hav bhav of items inside recyclerview, vertcially scrolling, horizontally, uniform grid
        myRecyclerView.layoutManager = LinearLayoutManager(this)
        newsArrayList = arrayListOf<News>()

        for( index in newsImageArray.indices){
            val news = News(newsHeadingArray[index], newsImageArray[index], newsContent[index])
            newsArrayList.add(news)
        }

        var myAdapter = MyAdapter(newsArrayList, this)
        myRecyclerView.adapter = myAdapter
        myAdapter.setOnItemClickListener(object : MyAdapter.onItemClickListener {
            override fun onItemClicking(position: Int) {
                // on clicking each item , what action do you want to perform

                val intent = Intent(this@MainActivity, NewsDetailActivity::class.java)
                intent.putExtra("heading", newsArrayList[position].newsHeading)
                intent.putExtra("imageId", newsArrayList[position].newsImage)
                intent.putExtra("newscontent", newsArrayList[position].newsContent)
                startActivity(intent)
            }

        })

    }
}