package at.fhooe.sail.android.appbar

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuProvider
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import at.fhooe.sail.android.appbar.databinding.ActivityMainBinding

const val TAG: String = "ToolbarTest"

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)//um zurück zum anfang zu gelangen

        addMenuProvider(object : MenuProvider{
            override fun onCreateMenu(_menu: Menu, _menuInflater: MenuInflater) {
                _menuInflater.inflate(R.menu.main_menu, _menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                when(menuItem.itemId){
                    R.id.main_menu_opt_a -> {
                        Toast.makeText(applicationContext, "Option A selected", Toast.LENGTH_SHORT).show()
                    }

                    R.id.main_menu_opt_b -> {
                        Toast.makeText(applicationContext, "Option B selected", Toast.LENGTH_SHORT).show()
                    }

                    R.id.main_menu_opt_c -> {
                        Toast.makeText(applicationContext, "Option C selected", Toast.LENGTH_SHORT).show()
                    }

                    R.id.main_menu_opt_d -> {
                        Toast.makeText(applicationContext, "Option D selected", Toast.LENGTH_SHORT).show()
                    }

                    R.id.main_menu_opt_e -> {
                        Toast.makeText(applicationContext, "Option E selected", Toast.LENGTH_SHORT).show()
                    }

                    android.R.id.home -> {
                        Toast.makeText(applicationContext, "Feierabend", Toast.LENGTH_SHORT).show()
                    }

                    else -> {
                        Log.e(TAG, "Unknown menu item selected")
                        return false
                    }
                }
                return true
            }

        })

        binding.activityMainBToggleAb.setOnClickListener {
            supportActionBar?.apply {
                if(isShowing){
                    hide()
                } else {
                    show()
                }
            }
        }
    }
}