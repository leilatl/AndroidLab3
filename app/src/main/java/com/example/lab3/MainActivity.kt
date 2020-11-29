package com.example.lab3

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        sharedPreferences = getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
        val userJson = sharedPreferences.getString("user", "")
        if(userJson!!.isNotEmpty()){
            val user = Gson().fromJson(userJson, User::class.java)
            nameTV.text = "name: "+user.name
        }

        val fragmentA = MailListFragment()
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragmentA).commit()
    }


}