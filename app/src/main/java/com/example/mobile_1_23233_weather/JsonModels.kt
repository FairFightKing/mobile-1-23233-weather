package com.example.mobile_1_23233_weather



class CityWeather
(
        val weather: List<Weather>,
        val main: Temperature,
        val sys: Country,
        val name: String,
)
 class Weather(
        val main: String,
        val description: String
)
class Temperature(
        val temp: Float
)
 class Country(
        val country: String
)


class WeatherJson(val list: List<CityWeather>)