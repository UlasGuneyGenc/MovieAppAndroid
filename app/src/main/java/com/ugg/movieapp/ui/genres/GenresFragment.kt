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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ugg.movieapp.R
import com.ugg.movieapp.adapters.GenresAdapter
import com.ugg.movieapp.databinding.FragmentGenresBinding
import com.ugg.movieapp.repository.Repository
import com.ugg.movieapp.util.Resource
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class GenresFragment : Fragment() {

    private var _binding: FragmentGenresBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var genresViewModel: GenresViewModel

    private lateinit var genresAdapter : GenresAdapter
    private lateinit var recyclerView : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentGenresBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.genres_Recycler_view)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)

        genresViewModel = ViewModelProvider(this).get(GenresViewModel::class.java)
        genresViewModel.myResponse.observe(viewLifecycleOwner, Observer {response ->
            when(response){
                is Resource.Error -> {
                }
                is Resource.Loading -> {

                }
                is Resource.Success -> {
                    genresAdapter = response.data?.let { GenresAdapter(it.genres) }!!
                    recyclerView.adapter = genresAdapter
                }
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}