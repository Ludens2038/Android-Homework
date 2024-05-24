package at.fhooe.sail.android.lists

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import androidx.appcompat.app.AppCompatActivity
import at.fhooe.sail.android.lists.a.ActivityA
import at.fhooe.sail.android.lists.a.SimpleData
import at.fhooe.sail.android.lists.b.ActivityB
import at.fhooe.sail.android.lists.c.ActivityC
import at.fhooe.sail.android.lists.d.ActivityD
import at.fhooe.sail.android.lists.databinding.ActivityMainBinding

const val TAG: String = "ListTest"

class MainActivity : AppCompatActivity(), OnClickListener{

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.activityMainButtonA.setOnClickListener(this)
        binding.activityMainButtonB.setOnClickListener(this)
        binding.activityMainButtonC.setOnClickListener(this)
        binding.activityMainButtonD.setOnClickListener(this)
    }

    override fun onClick(_v: View?) {
        var i: Intent? = null
        when(_v?.id){
            R.id.activity_main_button_a ->{ i = Intent(this, ActivityA::class.java)}
            R.id.activity_main_button_b ->{ i = Intent(this, ActivityB::class.java)}
            R.id.activity_main_button_c ->{ i = Intent(this, ActivityC::class.java)}
            R.id.activity_main_button_d ->{ i = Intent(this, ActivityD::class.java)}

            else -> {
                Log.e(TAG, "error")}
        }
        i?.apply{
            startActivity(this)
        }
    }
}




