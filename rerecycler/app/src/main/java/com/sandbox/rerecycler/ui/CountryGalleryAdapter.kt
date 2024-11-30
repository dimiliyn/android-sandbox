package com.sandbox.rerecycler.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.sandbox.rerecycler.databinding.CountryholderBinding
import com.sandbox.rerecycler.entity.Country

class CountryGalleryAdapter : ListAdapter<Country, CountryViewHolder>(CountryComparator()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val countryBinding = CountryholderBinding.inflate(LayoutInflater.from(parent.context))
        return CountryViewHolder(countryBinding = countryBinding)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = getItem(position)
        holder.countryBinding.countryName.text = country.name

        val cityListAdapter = CityGalleryAdapter()
        holder.countryBinding.cities.adapter = cityListAdapter
        cityListAdapter.submitList(country.cities)
    }
}