package jp.co.twinearths.androidsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import jp.co.twinearths.androidsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bottomTabBar: BottomNavigationView = binding.bottomTabBar
        val navHost = supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.topFragment, R.id.secondFragment, R.id.thirdFragment))
        setupActionBarWithNavController(navHost.navController,appBarConfiguration)
        bottomTabBar.setupWithNavController(navHost.navController)
    }
}