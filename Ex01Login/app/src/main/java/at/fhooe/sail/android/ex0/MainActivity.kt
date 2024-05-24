package at.fhooe.sail.android.ex0

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import at.fhooe.sail.android.ex0.databinding.ActivityMainBinding

const val TAG: String = "LogInTest"

class MainActivity : AppCompatActivity(), OnClickListener {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //replace the findViewById with the view binding
        binding.loginscreenButtonLogin.setOnClickListener(this)
        binding.loginscreenButtonRegister.setOnClickListener(this)
        binding.loginscreenClickabletextForgotpassword.setOnClickListener(this)

    }

    override fun onClick(_v: View?) {
        var txt: String? = null
        when (_v?.id) {
            R.id.loginscreen_button_login -> {
                val usr: String = binding.loginscreenFieldUserid.text.toString()
                val pwd: String = binding.loginscreenTextviewPassword.text.toString()
                checkLogInData(usr, pwd)
            }

            R.id.loginscreen_button_register -> {
                Log.i(TAG, "MainActivity::onClick Button register pressed")
            }

            R.id.loginscreen_clickabletext_forgotpassword -> {
                Log.i(TAG, "MainActivity::onClick ClickableText forgot password pressed")
            }

            else -> {
                Log.e(TAG, "MainActivity::onClick unhandled id encountered ${_v?.id}")
            }
        }
        txt?.also {
            Log.i(TAG, it)
        }
    }

    fun checkLogInData(_usr: String, _pwd: String): Boolean {
        Log.i(TAG, "MainActivity::checkLogInData user: check($_usr/$_pwd)")
        if(_usr.length > 0 && _pwd.length > 0) {
            return true
        }
        return false
    }

}