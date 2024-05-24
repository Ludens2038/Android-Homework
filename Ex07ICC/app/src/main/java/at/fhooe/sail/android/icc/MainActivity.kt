package at.fhooe.sail.android.icc

import android.content.Intent
import android.content.SharedPreferences
import android.content.SharedPreferences.OnSharedPreferenceChangeListener
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import at.fhooe.sail.android.icc.R
import at.fhooe.sail.android.icc.databinding.ActivityMainBinding

const val TAG: String = "ICC-Test"
const val SHARED_PREF_FILE_NAME: String = "MySharedPreferences"
const val SHARED_PREF_CONTENT_KEY = "ActivityA"
const val ACTIVITY_RESULT_KEY: String = "ActivityBKey"

class MainActivity : AppCompatActivity(), OnClickListener, OnSharedPreferenceChangeListener {

    lateinit var binding: ActivityMainBinding

    val launcher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()){
        _foo ->
        Toast.makeText(this, "Data recieved", Toast.LENGTH_SHORT).show()
        if(_foo.resultCode == RESULT_OK){
            val txt = _foo.data?.getStringExtra(ACTIVITY_RESULT_KEY)
            binding.activityMainTextviewMsg.text = txt
        }
        //ToDo mache was mit dem Ergebnis ...
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.activityMainButtonA.setOnClickListener(this)
        binding.activityMainButtonB.setOnClickListener(this)
        binding.activityMainButtonC.setOnClickListener(this)
        binding.activityMainButtonD.setOnClickListener(this)

        getSharedPreferences(SHARED_PREF_FILE_NAME, MODE_PRIVATE).registerOnSharedPreferenceChangeListener(this)


    }

    override fun onResume() {
        super.onResume()
/*
        getSharedPreferences(SHARED_PREF_FILE_NAME, MODE_PRIVATE).apply{
            val txt: String? = getString(SHARED_PREF_CONTENT_KEY, "undefined")
            binding.activityMainTextviewMsg.text = txt
        }
 */
        (application as OtherApplication).postBox?.apply {
            binding.activityMainTextviewMsg.text = this
            (application as OtherApplication).postBox = null
        }

        MySingleton.singlePostBox?.apply {
            binding.activityMainTextviewMsg.text = this
            MySingleton.singlePostBox = null
        }
    }

    override fun onClick(_v: View?) {
        var i: Intent? = null
        when(_v?.id){
            R.id.activity_main_button_a ->{ i = Intent(this, ActivityA::class.java)}
            R.id.activity_main_button_b ->{
                val j = Intent(this, ActivityB::class.java)
                launcher.launch(j)
            }
            R.id.activity_main_button_c ->{ i = Intent(this, ActivityC::class.java)}
            R.id.activity_main_button_d ->{ i = Intent(this, ActivityD::class.java)}

            else -> {
                Log.e(TAG, "error")}
        }
        i?.apply{
            startActivity(this)
        }

    }
    //je nachdem welcher schlüssel geändert wurde schlögt das system an
    //betrachtet veränderungen
    //bei großen daten geht das ganze ding ein, firebase ist eine gute alternative(frage ob datenbanktypus passend ist)
    //speichert primitive daten
    override fun onSharedPreferenceChanged (_sp: SharedPreferences?, _key: String?){
        when(_key){
            SHARED_PREF_CONTENT_KEY -> {
                val txt: String? = _sp?.getString(_key, "undefined")
                binding.activityMainTextviewMsg.text = txt
            }
            else -> {Log.e(TAG, "error2")}
        }
    }


}

