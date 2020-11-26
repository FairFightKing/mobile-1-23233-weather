package com.example.mobile_1_23233_weather

import com.google.gson.annotations.SerializedName

class WeatherInfo {

    data class CityWeather
    (
            @SerializedName("weather") val weather: Weather,
            @SerializedName("main") val main: Temperature,
            @SerializedName("sys") val sys: Country,
            @SerializedName("name") val name: String,
    )
    data class Weather(
            @SerializedName("main") val main: String,
            @SerializedName("description") val description: String
    )
    data class Temperature(
            @SerializedName("temp") val temp: Float
    )
    data class Country(
            @SerializedName("country") val country: String
    )
}

class WeatherJson(val WeatherList: List<WeatherInfo.CityWeather>)