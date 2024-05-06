package data.remote.api

import data.model.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

interface WeatherAPI {

    @GET("weather?")
    fun getWeather(@Query("lat") lat : String,
                   @Query("lon") lon : String,
                   @Query("appid") apikey: String) : Observable<WeatherResponse>

}