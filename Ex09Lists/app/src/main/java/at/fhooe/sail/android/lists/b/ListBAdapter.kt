package at.fhooe.sail.android.lists.b

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import at.fhooe.sail.android.lists.R

class ListBAdapter(val mData: MutableList<CoolData>) : RecyclerView.Adapter<CoolDataHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoolDataHolder {
        val inflator: LayoutInflater = LayoutInflater.from(parent.context)
        val view: View = inflator.inflate(R.layout.activity_b_list_elment, null)
        return CoolDataHolder(view)
    }

    override fun getItemCount(): Int {
       return mData.size
    }

    //Quote Krösche: das ding was das ding anbindet
    override fun onBindViewHolder(holder: CoolDataHolder, position: Int) {
        holder.mHeader.text = mData[position].mHeader //eckige klammer steht für "get element at"
        holder.mContent.text = mData[position].mContent
    }
}