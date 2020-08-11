package com.hemendra.wallpaperskotlin

import android.app.WallpaperManager
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    var images = arrayOf(R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5,R.drawable.img6,R.drawable.img7,R.drawable.img8,R.drawable.img9,R.drawable.img10)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        var position = intent.getIntExtra("position",0)

        iv_detail.setImageResource(images[position])

        btn_set_wallpaper.setOnClickListener {
            /*var bitmap :Bitmap = BitmapFactory.decodeResource(resources,images[position])*/

            var wallpapaermanger =WallpaperManager.getInstance(this@DetailActivity)
            wallpapaermanger.setResource(images[position])
            Toast.makeText(this@DetailActivity,"wallpaer set!!",Toast.LENGTH_SHORT).show()
        }
    }
}