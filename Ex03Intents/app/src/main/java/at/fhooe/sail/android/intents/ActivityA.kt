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
import at.fhooe.sail.android.intents.databinding.ActivityABinding
import at.fhooe.sail.android.intents.databinding.ActivityMainBinding




class ActivityA : AppCompatActivity(), OnClickListener {

    lateinit var binding: ActivityABinding

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        binding = ActivityABinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.activityBButtonMain.setOnClickListener(this)
        binding.activityBButtonB.setOnClickListener(this)

    }

    override fun onClick(_v: View?) {

        var i: Intent? = null

        when(_v?.id){
            R.id.activity_b_button_main -> {
                i = Intent(this, MainActivity::class.java)
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)//um backstack zu clearen wenn man wieder auf main geht
            }
            R.id.activity_b_button_b -> {
                i = Intent(this, ActivityB::class.java)
            }

            else -> { Log.e (TAG, "ActivityMain::onClick: unexpected ID encountered ($_v?.id)")}
        }
        i?.also { startActivity(it) }
    }
}