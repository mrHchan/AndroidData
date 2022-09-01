package com.androiddata.ui.detail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.androiddata.LOG_TAG
import com.androiddata.R
import com.androiddata.databinding.FragmentDetailBinding
import com.androiddata.ui.shared.SharedViewModel


class DetailFragment : Fragment() {

    private lateinit var viewModel: SharedViewModel
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        (requireActivity() as AppCompatActivity).run {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        @Suppress("DEPRECATION")
        setHasOptionsMenu(true)
        navController = Navigation.findNavController(
            requireActivity(), R.id.nav_host
        )

        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        val binding = FragmentDetailBinding.inflate(
            inflater, container, false
        )
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        return binding.root


    }

    @Deprecated("Deprecated in Java")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {

            navController.navigateUp()
        }
        @Suppress("DEPRECATION")
        return super.onOptionsItemSelected(item)

    }


}