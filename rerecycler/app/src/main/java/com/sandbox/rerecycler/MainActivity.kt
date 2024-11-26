package com.sandbox.rerecycler

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.sandbox.rerecycler.databinding.ActivityMainBinding
import com.sandbox.rerecycler.entity.City
import com.sandbox.rerecycler.entity.Country

class MainActivity : AppCompatActivity() {

    private var _vb: ActivityMainBinding? = null
    private val vb get() = _vb!!

    private val listToShow: List<Country> = listOf(
        Country(
            name = "Australia",
            cities = listOf(
                City(name = "Sydney", population = 5.3f),
                City(name = "Melbourne", population = 5.1f),
                City(name = "Brisbane", population = 2.2f)
            )
        ),
        Country(
            name = "Canada",
            cities = listOf(
                City(name = "Toronto", population = 2.8f),
                City(name = "Montréal", population = 1.7f),
                City(name = "Vancouver", population = 0.6f)
            )
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _vb = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(vb.root)


    }
}