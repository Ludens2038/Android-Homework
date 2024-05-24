package at.fhooe.sail.android.perimssion

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import at.fhooe.sail.android.perimssion.databinding.ActivityMainBinding

const val TAG: String = "PermissionTest"
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    val launcher = registerForActivityResult(ActivityResultContracts.RequestPermission()) { _granted ->
            if (_granted) {
                //do it
                startCall(android.Manifest.permission.CALL_PHONE)
            } else {
                //forbidden ... deactivate feature
                Toast.makeText(this, "Call Feature noch nicht nutzbar", Toast.LENGTH_SHORT).show()

            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.activityMainBCall.setOnClickListener {
            startCall(android.Manifest.permission.CALL_PHONE)
        }
    }

    fun startCall(_permission: String) {
        when {
            (checkSelfPermission(_permission) == PackageManager.PERMISSION_GRANTED) -> {
                val i: Intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:123456789"))
                startActivity(i)
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
}