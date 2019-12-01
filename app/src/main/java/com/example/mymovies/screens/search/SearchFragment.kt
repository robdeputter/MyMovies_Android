package com.example.mymovies.screens.search

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.view.size
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.mymovies.R
import com.example.mymovies.database.MyMoviesDatabase
import com.example.mymovies.databinding.FragmentSearchBinding
import com.example.mymovies.repository.FavoritsRepository
import kotlinx.android.synthetic.main.fragment_filter.view.*
import kotlinx.android.synthetic.main.new_release_item.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class SearchFragment : Fragment(), CoroutineScope {

    override val coroutineContext: CoroutineContext = Dispatchers.Main


    private val viewModel: SearchViewModel by lazy {
        ViewModelProviders.of(this).get(SearchViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentSearchBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_search, container, false
        )

        binding.setLifecycleOwner(this)

        binding.viewModel = viewModel

        binding.moviesSeriesList.adapter = MovieSerieAdapter(MovieSerieAdapter.MovieSerieListener {
            viewModel.displayMovieSerieDetails(it)
        })


        observeEditText(viewModel,binding)

        observeFilterButton(viewModel,binding)

        navigateToSelectedMovie(viewModel,binding)

        setHasOptionsMenu(true)
        return binding.root;
    }

    private fun navigateToSelectedMovie(viewModel: SearchViewModel, binding: FragmentSearchBinding){
        viewModel.navigateToSelectedMovieSerie.observe(this, Observer {
            if (it != null) {
                //this.findNavController().navigate(SearchFragmentDirections.actionSearchFragmentToMovieFragment(it))
                this.findNavController()
                    .navigate(SearchFragmentDirections.actionSearchFragmentToMovieFragment(it))
                viewModel.displayMovieSerieDetailsComplete()
                binding.searchEditText.text = null
            }
        })
    }

    private fun observeFilterButton(viewModel: SearchViewModel, binding: FragmentSearchBinding){
        binding.filterButton.setOnClickListener {view: View ->
            val mDialogView = LayoutInflater.from(this.context).inflate(R.layout.fragment_filter, null);
            val mBuilder = AlertDialog.Builder(this.context)
                .setView(mDialogView)
                .setTitle("Filter")

            val mAlertDialog = mBuilder.show()

            mDialogView.filter.setOnClickListener {
                mAlertDialog.dismiss()
                val type = mDialogView.typeSpinner.selectedItem.toString()
                val year = mDialogView.yearText.text.toString()
                //send request with filters
                viewModel.getMoviesSeriesForName(binding.searchEditText.text.toString(),year,type)
            }

            mDialogView.clear.setOnClickListener{
                mAlertDialog.dismiss()
                mDialogView.typeSpinner.setSelection(-1)
                mDialogView.yearText.text.clear()
                //send request to reset te values of the recyclerview
                viewModel.getMoviesSeriesForName(binding.searchEditText.text.toString(), "","")
            }

        }
    }

    private fun observeEditText(viewModel: SearchViewModel,binding: FragmentSearchBinding){
        //SOURCE: https://medium.com/@pro100svitlo/edittext-debounce-with-kotlin-coroutines-fd134d54f4e9
        // --> Tim Geldof gave me this URL
        binding.searchEditText.addTextChangedListener(object : TextWatcher {
            private var searchFor = ""
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable) {
                val searchText = s.toString().trim()
                if (searchText == searchFor)
                    return

                searchFor = searchText

                launch {
                    delay(600)  //debounce timeOut
                    if (searchText != searchFor)
                        return@launch

                    // do our magic here
                    viewModel.getMoviesSeriesForName(s.toString(),null,null)
                }
            }
        })
    }
}