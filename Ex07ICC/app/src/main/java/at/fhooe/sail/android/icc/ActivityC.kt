package at.fhooe.sail.android.icc

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import at.fhooe.sail.android.icc.databinding.ActivityCBinding
import kotlin.random.Random

class ActivityC : AppCompatActivity() {

    lateinit var binding: ActivityCBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.activityCBGenerate.setOnClickListener{
            val txt: String = "A msg from C (${Random(System.currentTimeMillis()).nextInt(100)})"
            binding.activityCTextviewGenerated.text = txt
        }
        binding.activityCButtonSend.setOnClickListener{
            //initiate communication with main

            //as sit ein cast mechanismus, direkter cast wie in java kallmmercast float = (float)int
            val app: OtherApplication = application as OtherApplication
            app.postBox = binding.activityCTextviewGenerated.text.toString()

            //done communication
            finish()
        }

    }
}