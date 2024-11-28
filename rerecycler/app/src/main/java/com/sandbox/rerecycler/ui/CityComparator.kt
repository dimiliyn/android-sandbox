package com.sandbox.rerecycler.ui

import androidx.recyclerview.widget.DiffUtil
import com.sandbox.rerecycler.entity.City

class CityComparator: DiffUtil.ItemCallback<City>() {
    override fun areItemsTheSame(oldItem: City, newItem: City): Boolean {
        return newItem.name == oldItem.name
    }

    override fun areContentsTheSame(oldItem: City, newItem: City): Boolean {
        return newItem.name == oldItem.name && newItem.population == oldItem.population
    }
}