package com.example.portfolioapp

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Message
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





        //since we've remove the default action bar, implement the toolbar to show on our action bar
        val toolbar =
            findViewById<Toolbar>(R.id.toolbar)
        findViewById<Toolbar>(R.id.share_item)
        setSupportActionBar(toolbar)


    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.toolbar_menu, menu)
        val menuItem = menu.findItem(R.id.share_item)

        return super.onCreateOptionsMenu(menu)



    }

    //setting on click listener on toolbar menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {


        if (item.itemId == R.id.refresh) {
            Toast.makeText(this, "Refresh Activity", Toast.LENGTH_LONG).show()
        }
        if (item.itemId == R.id.settings) {
            Toast.makeText(this, "Settings Activity", Toast.LENGTH_LONG).show()
        }

        return super.onOptionsItemSelected(item)
    }


}
