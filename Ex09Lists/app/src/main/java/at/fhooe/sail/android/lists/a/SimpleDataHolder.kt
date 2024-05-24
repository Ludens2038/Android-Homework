package at.fhooe.sail.android.lists.a

import android.view.MotionEvent
import android.view.TextureView
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import at.fhooe.sail.android.lists.R

class SimpleDataHolder(val root: View) : RecyclerView.ViewHolder(root) {

    //Holder
    var mContent: TextView
            init {
                mContent = root.findViewById(R.id.activity_a_list_element_content) as TextView

                root.setOnClickListener {
                    Toast.makeText(root.context, "Eintrag (${mContent.text.toString()}) ausgewählt", Toast.LENGTH_SHORT).show()
                }

                root.setOnTouchListener { _, event ->
                    if (event.action == MotionEvent.ACTION_DOWN){
                        bindingAdapter?.notifyItemChanged(bindingAdapterPosition)
                    }
                    /*true problematisch weil: system erkennt eine berührung, wird interpretiert,
                    frage wer möchte sich drum kümmern, wenn true dann sagt touch listener
                    "ok ich  habe mich darum gekümmert" und es wird nicht mehr weitergegeben,
                    bei false wird es auf weitere lsitener weitegegeben
                     */
                    false
                }

            }

}