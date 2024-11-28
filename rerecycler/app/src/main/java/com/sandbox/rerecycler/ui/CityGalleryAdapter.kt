package com.sandbox.rerecycler.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.sandbox.rerecycler.databinding.CityholderBinding
import com.sandbox.rerecycler.entity.City

class CityGalleryAdapter: ListAdapter<City, CityViewHolder>(CityComparator()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val cityBinding = CityholderBinding.inflate(LayoutInflater.from(parent.context))
        return CityViewHolder(cityBinding = cityBinding)
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        val city = getItem(position)
        holder.cityBinding.cityName.text = city.name
        // holder.cityBinding.cityPopulation.text = city.population.toString()
        holder.cityBinding.cityPopulation.text = String.format(city.population.toString())
    }
}