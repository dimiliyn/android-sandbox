package com.sandbox.rerecycler.entity

sealed class RecyclerResponse {
    class RespCountry(val value: Country) : RecyclerResponse()
    class RespCity(val value: City) : RecyclerResponse()
}