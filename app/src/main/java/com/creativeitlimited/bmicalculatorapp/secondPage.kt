package com.creativeitlimited.bmicalculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.creativeitlimited.bmicalculatorapp.databinding.ActivityMainBinding
import com.creativeitlimited.bmicalculatorapp.databinding.ActivitySecondPageBinding
import java.math.RoundingMode

class secondPage : AppCompatActivity() {
    private lateinit var binding:ActivitySecondPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySecondPageBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val result=intent.getDoubleExtra("Result",0.0)
        binding.textBmiResult.text="BMI: ${result.toBigDecimal().setScale(2, RoundingMode.CEILING)}"

        if (result>25){
            binding.status.text="Your are overweight!"
        }else if (result<18){
            binding.status.text="Your are underweight!"
        }else{
            "Your are healthy,Enjoy your life!"
        }

        binding.backBtn.setOnClickListener { onBackPressed() }

        }


    }