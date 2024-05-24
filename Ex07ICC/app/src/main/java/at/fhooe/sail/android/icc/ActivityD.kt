package at.fhooe.sail.android.icc

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import at.fhooe.sail.android.icc.databinding.ActivityDBinding
import kotlin.random.Random

class ActivityD : AppCompatActivity() {

    lateinit var binding: ActivityDBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.activityDBGenerate.setOnClickListener{
            val txt: String = "A msg from D (${Random(System.currentTimeMillis()).nextInt(100)})"
            binding.activityDTextviewGenerated.text = txt
        }
        binding.activityDButtonSend.setOnClickListener{
            //initiate communication with main

            MySingleton.singlePostBox = binding.activityDTextviewGenerated.text.toString()

            //done communication
            finish()
        }

    }
}