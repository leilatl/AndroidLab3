package com.example.lab3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        senderDetail.text = "from: "+ intent.getStringExtra("sender")
        titleDetail.text = "title: "+ intent.getStringExtra("title")
        textDetail.text = "text: "+intent.getStringExtra("text")
    }
}