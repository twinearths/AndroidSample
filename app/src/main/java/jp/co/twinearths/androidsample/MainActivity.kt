package jp.co.twinearths.androidsample
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*
import me.relex.circleindicator.CircleIndicator3

class MainActivity : AppCompatActivity() {
    private var titleList = mutableListOf<String>()
    private var imageList = mutableListOf<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        postToList()
        viewpage2.adapter = ViewPageAdapter(titleList, imageList)
        viewpage2.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        val indicator = findViewById<CircleIndicator3>(R.id.indicator)
        indicator.setViewPager(viewpage2)
    }

    private fun addToList(title:String, image:Int) {
        titleList.add(title)
        imageList.add(image)
    }

    private fun postToList() {
        addToList("Moto Bike", R.drawable.ic_bike)
        addToList("Taxi", R.drawable.ic_car)
        addToList("Train", R.drawable.ic_train)
    }
}