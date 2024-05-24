package at.fhooe.sail.android.lists.c

import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import at.fhooe.sail.android.lists.R
import at.fhooe.sail.android.lists.b.ListBAdapter
import at.fhooe.sail.android.lists.databinding.ActivityCBinding

class ActivityC : AppCompatActivity() {

    lateinit var binding: ActivityCBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data: MutableList<CountryData> = mutableListOf(
            CountryData(R.string.austria_name, R.string.austria_acronym, R.drawable.austria_flag),
            CountryData(R.string.germany_name, R.string.germany_acronym, R.drawable.germany_flag),
            CountryData(R.string.france_name, R.string.france_acronym,R.drawable.france_flag)
        )

        with(binding.activityCRecyclerView){
            val pad = 10
            val pad2 = 5
            layoutManager = GridLayoutManager(this@ActivityC, 1)
            adapter = ListCAdapter(data, this@ActivityC)
            addItemDecoration(object: RecyclerView.ItemDecoration(){
                override fun getItemOffsets(
                    outRect: Rect,
                    view: View,
                    parent: RecyclerView,
                    state: RecyclerView.State
                ) {
                    super.getItemOffsets(outRect, view, parent, state)
                    outRect.left = pad
                    outRect.right= pad
                    outRect.top = pad2
                    outRect.bottom = pad2
                }
            })
        }

    }
}