package com.sandbox.rerecycler

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.sandbox.rerecycler.databinding.ActivityMainBinding
import com.sandbox.rerecycler.entity.City
import com.sandbox.rerecycler.entity.Country
import com.sandbox.rerecycler.entity.RecyclerResponse
import com.sandbox.rerecycler.ui.CountryGalleryAdapter

class MainActivity : AppCompatActivity() {

    private var _vb: ActivityMainBinding? = null
    private val vb get() = _vb!!

    private val firstListToShow: List<Country> = listOf(
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

    private val secondListToShow: List<Country> = listOf(
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
        ),
        Country(
            name = "Japan",
            cities = listOf(
                City(name = "Tokyo", population = 9.2f),
                City(name = "Yokohama", population = 3.7f),
                City(name = "Osaka", population = 2.7f),
                City(name = "Nagoya", population = 2.3f)
            )
        ),
        Country(
            name = "South Africa",
            cities = listOf(
                City(name = "Johannesburg", population = 9.2f),
                City(name = "Cape Town", population = 4.0f),
                City(name = "Durban", population = 3.7f),
                City(name = "Pretoria", population = 2.4f)
            )
        )
    )

    private val countryListAdapter: CountryGalleryAdapter =
        CountryGalleryAdapter { item ->
            onListItemClick(item)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _vb = ActivityMainBinding.inflate(layoutInflater)

        vb.listCountries.adapter = countryListAdapter
        countryListAdapter.submitList(firstListToShow)

        vb.txtTitle.setOnClickListener {
            countryListAdapter.submitList(secondListToShow)
        }

//        enableEdgeToEdge()
        setContentView(vb.root)
    }

    private fun onListItemClick(item: RecyclerResponse) {
        when (item) {
            is RecyclerResponse.RespCity -> Snackbar.make(
                this.vb.root,
                item.value.name,
                Snackbar.LENGTH_LONG
            ).show()

            is RecyclerResponse.RespCountry -> Snackbar.make(
                this.vb.root,
                item.value.name,
                Snackbar.LENGTH_LONG
            ).show()
        }

    }
}