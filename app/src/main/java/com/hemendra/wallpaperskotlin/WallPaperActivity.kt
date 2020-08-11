package com.hemendra.wallpaperskotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_wall_paper.*

var images = arrayOf(R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5,R.drawable.img6,R.drawable.img7,R.drawable.img8,R.drawable.img9,R.drawable.img10)

class WallPaperActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wall_paper)
        gv.adapter = GridviewAdapter(this@WallPaperActivity, images)

         gv.setOnItemClickListener { adapterView, view, position, l ->

             var intent = Intent(this@WallPaperActivity,DetailActivity::class.java)
             intent.putExtra("position",position)
             startActivity(intent)
         }
    }
}