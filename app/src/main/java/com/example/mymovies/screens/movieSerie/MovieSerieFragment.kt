package com.example.mymovies.screens.movieSerie

import android.app.AlertDialog
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.FileProvider
import androidx.core.graphics.drawable.toBitmap
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.mymovies.R
import com.example.mymovies.databinding.FragmentMovieSerieBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_rating.view.*
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

/**
 * The [MovieSerieFragment] provides the user interface and handles user behaviour for a detailed page of a movie or serie
 */
class MovieSerieFragment : Fragment() {

    private lateinit var viewModel: MovieSerieViewModel
    private lateinit var binding: FragmentMovieSerieBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        /**
         * Creates an instance of [FragmentMovieSerieBindingt]
         *
         * [FragmentMovieSerieBindingt] => Responsible for binding MovieSerie XML files to your model classes
         */ binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_movie_serie, container, false
        )

        val application = requireNotNull(this.activity).application

        /**
         * Gets the imdbId argument that was sent by navigating to this page
         */
        val arguments = MovieSerieFragmentArgs.fromBundle(arguments!!)
            .imdbId

        val viewModelFactory = MovieSerieViewModelFactory(arguments, application)

        /**
         * When the onCreate method is called again (Activity lifecycle), no new instance of [MovieSerieViewModel] will be created
         */
        viewModel =
            ViewModelProviders.of(this, viewModelFactory).get(MovieSerieViewModel::class.java)

        /**
         * Sets the {@link LifecycleOwner} that should be used for observing changes of
         * LiveData in this binding. If a {@link LiveData} is in one of the binding expressions
         * and no LifecycleOwner is set, the LiveData will not be observed and updates to it
         * will not be propagated to the UI.
         */
        binding.setLifecycleOwner(this)

        /**
         * Binds the viewModel from the xml to the viewModel that has been created in this fragment
         */
        binding.viewModel = viewModel

        favoritesAction(binding, viewModel)

        watchListAction(binding, viewModel)

        showSnackbarFavorites(viewModel)

        showSnackbarWatchlist(viewModel)

        setHasOptionsMenu(true)

        return binding.root
    }

    /**
     * Observes inFavorits, which tells if the displayed movie or serie is in favorites
     * Sets the appropriate layout and interactions
     */
    private fun favoritesAction(
        binding: FragmentMovieSerieBinding,
        viewModel: MovieSerieViewModel
    ) {
        viewModel.inFavorits.observe(this, Observer {

            if (it == true) {
                binding.addFavorit.setBackgroundResource(R.drawable.ic_favorit)
                binding.ratingBar2.visibility = View.VISIBLE
                binding.addFavorit.setOnClickListener {
                    viewModel.removeFromFavorits()
                }
            } else {
                binding.addFavorit.setBackgroundResource(R.drawable.ic_not_favorit)
                binding.ratingBar2.visibility = View.GONE
                binding.addFavorit.setOnClickListener { view: View ->
                    val mDialogView =
                        LayoutInflater.from(this.context).inflate(R.layout.fragment_rating, null)
                    val mBuilder = AlertDialog.Builder(this.context)
                        .setView(mDialogView)
                        .setTitle("Add rating to favorite")

                    val mAlertDialog = mBuilder.show()

                    mDialogView.addButton.setOnClickListener {
                        mAlertDialog.dismiss()
                        val rating = mDialogView.ratingBar.rating
                        // temporary setting of ratingbar
                        binding.ratingBar2.rating = rating
                        viewModel.addToFavorits(rating)
                    }

                    mDialogView.cancelButton.setOnClickListener {
                        mAlertDialog.dismiss()
                    }
                }
            }
        })
    }

    /**
     * Observes inFavorits, which tells if the displayed movie or serie is in favorites
     * Sets the appropriate layout and interactions
     */
    private fun watchListAction(
        binding: FragmentMovieSerieBinding,
        viewModel: MovieSerieViewModel
    ) {
        viewModel.inWatchlist.observe(this, Observer {

            if (it == true) {
                binding.addWatchList.setBackgroundResource(R.drawable.ic_in_watchlist)
                binding.addWatchList.setOnClickListener {
                    viewModel.removeFromWatchlist()
                }
            } else {
                binding.addWatchList.setBackgroundResource(R.drawable.ic_not_in_watchlist)
                binding.addWatchList.setOnClickListener { view: View ->
                    viewModel.addToWatchlist()
                }
            }
        })
    }

    /**
     * Shows a snackbar if there was an interaction with the favorites
     */
    private fun showSnackbarFavorites(viewModel: MovieSerieViewModel) {

        viewModel.showSnackbarEventFavorites.observe(this, Observer {
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
                viewModel.doneShowingSnackbarFavorites()
            }
        })
    }

    /**
     * Shows a snackbar if there was an interaction with the favorites
     */
    private fun showSnackbarWatchlist(viewModel: MovieSerieViewModel) {

        viewModel.showSnackbarEventWatchlist.observe(this, Observer {
            if (it == true) { // Observed state is true.
                if (!viewModel.inWatchlist.value!!) {
                    Snackbar.make(
                        activity!!.findViewById(android.R.id.content),
                        getString(R.string.added_to_watchlist),
                        Snackbar.LENGTH_SHORT // How long to display the message.
                    ).show()
                } else {
                    Snackbar.make(
                        activity!!.findViewById(android.R.id.content),
                        getString(R.string.removed_from_watchlist),
                        Snackbar.LENGTH_SHORT // How long to display the message.
                    ).show()
                }

                // Reset state to make sure the snackbar is only shown once, even if the device
                // has a configuration change.
                viewModel.doneShowingSnackbarWatchlist()
            }
        })
    }

    /**
     * Starts shareintent
     */
    private fun shareMovie() {
        startActivity(getShareIntent())
    }

    /**
     * Creates a shareIntent with it's content
     */
    private fun getShareIntent(): Intent {
        // SOURCE: https://github.com/codepath/android_guides/wiki/Sharing-Content-with-Intents
        val imgView: ImageView =
            binding.poster // getting the image from my xml --> glide downloaded this
        val uri = getLocalBitmapUri(imgView)
        val shareIntent = Intent.createChooser(Intent().apply {
            action = Intent.ACTION_SEND
            type = "image/text/plain"

            putExtra(
                Intent.EXTRA_TEXT,
                "Hey, you really should check this " + viewModel.movieSerie.value!!.type + ": " +
                        viewModel.movieSerie.value!!.title + "." + "\n\n " + viewModel.movieSerie.value!!.plot
            )
            putExtra(Intent.EXTRA_STREAM, uri)
            putExtra(Intent.EXTRA_LOCAL_ONLY, true)

            flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
        }, null)
        return shareIntent
    }

    /**
     * Converts the drawable (poster) from a movie to a Uri
     */
    private fun getLocalBitmapUri(imgView: ImageView): Uri? {
        val drawable: Drawable = imgView.drawable
        val bmp: Bitmap

        if (drawable is BitmapDrawable) {
            bmp = imgView.drawable.toBitmap()
        } else {
            return null
        }
        var bmpUri: Uri? = null
        try {
            val file = File(
                this.context!!.getExternalFilesDir(Environment.DIRECTORY_PICTURES),
                "share_image_" + System.currentTimeMillis() + ".png"
            )
            val out = FileOutputStream(file)
            bmp.compress(Bitmap.CompressFormat.PNG, 90, out)
            out.close()

            // SOURCE: https://stackoverflow.com/questions/38200282/android-os-fileuriexposedexception-file-storage-emulated-0-test-txt-exposed
            // Wrong file:// , good content://
            // I'm using another provider --> Since SDK 24 Uri.parse(uri) doesn't work anymore
            // I had to change the manifest and had to create a GenericFileProvider who's an inheritance of FileProvider

            bmpUri = FileProvider.getUriForFile(
                this.context!!,
                this.context!!.packageName + ".provider",
                file
            )
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return bmpUri
    }

    /**
     * Calls method shareMovie after sharemenuItem is pressed
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.share -> shareMovie()
        }
        return NavigationUI.onNavDestinationSelected(
            item,
            view!!.findNavController()
        ) || super.onOptionsItemSelected(item)
    }

    /**
     * Sets the layoutfile to the menu
     */
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.share_movie_menu, menu)
    }
}