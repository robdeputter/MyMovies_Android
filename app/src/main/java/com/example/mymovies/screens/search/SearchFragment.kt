package com.example.mymovies.screens.search

import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.mymovies.R
import com.example.mymovies.databinding.FragmentSearchBinding
import kotlinx.android.synthetic.main.fragment_filter.view.*
import kotlinx.android.synthetic.main.new_release_item.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

/**
 * The [SearchFragment] provides the user interface and handles user behaviour for searching to movies and series
 */
class SearchFragment : Fragment(), CoroutineScope {

    override val coroutineContext: CoroutineContext = Dispatchers.Main

    private var filterClicked: Boolean = false

    private lateinit var viewModel: SearchViewModel

    private lateinit var mDialogView: View

    private lateinit var binding: FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        /**
         * Creates an instance of [FragmentSearchBinding]
         *
         * [FragmentSearchBinding] => Responsible for binding Favorites XML files to your model classes
         */
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_search, container, false
        )

        /**
         * Sets the {@link LifecycleOwner} that should be used for observing changes of
         * LiveData in this binding. If a {@link LiveData} is in one of the binding expressions
         * and no LifecycleOwner is set, the LiveData will not be observed and updates to it
         * will not be propagated to the UI.
         */
        binding.setLifecycleOwner(this)

        val viewModelFactory = SearchViewModelFactory()

        /**
         * When the onCreate method is called again (Activity lifecycle), no new instance of [SearchViewModel] will be created
         */

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(SearchViewModel::class.java)
        /**
         * Binds the viewModel from the xml to the viewModel that has been created in this fragment
         */
        binding.viewModel = viewModel

        /**
         * [MovieSerieAdapter.MovieSerieListener]  provides the navigation to the detailed page of the clicked movie or serie
         */
        binding.moviesSeriesList.adapter = MovieSerieAdapter(MovieSerieAdapter.MovieSerieListener {
            viewModel.displayMovieSerieDetails(it)
        })

        observeEditText(viewModel, binding)

        observeFilterButton(viewModel, binding)

        navigateToSelectedMovie(viewModel, binding)

        setHasOptionsMenu(true)
        return binding.root
    }

    /**
     * Provides the navigation to the detailed page of movie or serie
     * it = imdbId
     * [SearchFragmentDirections] contains all the directions that are created in the navigation xml file (NavGraph)
     */
    private fun navigateToSelectedMovie(viewModel: SearchViewModel, binding: FragmentSearchBinding) {
        viewModel.navigateToSelectedMovieSerie.observe(this, Observer {
            if (it != null) {
                // this.findNavController().navigate(SearchFragmentDirections.actionSearchFragmentToMovieFragment(it))
                this.findNavController()
                    .navigate(SearchFragmentDirections.actionSearchFragmentToMovieFragment(it))
                viewModel.displayMovieSerieDetailsComplete()
                binding.searchEditText.text = null
            }
        })
    }

    /**
     * Observes the filterButton
     */
    private fun observeFilterButton(viewModel: SearchViewModel, binding: FragmentSearchBinding) {

        /**
         * When the filterbutton is clicked ->
         * show dialog
         * set initial value to spinner
         */
        binding.filterButton.setOnClickListener { view: View ->
            filterClicked = true
            makeDialog(viewModel, binding)
        }
    }

    /**
     * Makes the dialog for filtering the movie -or serieslist
     */
    private fun makeDialog(viewModel: SearchViewModel, binding: FragmentSearchBinding) {
        mDialogView = LayoutInflater.from(this.context).inflate(R.layout.fragment_filter, null)
        val mBuilder = AlertDialog.Builder(this.context)
            .setView(mDialogView)
            .setTitle("Filter")

        if (viewModel.yearFilter.value != "") {
            mDialogView.yearText.setText(viewModel.yearFilter.value)
        }

        val mAlertDialog = mBuilder.show()

        /**
         * When filter is clicked ->
         * get value from spinner (type) and editText (year)
         * dismiss dialog
         * send a request to renew the movies and series
         */
        mDialogView.filter.setOnClickListener {
            mAlertDialog.dismiss()
            val type = mDialogView.typeSpinner.selectedItem.toString()
            val year = mDialogView.yearText.text.toString()
            // send request with filters
            viewModel.getMoviesSeriesForName(binding.searchEditText.text.toString(), year, type)
            filterClicked = false
        }

        /**
         * When clear is clicked ->
         * clear all fields and dismiss dialog
         * send a new request to renew the movies and series
         */
        mDialogView.clear.setOnClickListener {
            mAlertDialog.dismiss()
            mDialogView.typeSpinner.setSelection(-1)
            mDialogView.yearText.text.clear()
            // send request to reset te values of the recyclerview
            viewModel.getMoviesSeriesForName(binding.searchEditText.text.toString(), "", "")
            filterClicked = false
        }
    }

    /**
     * Observes editText
     */
    private fun observeEditText(viewModel: SearchViewModel, binding: FragmentSearchBinding) {
        // SOURCE: https://medium.com/@pro100svitlo/edittext-debounce-with-kotlin-coroutines-fd134d54f4e9
        // --> Tim Geldof gave me this URL
        binding.searchEditText.addTextChangedListener(object : TextWatcher {
            private var searchFor = ""
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            }

            /**
             * After text changed -> send new request to refresh the movies and series
             */
            override fun afterTextChanged(s: Editable) {
                val searchText = s.toString().trim()
                if (searchText == searchFor)
                    return

                searchFor = searchText

                launch {
                    delay(600) // debounce timeOut
                    if (searchText != searchFor)
                        return@launch

                    viewModel.getMoviesSeriesForName(s.toString(), null, null)
                }
            }
        })
    }

    /**
     * Saves the current state of the page. If a dialog is opened, it will save "true" in outState
     */
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("FILTER_CLICKED", filterClicked)
        if(filterClicked == true){
            if (mDialogView!!.yearText.text.isNotBlank()) {
                outState.putString("YEAR_TEXT", mDialogView.yearText.text.toString())
            }
        }

    }

    /**
     * Makes it possible to rotate the screen and not losing the dialogview
     */
    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        if (savedInstanceState != null) {
            if (savedInstanceState.getBoolean("FILTER_CLICKED") == true) {
                makeDialog(viewModel, binding)
                filterClicked = true

                if (savedInstanceState.getString("YEAR_TEXT") != null) {
                    mDialogView.yearText.setText(savedInstanceState.getString("YEAR_TEXT"))
                }
            }
        }
    }
}