package com.example.detailactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.detailactivity.databinding.ActivityListDetailBinding
import com.example.detailactivity.databinding.ActivityMainBinding

class ListDetailActivity : AppCompatActivity() {
   private var binding:ActivityListDetailBinding? = null
    private var logo = 0
    private var name:String? = null
    private var fact:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListDetailBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        logo = intent.getIntExtra(FunFactAdapter.LOGO_EXTRAs,0)
        name = intent.getStringExtra(FunFactAdapter.NAME_EXTRAs)
        fact = intent.getStringExtra(FunFactAdapter.FACT_EXTRAs)

        setupDetailFact()
    }

    private fun setupDetailFact() {
        binding?.nameTextView?.text = fact
        binding?.logoImageView?.setImageResource(logo)
        title = name

    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}