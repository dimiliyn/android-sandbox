package com.sandbox.rerecycler.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.sandbox.rerecycler.databinding.CountryholderBinding
import com.sandbox.rerecycler.entity.Country
import com.sandbox.rerecycler.entity.RecyclerResponse

class CountryGalleryAdapter(
    private val onViewClick: (RecyclerResponse) -> Unit
) :
    ListAdapter<Country, CountryViewHolder>(CountryComparator()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val countryBinding = CountryholderBinding.inflate(LayoutInflater.from(parent.context))
        return CountryViewHolder(countryBinding = countryBinding)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = getItem(position)
        holder.countryBinding.countryName.text = country.name
        holder.countryBinding.root.setOnClickListener {
            country?.let {
                onClick(RecyclerResponse.RespCountry(country))
            }
        }

        val cityListAdapter =
            CityGalleryAdapter { city: RecyclerResponse -> onClick(item = city) }
        holder.countryBinding.cities.adapter = cityListAdapter
        cityListAdapter.submitList(country.cities)

    }

    private fun onClick(item: RecyclerResponse) {
        onViewClick(item)
    }

}