package com.example.commentprofiler

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.commentprofiler.databinding.ActivityMainBinding
import com.google.gson.JsonElement
import com.google.gson.JsonParser
import java.io.File
import java.io.FileInputStream
import java.io.InputStreamReader


lateinit var link : String
class MainActivity : AppCompatActivity() {
    lateinit var mainBinding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        link = mainBinding.link.text.toString()
        val f = File("/Users/prajalgupta/CommentProfiler/app/src/main/Contents.json")
        mainBinding.button.setOnClickListener {
        val intent = Intent(this@MainActivity, Home::class.java)
        startActivity(intent)
    }
        }
    }