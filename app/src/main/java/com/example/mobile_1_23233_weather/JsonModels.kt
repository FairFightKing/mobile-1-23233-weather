package com.example.mobile_1_23233_weather

class WeatherInfo {

    data class CityWeather
        (
        val name: String,
        val weather: Weather,
        val main: Temp,
        val sys: Country
    )
    data class Weather(
        val main: String,
        val description: String
    )
    data class Temp(
        val temp: Float
    )
    data class Country(
        val country: String
    )
}

class WeatherJson(val WeatherList: WeatherInfo.CityWeather)