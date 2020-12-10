package com.example.mobile_1_23233_weather



class CityWeather
(
        val weather: List<Weather>,
        val main: Temperature,
        val sys: Country,
        val name: String,
        val wind: Wind
)
 class Weather(
        val main: String,
        val description: String
)
class Temperature(
        val temp: Float,
        val feels_like: Float
)
 class Country(
        val country: String
)

class Wind(
        val speed: Float
)

class WeatherJson(val list: List<CityWeather>)