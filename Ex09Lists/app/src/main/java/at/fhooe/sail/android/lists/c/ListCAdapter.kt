package at.fhooe.sail.android.lists.c

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import at.fhooe.sail.android.lists.R


class ListCAdapter(val mData: MutableList<CountryData>, val mContext: Context) : RecyclerView.Adapter<CountryDataHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryDataHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.activity_c_list_element, null)
        return CountryDataHolder(view)
    }

    override fun onBindViewHolder(holder: CountryDataHolder, position: Int) {
        //so kommt man ans drawable
        val drawable: Drawable? = mContext.getDrawable(mData[position].mFlagge)
        val name: String        = mContext.getString(mData[position].mName)
        val acronym: String     = mContext.getString(mData[position].mAkronym)
        //content in Holder einfügen
        holder.mFlag.setImageDrawable(drawable)
        holder.mName.text = name
        holder.mAcronym.text = acronym

        holder.fabi.findViewById<Button>(R.id.activity_c_list_button_more).setOnClickListener {
            Toast.makeText(mContext, "${holder.mName.text.toString()} ${mContext.getString(R.string.klickinfo)}", Toast.LENGTH_SHORT).show()        }
    }

    override fun getItemCount(): Int {
        return mData.size
    }
}