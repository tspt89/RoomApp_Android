package com.tspt.roomapp.fragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.tspt.roomapp.databinding.FragmentListBinding


class ListFragment : Fragment() {

    private var _binding : FragmentListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentListBinding.inflate(inflater, container, false)

        binding.floatingActionButton.setOnClickListener {
            val action = ListFragmentDirections.actionListFragment2ToAddFragment()
            findNavController().navigate(action)
        }

        return binding.root
    }
}