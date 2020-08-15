package com.hemendra.wallpaperskotlin

import android.Manifest
import android.app.WallpaperManager
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_detail.*
import java.io.File
import java.io.FileOutputStream

class DetailActivity : AppCompatActivity() {
    var images = arrayOf(R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5,R.drawable.img6,R.drawable.img7,R.drawable.img8,R.drawable.img9,R.drawable.img10)
    var position:Int=0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        position = intent.getIntExtra("position",0)

        iv_detail.setImageResource(images[position])

        btn_set_wallpaper.setOnClickListener {
            var wallpapaermanger =WallpaperManager.getInstance(this@DetailActivity)
            wallpapaermanger.setResource(images[position])
            Toast.makeText(this@DetailActivity,"wallpaer set!!",Toast.LENGTH_SHORT).show()
        }
      btn_bookmark.setOnClickListener {



          var status = ContextCompat.checkSelfPermission(this@DetailActivity, Manifest.permission.WRITE_EXTERNAL_STORAGE)
          if(status == PackageManager.PERMISSION_GRANTED) {
              saveimage(images[position], position)
          }
          else{
              ActivityCompat.requestPermissions(this@DetailActivity, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),123)
          }
      }


    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if(grantResults[0]==PackageManager.PERMISSION_GRANTED)
        {
            saveimage(images[position],position)
        }
    }
     fun saveimage(image:Int,pos:Int)
     {
         var drawable = applicationContext.resources.getDrawable(image)
         var bitmap = (drawable as BitmapDrawable).bitmap
         var file= File("/storage/emulated/0/TestFolder/test$pos.png")

         try {
             var outputStream = FileOutputStream(file)
             bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
             outputStream.flush()
             outputStream.close()
         }catch (e:Exception)
         {
             e.printStackTrace()
         }
         Toast.makeText(this@DetailActivity,"added to bookmarks",Toast.LENGTH_SHORT).show()
     }

}