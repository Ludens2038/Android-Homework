package at.fhooe.sail.android.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val TAG: String = "HelloWorldTag"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "in MainActivity::onCreate(...)")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        Log.d(TAG, "in MainActivity::onStart(...)")
        super.onStart()
    }

    override fun onRestart() {
        Log.d(TAG, "in MainActivity::onRestart(...)")
        super.onRestart()
    }

    override fun onResume() {
        Log.d(TAG, "in MainActivity::onResume(...)")
        super.onResume()
    }

    override fun onPause() {
        Log.d(TAG, "in MainActivity::onPause(...)")
        super.onPause()
    }

    override fun onStop() {
        Log.d(TAG, "in MainActivity::onStop(...)")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d(TAG, "in MainActivity::onDestroy(...)")
        super.onDestroy()
    }

}