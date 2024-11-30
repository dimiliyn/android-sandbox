package com.sandbox.rerecycler.ui

import androidx.recyclerview.widget.DiffUtil
import com.sandbox.rerecycler.entity.Country

class CountryComparator : DiffUtil.ItemCallback<Country>() {
    override fun areItemsTheSame(oldItem: Country, newItem: Country): Boolean {
        return newItem.name == oldItem.name
    }

    override fun areContentsTheSame(oldItem: Country, newItem: Country): Boolean {
        return newItem.name == oldItem.name &&
                // If you don't bother about order of elements in both lists:
                // https://stackoverflow.com/questions/52054104/comparing-two-lists-in-kotlin
                newItem.cities.containsAll(oldItem.cities) &&
                oldItem.cities.containsAll(newItem.cities)
    }
}