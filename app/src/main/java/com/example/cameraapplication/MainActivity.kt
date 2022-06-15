package com.example.cameraapplication

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.ACTION_IMAGE_CAPTURE
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    lateinit var image1:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var button1:Button=findViewById(R.id.click)
        image1=findViewById(R.id.imageview1)
        button1.setOnClickListener {
            var intent:Intent= Intent(ACTION_IMAGE_CAPTURE)
            // startActivity(intent)
            startActivityForResult(intent,100)


        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==100){
            var bitmap:Bitmap= data!!.extras!!.get("data") as Bitmap
            image1.setImageBitmap(bitmap)
        }

    }
}
