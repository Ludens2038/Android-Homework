package at.fhooe.sail.android.lists.b

import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import at.fhooe.sail.android.lists.databinding.ActivityBBinding

class ActivityB : AppCompatActivity() {

    lateinit var binding: ActivityBBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data: MutableList<CoolData> = mutableListOf(
            CoolData("Header 01", "Some basic content"),
            CoolData("Header 02", "Some basic content"),
            CoolData("Header 03", "Some basic content"),
            CoolData("Header 04", "Some basic content"),
            CoolData("Header 05", "Some basic content"),
            CoolData("Header 06", "Some basic content")
            )

        //with möchte mit dieser variable vie lachen ausführen
        with(binding.activityBRecycler){
            val pad = 10
            val pad2 = 5
            layoutManager = GridLayoutManager(this@ActivityB, 1)
            adapter = ListBAdapter(data)
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