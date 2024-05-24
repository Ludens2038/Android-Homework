package at.fhooe.sail.android.lists.a

import android.content.SharedPreferences
import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import at.fhooe.sail.android.lists.databinding.ActivityABinding
import kotlin.random.Random

class ActivityA : AppCompatActivity() {

    lateinit var binding: ActivityABinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityABinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data: MutableList<SimpleData> = mutableListOf(
            SimpleData("Eintrag 1"),
            SimpleData("Eintrag 2"),
        )

        for (index in 3.. 10){
            data.add(SimpleData("Eintrag $index"))
        }

        val recycler: RecyclerView = binding.activityARvList
        recycler.adapter       = ListAAdapter(data)
        recycler.layoutManager = GridLayoutManager(this, 1)
        recycler.addItemDecoration(object: RecyclerView.ItemDecoration(){
            override fun getItemOffsets(
                outRect: Rect,
                view: View,
                parent: RecyclerView,
                state: RecyclerView.State
            ) {
                super.getItemOffsets(outRect, view, parent, state)
                outRect.left   = 10
                outRect.right  = 10
                outRect.top    = 5
                outRect.bottom = 5
            }
        })

        binding.activityABAdd.setOnClickListener{
            data.add(SimpleData("Neuer Eintrag ${Random.nextInt(100,200)}"))
            binding.activityARvList.adapter?.notifyItemInserted(data.size - 1)
        }
        binding.activtiyABDel.setOnClickListener {
            if (data.size > 0) {
                data.removeAt(0)
                binding.activityARvList.adapter?.notifyItemRemoved(0)
            }
        }
    }
}