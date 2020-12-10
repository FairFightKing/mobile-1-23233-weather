package com.example.mobile_1_23233_weather

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_details.*

class RecyclerDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val title = intent.getStringExtra(CustomViewHolder.DETAIL_TITLE_KEY)
        supportActionBar?.title = title

        SingleWeather.text = "Weather is "+intent.getStringExtra(CustomViewHolder.weather)
        SingleWeatherDesc.text = "Weather is more precisely "+intent.getStringExtra(CustomViewHolder.weatherDesc)
        SingleTemp.text = "Temperature is " + intent.getStringExtra(CustomViewHolder.temp) + " degrees in Celsius"
        SingleTempFeelsLike.text = "Temperature feels like " + intent.getStringExtra(CustomViewHolder.tempFeelsLike) + " degrees in Celsius"
        Singlewind.text = "Wind is at " + intent.getStringExtra(CustomViewHolder.wind) + " km/h"
        SingleCountry.text = "This city is situated in " + intent.getStringExtra(CustomViewHolder.country)

    }
}