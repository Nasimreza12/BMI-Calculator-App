package com.creativeitlimited.bmicalculatorapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.creativeitlimited.bmicalculatorapp.databinding.ActivityMainBinding
import java.math.RoundingMode

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btnCalculate.setOnClickListener {
            val height = (binding.htEdit.text.toString()).toDouble()
            val weight = (binding.wtEdit.text.toString()).toDouble()


            if (height != null && weight != null) {

                val result=calculateBmi(height,weight)
                val playIntent= Intent(this@MainActivity,secondPage::class.java)
                playIntent.putExtra("Result",result)


                startActivity(playIntent)

            } else {
                Toast.makeText(this, "Please put number height & weight", Toast.LENGTH_LONG).show()

            }
        }
    }

    private fun calculateBmi(height: Double, weight: Double):Double {
        return weight/(height *height)

    }

}
