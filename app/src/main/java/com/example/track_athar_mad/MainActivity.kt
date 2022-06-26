package com.example.track_athar_mad

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    // creating variables for
    // edit texts and button.
    var sourceEdt: EditText? = null
    var destinationEdt: EditText? = null
  var trackBtn: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var trackBtn: Button = findViewById(R.id.track)


      val source: String = R.id.idEdtSource.toString()
        val destination: String = R.id.idEdtDestination.toString()

        trackBtn.setOnClickListener(View.OnClickListener { drawTrack(source, destination) })


    }

    private fun drawTrack(source: String, destination: String) {
        try {
            // create a uri
            val uri = Uri.parse("https://www.google.co.in/maps/dir/$source/$destination")

            // initializing a intent with action view.
            val i = Intent(Intent.ACTION_VIEW, uri)

            // below line is to set maps package name
            i.setPackage("com.google.android.apps.maps")

            // below line is to set flags
            i.flags = Intent.FLAG_ACTIVITY_NEW_TASK

            // start activity
            startActivity(i)
        } catch (e: ActivityNotFoundException) {
            // when the google maps is not installed on users device
            // we will redirect our user to google play to download google maps.
            val uri =
                Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.maps")

            // initializing intent with action view.
            val i = Intent(Intent.ACTION_VIEW, uri)

            // set flags
            i.flags = Intent.FLAG_ACTIVITY_NEW_TASK

            // to start activity
            startActivity(i)
        }
    }
}