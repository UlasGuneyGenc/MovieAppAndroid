package com.ugg.movieapp.ui.genres

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ugg.movieapp.databinding.FragmentGenresBinding
import com.ugg.movieapp.repository.Repository
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GenresFragment : Fragment() {

    private var _binding: FragmentGenresBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var genresViewModel: GenresViewModel



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentGenresBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val repository = Repository()
        val viewModelFactory = GenresViewModelFactory(repository)
        genresViewModel = ViewModelProvider(this, viewModelFactory).get(GenresViewModel::class.java)
        genresViewModel.getGenres()
        genresViewModel.myResponse.observe(viewLifecycleOwner, Observer {response ->
            Log.d("Response", response.genres[0].name)
        })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}