package at.fhooe.sail.android.icc

import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import at.fhooe.sail.android.icc.SHARED_PREF_CONTENT_KEY
import at.fhooe.sail.android.icc.SHARED_PREF_FILE_NAME
import at.fhooe.sail.android.icc.databinding.ActivityABinding
import kotlin.random.Random

class ActivityA : AppCompatActivity() {

    lateinit var binding: ActivityABinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityABinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.activityABGenerate.setOnClickListener{
            val txt: String = "A msg from A (${Random(System.currentTimeMillis()).nextInt(100)})"
            binding.activityATextviewGenerated.text = txt
        }
        binding.activityAButtonSend.setOnClickListener{
            //initiate communication with main
            val sp: SharedPreferences = getSharedPreferences(SHARED_PREF_FILE_NAME, MODE_PRIVATE)
            val spEdt: SharedPreferences.Editor = sp.edit()
            spEdt.putString(SHARED_PREF_CONTENT_KEY, binding.activityATextviewGenerated.text.toString())
            spEdt.commit()
            //done communication
            finish()
        }

    }
}