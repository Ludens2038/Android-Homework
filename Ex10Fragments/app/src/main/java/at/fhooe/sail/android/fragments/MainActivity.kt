package at.fhooe.sail.android.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import at.fhooe.sail.android.fragments.databinding.ActivityMainBinding

const val TAG: String = "FragmentTest"

class MainActivity : AppCompatActivity(), OnClickListener {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.activityMainBA.setOnClickListener(this)
        binding.activityMainBB.setOnClickListener(this)
        binding.activityMainBC.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        var frag: Fragment? = null
        when (v?.id) {

            R.id.activity_main_b_a ->{
                frag = FragmentA()
            }
            R.id.activity_main_b_b ->{
                frag = FragmentB()
            }
            R.id.activity_main_b_c ->{
                frag = FragmentC()
            }

            else -> { Log.e(TAG, "unexpected id encounterded") }
            }
        frag?.let {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                addToBackStack(null)
                replace(R.id.activity_main_frag_container, it)
            }
        }
    }
}

