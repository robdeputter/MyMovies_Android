package com.example.mymovies.screens.favorits

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.mymovies.R
import com.example.mymovies.databinding.FragmentFavoritsBinding


class FavoritsFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentFavoritsBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_favorits, container, false)

        return binding.root;

    }


}