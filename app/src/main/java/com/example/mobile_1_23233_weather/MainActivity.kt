package com.example.mobile_1_23233_weather

import android.content.Intent
import android.graphics.Color
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
import kotlinx.android.synthetic.main.weather_row.view.*
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerWeatherList.setBackgroundColor(Color.BLACK)

        recyclerWeatherList.layoutManager = LinearLayoutManager(this)


        getWeatherJson();
    }

    private fun getWeatherJson() {
        var apiKey = "56c1960c9b3cdefb6fe88da1fd7e772c"
        var city = "2988506,6451978,6444046,2967196,2986501,3013445,3005534,3005270,2992790,3010529"
        var uri = "https://api.openweathermap.org/data/2.5/group?id=$city&units=metric&appid=$apiKey"
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

                var jsonBody = "{\"apiweather\": [" + body + "]}"
                Log.i("JSON", jsonBody)

                val gson = GsonBuilder().create()
                var weatherList = gson.fromJson(body, WeatherJson::class.java)

                //Log.i("JSON", gson.)



                runOnUiThread {
                    recyclerWeatherList.adapter = WeatherListAdapter(weatherList.list)

                }
            }
        })
    }
}

class WeatherListAdapter(val weather: List<CityWeather>)
    :
        RecyclerView.Adapter<CustomViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        // TODO("Not yet implemented")
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.weather_row, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        // TODO("Not yet implemented")

        holder.itemView.Name.text = weather[position].name
        holder.itemView.Weather.text = weather[position].weather[0].description
        holder.itemView.Country.text = weather[position].main.temp.toString()
        holder?.data = weather[position]
    }

    override fun getItemCount(): Int {
        ///  TODO("Not yet implemented")

        return weather.size
    }


}

class CustomViewHolder(view: View, var data: CityWeather?= null) : RecyclerView.ViewHolder(view) {
    companion object {
        val LOGCAT_CATEGORY = "JSON"
        val Country_temp = "Country_temp"
        val Country_feels_like = "Country_feels_like"
        val Country_humidity = "Country_humidity"
        val Country_pressure = "Country_pressur"
        val DETAIL_TITLE_KEY = "ActionBarTitle"

    }

    init {
        view.setOnClickListener {

            Log.i(LOGCAT_CATEGORY, "Recycler view Item has been clicked")
            Log.i(LOGCAT_CATEGORY, "Name is is " + data?.name)

        }

    }
}