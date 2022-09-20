package com.udacity.shoestore.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.InstructionFragmentBinding

class InstructionsFragment : Fragment() {
    private lateinit var binding: InstructionFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.instruction_fragment, container, false)
        setClickListeners()
        return binding.root
    }

    private fun setClickListeners(){
        binding.nextButton.setOnClickListener{
            NavHostFragment.findNavController(this).navigate(R.id.action_instructionsFragment_to_shoesListFragment)

        }
    }


}