package com.example.mymovies.screens.movieSerie

import android.app.AlertDialog
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.view.*
import android.widget.ImageView
import androidx.core.content.FileProvider
import androidx.core.graphics.drawable.toBitmap
import androidx.core.net.toUri
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.SimpleTarget
import com.example.mymovies.R
//import com.example.mymovies.database.MovieSerieDatabase
import com.example.mymovies.databinding.FragmentMovieSerieBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_filter.view.*
import kotlinx.android.synthetic.main.fragment_movie_serie.*
import kotlinx.android.synthetic.main.fragment_rating.view.*
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.net.URI

public class MovieSerieFragment : Fragment() {

    private lateinit var viewModel: MovieSerieViewModel
    private lateinit var binding : FragmentMovieSerieBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_movie_serie, container, false
        )

        val application = requireNotNull(this.activity).application


        val arguments = MovieSerieFragmentArgs.fromBundle(arguments!!)
            .imdbId // I need to get the imdbId from arguments!!!!!
        val viewModelFactory = MovieSerieViewModelFactory(arguments, application)

        viewModel =
            ViewModelProviders.of(this, viewModelFactory).get(MovieSerieViewModel::class.java)


        binding.setLifecycleOwner(this);

        binding.viewModel = viewModel


        viewModel.inFavorits.observe(this, Observer {
            if (it == true) {
                binding.addFavorit.setBackgroundResource(android.R.drawable.btn_star_big_on)
                binding.ratingBar2.isVisible = true
                binding.addFavorit.setOnClickListener {
                    viewModel.removeFromFavorits()
                }
            } else {
                binding.addFavorit.setBackgroundResource(android.R.drawable.btn_star_big_off)
                binding.ratingBar2.isVisible = false
                binding.addFavorit.setOnClickListener { view: View ->
                    val mDialogView =
                        LayoutInflater.from(this.context).inflate(R.layout.fragment_rating, null);
                    val mBuilder = AlertDialog.Builder(this.context)
                        .setView(mDialogView)
                        .setTitle("Add rating to favorite")

                    val mAlertDialog = mBuilder.show()

                    mDialogView.addButton.setOnClickListener {
                        mAlertDialog.dismiss()
                        val rating = mDialogView.ratingBar.rating
                        viewModel.addToFavorits(rating)
                    }

                    mDialogView.cancelButton.setOnClickListener {
                        mAlertDialog.dismiss()
                    }

                }
            }
        })

        viewModel.showSnackbarEvent.observe(this, Observer {
            if (it == true) { // Observed state is true.
                if (!viewModel.inFavorits.value!!) {
                    Snackbar.make(
                        activity!!.findViewById(android.R.id.content),
                        getString(R.string.added_to_favorits),
                        Snackbar.LENGTH_SHORT // How long to display the message.
                    ).show()
                } else {
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

        setHasOptionsMenu(true)


        return binding.root;


    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
        inflater.inflate(R.menu.share_movie_menu, menu)

    }

    private fun shareMovie() {
        startActivity(getShareIntent())
    }

    private fun getShareIntent(): Intent {
        //SOURCE: https://github.com/codepath/android_guides/wiki/Sharing-Content-with-Intents
        val imgView : ImageView = binding.poster // getting the image from my xml --> glide downloaded this
        val uri = getLocalBitmapUri(imgView)
        val shareIntent = Intent.createChooser(Intent().apply {
            action = Intent.ACTION_SEND
            type = "image/text/plain"

            putExtra(Intent.EXTRA_TEXT, "Hey, you really should check this " +viewModel.movieSerie.value!!.type + ": "
                    + viewModel.movieSerie.value!!.title + "." + "\n\n " + viewModel.movieSerie.value!!.plot)
            putExtra(Intent.EXTRA_STREAM, uri )
            putExtra(Intent.EXTRA_LOCAL_ONLY, true);
            flags = Intent.FLAG_GRANT_READ_URI_PERMISSION

        }, null)
        return shareIntent
    }

    private fun getLocalBitmapUri(imgView : ImageView): Uri?{
        val drawable : Drawable = imgView.drawable
        val  bmp : Bitmap

        if (drawable is BitmapDrawable){
            bmp = imgView.drawable.toBitmap()
        }else{
            return null
        }

        var bmpUri : Uri? = null
        try{
            val file = File(this.context!!.getExternalFilesDir(Environment.DIRECTORY_PICTURES), "share_image_" + System.currentTimeMillis() + ".png")
            val out = FileOutputStream(file)
            bmp.compress(Bitmap.CompressFormat.PNG,90,out)
            out.close()

            // SOURCE: https://stackoverflow.com/questions/38200282/android-os-fileuriexposedexception-file-storage-emulated-0-test-txt-exposed
            bmpUri = FileProvider.getUriForFile(this.context!!,this.context!!.packageName + ".provider",file)

        }catch (e : IOException){
            e.printStackTrace()
        }
        return bmpUri
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item!!.itemId) {
            R.id.share -> shareMovie()
        }
        return NavigationUI.onNavDestinationSelected(
            item,
            view!!.findNavController()
        ) || super.onOptionsItemSelected(item)
    }


}