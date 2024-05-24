package at.fhooe.sail.android.lists.a

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import at.fhooe.sail.android.lists.R

class ListAAdapter(val mData: MutableList<SimpleData>) : RecyclerView.Adapter<SimpleDataHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleDataHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context) //um layoutinflater zu bekommen
        val view: View = layoutInflater.inflate(R.layout.activity_a_list_element, null) //listenelement holen
        return SimpleDataHolder(view)
    }

    override fun onBindViewHolder(holder: SimpleDataHolder, position: Int) {
        holder.mContent.text = mData[position].content
    }

    override fun getItemCount(): Int {
        return mData.size
    }
}
