package com.example.mymovies.screens.movieSerie

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.mymovies.R
//import com.example.mymovies.database.MovieSerieDatabase
import com.example.mymovies.databinding.FragmentMovieSerieBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_movie_serie.*
import kotlinx.android.synthetic.main.fragment_rating.view.*

public class MovieSerieFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentMovieSerieBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_movie_serie, container, false)

        val application = requireNotNull(this.activity).application


        val arguments = MovieSerieFragmentArgs.fromBundle(arguments!!).imdbId // I need to get the imdbId from arguments!!!!!
        val viewModelFactory = MovieSerieViewModelFactory(arguments, application)

        val viewModel = ViewModelProviders.of(this,viewModelFactory).get(MovieSerieViewModel::class.java)


        binding.setLifecycleOwner(this);

        binding.viewModel = viewModel


        viewModel.inFavorits.observe(this, Observer {
            if(it == true){
                binding.addFavorit.setBackgroundResource(android.R.drawable.btn_star_big_on)
                binding.ratingBar2.isVisible = true
                binding.addFavorit.setOnClickListener{
                    viewModel.removeFromFavorits()
                }
            }
            else{
                binding.addFavorit.setBackgroundResource(android.R.drawable.btn_star_big_off)
                binding.ratingBar2.isVisible = false
                binding.addFavorit.setOnClickListener {view: View ->
                    val mDialogView = LayoutInflater.from(this.context).inflate(R.layout.fragment_rating, null);
                    val mBuilder = AlertDialog.Builder(this.context)
                        .setView(mDialogView)
                        .setTitle("Add rating to favorite")

                    val mAlertDialog = mBuilder.show()

                    mDialogView.addButton.setOnClickListener {
                        mAlertDialog.dismiss()
                        val rating = mDialogView.ratingBar.rating
                        viewModel.addToFavorits(rating)
                    }

                    mDialogView.cancelButton.setOnClickListener{
                        mAlertDialog.dismiss()
                    }

                }
            }
        })

        viewModel.showSnackbarEvent.observe(this, Observer {
            if (it == true) { // Observed state is true.
                if (!viewModel.inFavorits.value!!){
                    Snackbar.make(
                        activity!!.findViewById(android.R.id.content),
                        getString(R.string.added_to_favorits),
                        Snackbar.LENGTH_SHORT // How long to display the message.
                    ).show()
                }
                else{
                    Snackbar.make(
                        activity!!.findViewById(android.R.id.content),
                        getString(R.string.removed_to_favorits),
                        Snackbar.LENGTH_SHORT // How long to display the message.
                    ).show()
                }

                // Reset state to make sure the snackbar is only shown once, even if the device
                // has a configuration change.
                viewModel.doneShowingSnackbar()
            }
        })



        binding.addFavorit.setBackgroundResource(android.R.drawable.btn_star_big_on)
        return binding.root;


    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(
            item,
            view!!.findNavController()
        ) || super.onOptionsItemSelected(item)
    }



}