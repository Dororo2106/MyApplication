package data.ui


import android.content.Context
import data.manager.DataManager
import data.model.WeatherResponse
import data.util.SharedPreferencesConnector
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers



class MainPresenter(
    private val view: MainContract.View,
    private val context: Context
) : MainContract.Presenter {
    private val connector = SharedPreferencesConnector.getInstance(context)
    private val dataManager = DataManager(context)


    override fun getWeather() {
        val observable = dataManager.getWeather()
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Subscriber<WeatherResponse>() {

                override fun onError(e: Throwable?) {
                    e?.printStackTrace()
                }

                override fun onNext(t: WeatherResponse) {
                    val feelsLikeCelsius = t.main?.feels_like?.minus(273.15)?.let { "%.2f".format(it) }
                    val weatherText = if (feelsLikeCelsius != null) "$feelsLikeCelsius °C" else "Feels like: Data not available"
                    view.showWeather(weatherText)

                    val location = t.name ?: "Unknown location"
                    view.showLocation(location)

                    val tempMin = t.main?.temp_min?.minus(273.15)?.let { "%.2f".format(it) } ?: "No data"
                    val tempMax = t.main?.temp_max?.minus(273.15)?.let { "%.2f".format(it) } ?: "No data"

                    view.showTemperatureMinMax("Min: $tempMin °C", "Max: $tempMax °C")

                    val description = t.weather?.firstOrNull()?.description ?: "Description not available"
                    view.showWeatherDescription(description)



                    //Mostrar la imagen
                    val iconCode = t.weather?.firstOrNull()?.icon
                    val iconUrl = if (iconCode != null) "https://openweathermap.org/img/wn/$iconCode@2x.png" else null
                    if (iconUrl != null) {
                        view.showWeatherIcon(iconUrl)
                    }
                }

                override fun onCompleted() {
                    // no necesario
                }
            })
    }

}