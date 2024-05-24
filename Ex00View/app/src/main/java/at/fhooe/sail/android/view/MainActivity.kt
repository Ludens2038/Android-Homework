package at.fhooe.sail.android.view

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

const val TAG: String ="ViewTest"

class MainActivity : AppCompatActivity(), OnClickListener {

    class MyNestedOnClickListener : OnClickListener {
        override fun onClick(_v: View?) {
            var txt: String? = null
            when (_v?.id) {
                R.id.activity_main_button_e -> {
                    txt = "MainActivity::onClick Button e pressed"
                }

                else -> {
                    Log.e(TAG, "MainActivity::onClick unhandled id encountered ${_v?.id}")
                }
            }

            txt?.also {
                Log.i(TAG, it)
            }
        }
    }

    val mNestedOnClickListener: OnClickListener = MyNestedOnClickListener()

    override fun onCreate(_savedInstanceState: Bundle?) {
        super.onCreate(_savedInstanceState)
        setContentView(R.layout.activity_main)

        var ba: Button = findViewById(R.id.activity_main_button_a)
        ba.setOnClickListener(this)
        var bb: Button = findViewById(R.id.activity_main_button_b)
        bb.setOnClickListener(this)

        var bc = findViewById(R.id.activity_main_button_c) as Button
        bc.setOnClickListener {
            Log.i(TAG, "MainActivity::onClick button c pressed")
        }

        var bd = findViewById<Button>(R.id.activity_main_button_d)
        bd.setOnClickListener(object : OnClickListener {
            override fun onClick(v: View?) {
                Log.i(TAG, "MainActivity::onClick button d pressed")
            }
        })

        var be: Button = findViewById(R.id.activity_main_button_e)
        be.setOnClickListener(mNestedOnClickListener)

    }

    fun myOnClick(_v: View){
        Log.i(TAG, "MainActivity::onClick button f pressed")
    }

    override fun onClick(_v: View?) {
        //Log.i(TAG, "MainActivity::onClick ... onClick getriggert")
        var txt: String? = null
        when(_v?.id){
            R.id.activity_main_button_a -> { txt = "MainActivity::onClick Button a pressed"}
            R.id.activity_main_button_b -> { txt = "MainActivity::onClick Button b pressed"}
            else ->{ Log.e(TAG, "MainActivity::onClick unhandled id encountered ${_v?.id}")}

        }

        txt?.also {
            Log.i(TAG, it)
        }
    }
}