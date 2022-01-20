package com.tspt.roomapp.fragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.tspt.roomapp.data.UserViewModel
import com.tspt.roomapp.databinding.FragmentListBinding


class ListFragment : Fragment() {

    private var _binding : FragmentListBinding? = null
    private val binding get() = _binding!!

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)

        binding.floatingActionButton.setOnClickListener {
            val action = ListFragmentDirections.actionListFragment2ToAddFragment()
            findNavController().navigate(action)
        }

        val adapter = ListAdapter()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        mUserViewModel.readAllData.observe(viewLifecycleOwner, Observer {
            adapter.setData(it)
        })

        return binding.root
    }
}