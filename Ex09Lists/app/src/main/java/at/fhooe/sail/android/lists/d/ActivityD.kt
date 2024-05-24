package at.fhooe.sail.android.lists.d

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import at.fhooe.sail.android.lists.databinding.ActivityDBinding
import kotlin.random.Random

class ActivityD : AppCompatActivity() {

    lateinit var binding: ActivityDBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}