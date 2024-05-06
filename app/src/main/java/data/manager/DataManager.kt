package data.manager

import android.content.Context
import data.model.WeatherResponse
import data.remote.api.WeatherAPI
import data.remote.client.ServiceGenerator
import data.util.SharedPreferencesConnector
import rx.Observable

class DataManager(val context: Context) {

    private val connector = SharedPreferencesConnector.getInstance(context)

    fun getWeather()  : Observable<WeatherResponse> {

        return ServiceGenerator.createService(WeatherAPI::class.java,context).getWeather("0.0","0.0","a4f03c2a6b8520f98e634e687beb9aff"
        )

    }


}