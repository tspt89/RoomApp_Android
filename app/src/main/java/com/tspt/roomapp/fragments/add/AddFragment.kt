package com.tspt.roomapp.fragments.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.tspt.roomapp.R
import com.tspt.roomapp.data.User
import com.tspt.roomapp.data.UserViewModel
import com.tspt.roomapp.databinding.FragmentAddBinding

class AddFragment : Fragment() {

    private var _binding : FragmentAddBinding? = null
    private val binding get() = _binding!!

    private lateinit var mUserViewModel : UserViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAddBinding.inflate(inflater,container,false)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        binding.addBtn.setOnClickListener {
            insertToDB()
        }

        return binding.root
    }

    private fun insertToDB() {
        val firstName = binding.firstNameET.text.toString()
        val lastName = binding.lastNameET.text.toString()
        val age = binding.ageET.text.toString().toIntOrNull()

        if(inputCheck(firstName, lastName, age)){
            val user = User(0, firstName, lastName, age!!)
            mUserViewModel.addUser(user)

            Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_SHORT).show()

            findNavController().navigateUp()
        } else {
            Toast.makeText(requireContext(), "Please, fill out all fields", Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(fn : String, ln: String, age: Int?) : Boolean =
        fn.isNotEmpty() && ln.isNotEmpty() && age != null

}