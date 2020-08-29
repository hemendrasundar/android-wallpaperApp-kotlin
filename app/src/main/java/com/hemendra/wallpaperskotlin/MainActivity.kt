package com.hemendra.wallpaperskotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_wall_paper.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         btn_wall.setOnClickListener {

             var intent = Intent(this@MainActivity,WallPaperActivity::class.java)
             startActivity(intent)
         }
        btn_fav.setOnClickListener {
            var intent = Intent(this@MainActivity,FavActivity::class.java)
            startActivity(intent)
        }
    }
}