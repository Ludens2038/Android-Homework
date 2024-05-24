package at.fhooe.sail.android.ex02

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import at.fhooe.sail.android.ex02.databinding.ActivityMainBinding


const val TAG = "SensorsTest"

class MainActivity : AppCompatActivity(), SensorEventListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sensorMgr: SensorManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        sensorMgr = getSystemService(SensorManager::class.java)

        binding.activityMainSwitchLumen.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked) {
                sensorMgr.getDefaultSensor(Sensor.TYPE_LIGHT).also {
                    sensorMgr.registerListener(this, it, SensorManager.SENSOR_DELAY_NORMAL)
                }
            } else {
                sensorMgr.unregisterListener(this)
            }
        }

        binding.activityMainSwitchAccelX.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked) {
                sensorMgr.getDefaultSensor(Sensor.TYPE_ACCELEROMETER).also {
                    sensorMgr.registerListener(this, it, SensorManager.SENSOR_DELAY_NORMAL)
                }
            } else {
                sensorMgr.unregisterListener(this)
            }
        }

        binding.activityMainSwitchAccelY.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked) {
                sensorMgr.getDefaultSensor(Sensor.TYPE_ACCELEROMETER).also {
                    sensorMgr.registerListener(this, it, SensorManager.SENSOR_DELAY_NORMAL)
                }
            } else {
                sensorMgr.unregisterListener(this)
            }
        }

        binding.activityMainSwitchAccelZ.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked) {
                sensorMgr.getDefaultSensor(Sensor.TYPE_ACCELEROMETER).also {
                    sensorMgr.registerListener(this, it, SensorManager.SENSOR_DELAY_NORMAL)
                }
            } else {
                sensorMgr.unregisterListener(this)
            }
        }


    }

    override fun onSensorChanged(event: SensorEvent?) {
        when(event!!.sensor.type) {
            Sensor.TYPE_LIGHT -> {
                Log.i(TAG, "Main Activity: onSensorChanged ... sensor value: ${event!!.values[0]}")
                binding.activityMainTextviewLightValue.text = event!!.values[0].toString()
            }
            Sensor.TYPE_ACCELEROMETER -> {
                Log.i(TAG, "Main Activity: onSensorChanged ... sensor value: ${event!!.values[0]}")
                binding.activityMainTextviewAccelXvalue.text = event!!.values[0].toString()
                Log.i(TAG, "Main Activity: onSensorChanged ... sensor value: ${event!!.values[1]}")
                binding.activityMainTextviewAccelYvalue.text = event!!.values[1].toString()
                Log.i(TAG, "Main Activity: onSensorChanged ... sensor value: ${event!!.values[2]}")
                binding.activityMainTextviewAccelZvalue.text = event!!.values[2].toString()
            }

        }

    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        //TODO("Not yet implemented")
    }

}