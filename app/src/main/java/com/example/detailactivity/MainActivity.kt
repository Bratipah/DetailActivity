package com.example.detailactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.detailactivity.DummyData.funFacts
import com.example.detailactivity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var binding:ActivityMainBinding? = null
    var adapter:FunFactAdapter?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setupFact()
    }

    private fun setupFact() {
        adapter = FunFactAdapter(this,DummyData.funFacts)
        binding?.factListView?.adapter =adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}