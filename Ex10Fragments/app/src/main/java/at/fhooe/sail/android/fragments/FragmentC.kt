package at.fhooe.sail.android.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import at.fhooe.sail.android.fragments.databinding.FragmentCBinding


//fragmente müssen nicht in der manifest angekündigt werden
class FragmentC : Fragment() {

    var _binding: FragmentCBinding? = null
    val binding: FragmentCBinding
        get() = _binding!! //rufzeichen dafür dass _binding zurückgegeben wird, wenn null kommt exception

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCBinding.inflate(inflater)

        binding.fragmentCBClick.setOnClickListener {
            Toast.makeText(context, "Fragment C click", Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}