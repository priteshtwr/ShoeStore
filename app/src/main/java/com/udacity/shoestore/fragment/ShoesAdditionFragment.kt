package com.udacity.shoestore.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoesAddFragmentBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeViewModel

class ShoesAdditionFragment: Fragment() {
    /**
     * // Get a reference to the ViewModel scoped to this Fragment
    val viewModel by viewModels<MyViewModel>()

    // Get a reference to the ViewModel scoped to its Activity
    val viewModel by activityViewModels<MyViewModel>()
     */
    private lateinit var binding:ShoesAddFragmentBinding
    private val shoeViewModel by activityViewModels<ShoeViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.shoes_add_fragment, container, false)
        setClickListeners()
        binding.lifecycleOwner = this
        binding.shoeViewModel = shoeViewModel

        return binding.root
    }

    private fun setClickListeners(){
        binding.saveButton.setOnClickListener{
            if(binding.shoesnameEditext.text.isNotEmpty() && binding.companyEdittext.text.isNotEmpty()
                && binding.shoesizeEdittext.text.isNotEmpty() && binding.descriptionEditext.text.isNotEmpty()){
                shoeViewModel.addShoe()
                NavHostFragment.findNavController(this).navigateUp()
            }
            else {
                Toast.makeText(context,"Please enter all the fields",Toast.LENGTH_SHORT).show()
            }


        }

        binding.cancelButton.setOnClickListener{
            NavHostFragment.findNavController(this).navigateUp()

        }
    }
}