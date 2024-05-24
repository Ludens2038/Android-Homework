package at.fhooe.sail.android.intents

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import at.fhooe.sail.android.intents.databinding.ActivityMainBinding

const val TAG: String = "IntentTest"

class MainActivity : AppCompatActivity(), OnClickListener {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.activityMainButtonA.setOnClickListener(this)
        binding.activityMainButtonB.setOnClickListener(this)
        binding.activityMainButtonClose.setOnClickListener(this)
    }

    override fun onClick(_v: View?) {

        var i: Intent? = null
        //var c: Class<Any>? = null schaut er sich nochmal an

        when(_v?.id){
            R.id.activity_main_button_a -> {
                i = Intent(this, ActivityA::class.java)
            }
            R.id.activity_main_button_b -> {
                i = Intent(this, ActivityB::class.java)
            }
            R.id.activity_main_button_close -> {
                //ob mit programmwechsel user ex droppt
                finishAffinity()
                /*

                 */
            }
            else -> { Log.e (TAG, "ActivityMain::onClick: unexpected ID encountered ($_v?.id)")}
        }
        i?.also { startActivity(it) }
    }
}