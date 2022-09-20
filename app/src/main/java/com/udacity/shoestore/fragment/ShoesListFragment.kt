package com.udacity.shoestore.fragment

import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoesListFragmentBinding
import com.udacity.shoestore.models.ShoeViewModel


class ShoesListFragment : Fragment(){
    private lateinit var binding:ShoesListFragmentBinding
    private lateinit var shoeViewModel: ShoeViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.shoes_list_fragment, container, false)
        shoeViewModel = ViewModelProvider(requireActivity()).get(ShoeViewModel::class.java)
        binding.lifecycleOwner = this
        observeData()
        setClickListeners()
        setHasOptionsMenu(true)
        return binding.root
    }

    private fun setClickListeners(){
        binding.shoeAdditionButton.setOnClickListener{
            NavHostFragment.findNavController(this).navigate(R.id.action_shoesListFragment_to_shoesAdditionFragment)

        }
    }

    private fun observeData(){

        shoeViewModel.shoeList.observe(viewLifecycleOwner, Observer{
            for(shoe in it) {
                val textView = TextView(context)
                textView.layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT
                )
                textView.text = shoe.name
                textView.textSize = 22.0f
                textView.gravity = Gravity.CENTER
                binding.shoeListingLinearlayout.addView(textView)
            }
            binding.apply {
                invalidateAll()

            }

        })
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.loginFragment -> {
                NavHostFragment.findNavController(this).navigate(R.id.action_shoesListFragment_to_loginFragment)

            }
        }
        return super.onOptionsItemSelected(item)
    }

}