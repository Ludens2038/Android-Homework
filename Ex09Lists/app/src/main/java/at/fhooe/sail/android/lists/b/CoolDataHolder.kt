package at.fhooe.sail.android.lists.b

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import at.fhooe.sail.android.lists.R

class CoolDataHolder(val axel: View) : RecyclerView.ViewHolder(axel){
    val mHeader: TextView
    val mContent: TextView
    init {
        mHeader = axel.findViewById(R.id.activity_b_list_element_header)
        mContent = axel.findViewById(R.id.activity_b_list_element_content)
    }
}