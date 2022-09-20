package com.udacity.shoestore.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.LoginFragmentBinding

class LoginFragment:Fragment() {

    private lateinit var binding:LoginFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.login_fragment, container, false)
        setUpClickListeners()
        return binding.root
    }

    private fun setUpClickListeners(){
        binding.loginButton.setOnClickListener{
            handleButtonClick()
        }
        binding.newLoginButton.setOnClickListener{
            handleButtonClick()
        }
    }

    private fun handleButtonClick(){
        if(binding.emailEditText.text.isNotEmpty() && binding.passwordEditText.text.isNotEmpty()){
            NavHostFragment.findNavController(this).navigate(R.id.action_loginFragment_to_welcomeFragment)
        }
        else {
            Toast.makeText(context,"Please Enter All the Details",Toast.LENGTH_SHORT).show()
        }
    }
}