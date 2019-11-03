package com.example.mymovies.screens.wantToWatch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.mymovies.R
import com.example.mymovies.databinding.FragmentWantToWatchBinding

class WantToWatchFragment : Fragment(){


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentWantToWatchBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_want_to_watch, container, false)

        return binding.root;

    }
}