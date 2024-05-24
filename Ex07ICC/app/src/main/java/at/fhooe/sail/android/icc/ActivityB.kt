package at.fhooe.sail.android.icc

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import at.fhooe.sail.android.icc.databinding.ActivityBBinding
import kotlin.random.Random

class ActivityB : AppCompatActivity() {

    lateinit var binding: ActivityBBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.activityBBGenerate.setOnClickListener{
            val txt: String = "A msg from B (${Random(System.currentTimeMillis()).nextInt(100)})"
            binding.activityBTextviewGenerated.text = txt
        }
        binding.activityBButtonSend.setOnClickListener{
            //initiate communication with main

            val container: Intent = Intent()
            container.putExtra(ACTIVITY_RESULT_KEY, binding.activityBTextviewGenerated.text.toString())
            setResult(RESULT_OK, container)//mechanismus geladen, activity schließt sich

            //done communication
            finish()
        }
    }
}