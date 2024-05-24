package at.fhooe.sail.android.notification

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.VibratorManager
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import at.fhooe.sail.android.notification.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

const val TAG: String = "NotificationTest"

const val NOTIFICATION_CHANNEL_ID: String = "at.fhooe.sail.android.IrgendwasSchlaues"
const val NOTIFICATION_ID: Int = 42

class MainActivity : AppCompatActivity() {

    class ButtonListener(val mCallback: MainActivity) : View.OnClickListener {
        @RequiresApi(Build.VERSION_CODES.S)
        override fun onClick(_v: View?) {
            when(_v?.id){
                R.id.activity_main_button_toast -> { mCallback.generateToastMsg() }
                R.id.activity_main_button_snackbar -> { mCallback.generateSnackBarMsg()}
                R.id.activity_main_button_vibration -> { mCallback.generateVibrationMsg()}
                R.id.activity_main_button_dialog -> {mCallback.generateDialogMsg()}
                R.id.activity_main_button_notification -> {mCallback.startNotification(android.Manifest.permission.CALL_PHONE)}

                else -> {
                    Log.e(TAG, "MainActivity::ButtonListener::onClick() ... unexpected id encountered")}
            } //when id
        }
    }

    private lateinit var binding: ActivityMainBinding
    private val mButtonListener: ButtonListener = ButtonListener(this)

    val launcher = registerForActivityResult(ActivityResultContracts.RequestPermission()) { _granted ->
        if (_granted) {
            //do it
            startNotification(android.Manifest.permission.POST_NOTIFICATIONS)
        } else {
            //forbidden ... deactivate feature
            Toast.makeText(this, "Notification Feature noch nicht nutzbar", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.activityMainButtonToast.setOnClickListener(mButtonListener)
        binding.activityMainButtonSnackbar.setOnClickListener(mButtonListener)
        binding.activityMainButtonVibration.setOnClickListener(mButtonListener)
        binding.activityMainButtonDialog.setOnClickListener(mButtonListener)
        binding.activityMainButtonNotification.setOnClickListener(mButtonListener)

        NotificationChannel(NOTIFICATION_CHANNEL_ID,
            TAG+"Name",
            NotificationManager.IMPORTANCE_DEFAULT).also {
                getSystemService(NotificationManager::class.java).apply {
                    createNotificationChannel(it)
                }
        }
    }

    private fun generateToastMsg(){
        Toast.makeText(this, "Dies ist ein Trinkspruch!", Toast.LENGTH_SHORT).show()
    }

    private fun generateSnackBarMsg(){
        /*
       var sb: Snackbar = Snackbar.make(binding.root, "Dies ist ein Buffet!", Snackbar.LENGTH_INDEFINITE)
        sb.setAction("Foo"){
            Toast.makeText(this, "Snackbar action triggered", Toast.LENGTH_SHORT).show()
            sb.dismiss()

        }
        sb.show()

         */
        Snackbar.make(binding.root, "Dies ist ein Buffet!", Snackbar.LENGTH_INDEFINITE).apply {
            setAction("Foo"){
                Toast.makeText(this@MainActivity, "Snackbar action triggered", Toast.LENGTH_SHORT).show()
                dismiss()
            }
            show()
        }
    }

    @RequiresApi(Build.VERSION_CODES.S)
    private fun generateVibrationMsg(){
        val vMgr: VibratorManager = getSystemService(VibratorManager::class.java)
        val seq: LongArray = longArrayOf(0, 100, 200, 100, 300, 200, 100, 100, 200, 100)
        val vEff: VibrationEffect = VibrationEffect.createWaveform(seq, -1)
        vMgr.defaultVibrator.vibrate(vEff)
    }

    private fun generateDialogMsg(){
        val wendy: AlertDialog.Builder = AlertDialog.Builder(this)
        wendy.apply {
            setTitle("Ein Titel")
            val v: View = layoutInflater.inflate(R.layout.dialog_activity_main_nick, null)
            setView(v)
            val etNick: EditText = v.findViewById(R.id.dialog_activity_main_nick_edittext_data)
            setMessage("Ein Text")
            setPositiveButton(android.R.string.ok){ _d, _i ->
                val nickname: String = etNick.text.toString()
                Toast.makeText(this@MainActivity, "Nickname: $nickname", Toast.LENGTH_SHORT).show()
                //remember nickname for our highscore ...
            }
            setNegativeButton(android.R.string.cancel){_,_ ->
                Toast.makeText(this@MainActivity, "Eingabe abgebrochen", Toast.LENGTH_SHORT).show()
            }
        }

        wendy.create().show()
    }

    fun startNotification(_permission: String) {
        when {
            (ContextCompat.checkSelfPermission(this, _permission) == PackageManager.PERMISSION_GRANTED) -> {
                generateNotificationMsg()
            }

            (shouldShowRequestPermissionRationale(_permission)) -> {
                AlertDialog.Builder(this).apply {
                    setTitle("Explanation")
                    setMessage("We need it")
                    setPositiveButton(android.R.string.ok) { _, _ ->
                        //ask for it
                        launcher.launch(_permission)

                    }
                }.create().show()
            }

            else -> {
                //ask for it
                launcher.launch(_permission)
            }
        }//when
    }

    private fun generateNotificationMsg(){
        val bob: Notification.Builder = Notification.Builder(this, NOTIFICATION_CHANNEL_ID)
        bob.setSmallIcon(R.drawable.ic_notification)
        bob.setContentTitle("Ein Titel")
        bob.setContentText("Ein bisschen Text")
        val noti: Notification = bob.build()
        val notMgr: NotificationManager = getSystemService(NotificationManager::class.java)
        notMgr.notify(NOTIFICATION_ID, noti)
    }

}