package com.example.astux7.note

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class AddNotes : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_notes)
    }

    fun buAdd(view:View){
        //close the activity if someone is done
        //finish()
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
