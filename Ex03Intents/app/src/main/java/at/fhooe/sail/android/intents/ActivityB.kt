package at.fhooe.sail.android.intents

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import at.fhooe.sail.android.intents.databinding.ActivityABinding
import at.fhooe.sail.android.intents.databinding.ActivityBBinding



class ActivityB : AppCompatActivity(), OnClickListener {

    lateinit var binding: ActivityBBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }
}