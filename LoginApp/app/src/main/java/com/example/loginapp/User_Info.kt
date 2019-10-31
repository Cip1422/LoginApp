package com.example.loginapp

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import kotlinx.android.synthetic.main.activity_user__info.*

class User_Info : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user__info)

        val userMade: User = intent?.getParcelableExtra("name_key") as User

        userMade.let { user ->
            val string = "${user.name}  ${user.phone}   ${user.email}"
            infotxt.text = string

            val picname = "${user.name}"
            profiletxt.text = picname

        }

        camera_button.setOnClickListener { _ ->
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(cameraIntent, 777)
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 777 && resultCode == Activity.RESULT_OK) {
            val bitmap: Bitmap = (data?.extras?.get("data") as Bitmap)
            my_imageview.setImageBitmap(bitmap)
        }
    }

}
