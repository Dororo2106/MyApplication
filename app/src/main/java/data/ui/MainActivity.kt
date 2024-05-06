package data.ui


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.myapplication.R



class MainActivity : AppCompatActivity(), MainContract.View
{
    private var presenter: MainPresenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter(this,this)
        loadInitialdata()
    }

    private fun loadInitialdata() {
        presenter?.getWeather()
    }

    override fun showWeather(climate: String) {
        findViewById<TextView>(R.id.climaActual).text = climate
    }

    override fun showLocation(location: String) {
        findViewById<TextView>(R.id.ubicacionActual).text = location
    }

    override fun showTemperatureMinMax(min: String, max: String) {
        findViewById<TextView>(R.id.minActual).text = min
        findViewById<TextView>(R.id.maxActual).text = max
    }

    override fun showWeatherDescription(description: String) {
        findViewById<TextView>(R.id.descripcionClima).text = description
    }

    override fun showWeatherIcon(iconUrl: String) {

    }
}