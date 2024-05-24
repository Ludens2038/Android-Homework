package at.fhooe.sail.android.lists.c

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import at.fhooe.sail.android.lists.R

class CountryDataHolder(val fabi: View) : RecyclerView.ViewHolder(fabi) {
    val mAcronym: TextView
    val mName: TextView
    val mFlag: ImageView


    init {
        mAcronym = fabi.findViewById(R.id.activity_c_list_element_acronym)
        mName    = fabi.findViewById(R.id.activity_c_list_element_name)
        mFlag    = fabi.findViewById(R.id.activity_c_list_element_flag)
    }

}