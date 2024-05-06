package data.ui

class MainContract {


    interface View{
        fun showWeather(Climate : String)
        fun showLocation(location: String)
        fun showTemperatureMinMax(min: String, max: String)
        fun showWeatherDescription(description: String)
        fun showWeatherIcon(iconUrl: String)
    }

    interface Presenter{
        fun getWeather()
    }


}