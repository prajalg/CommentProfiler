package com.example.commentprofiler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.core.view.get
import com.example.commentprofiler.databinding.ActivityHomeBinding

class Home : AppCompatActivity(),AdapterView.OnItemSelectedListener {
    private lateinit var binding : ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Spinner element
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Spinner click listener
        binding.spinner.onItemClickListener

        // Spinner Drop down elements
        val categories : ArrayList<String> = ArrayList()
        categories.add("All comments")
        categories.add("Positive comments")
        categories.add("Negative comments")
        categories.add("Questions")
        categories.add("Toxic")


        // Creating adapter for spinner
        val dataAdapter : ArrayAdapter<String> = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories)

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // attaching data adapter to spinner
        binding.spinner.adapter = dataAdapter
    }

    @Override
    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
       val item = p0?.selectedItem.toString()
        binding.textView.text = item
    }
    @Override
    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}