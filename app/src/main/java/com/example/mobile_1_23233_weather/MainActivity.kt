package com.example.mobile_1_23233_weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getWeatherJson();
    }

    private fun getWeatherJson() {
        var apiKey = "56c1960c9b3cdefb6fe88da1fd7e772c"
        var city = "Yvelines"
        var uri = "https://api.openweathermap.org/data/2.5/weather?q=$city&appid=$apiKey"
        Log.i("URI", uri)

        //Create a request object

        val request = Request.Builder().url(uri).build()

        //Create a client

        val client = OkHttpClient()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.i("JSON", "JSON HTTP CALL FAILED")
            }

            override fun onResponse(call: Call, response: Response) {
                Log.i("JSON", "JSON HTTP CALL SUCCEEDED")
                val body = response?.body?.string()

                //body

                var jsonBody = "{\"City\": " + body + "}"
                Log.i("JSON", jsonBody)

                val gson = GsonBuilder().create()
                var weatherList = gson.fromJson(jsonBody, WeatherInfo.CityWeather::class.java)

                 Log.i("JSON", weatherList.sys.country)

       //         runOnUiThread {
        //            recyclerStationList.adapter = StationListAdapter(weatherList.stations)

        //        }
            }
        })
    }
}