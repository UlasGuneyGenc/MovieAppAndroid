package com.ugg.movieapp.ui.artists

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ugg.movieapp.R
import com.ugg.movieapp.adapters.ArtistsAdapter
import com.ugg.movieapp.databinding.FragmentArtistsBinding
import com.ugg.movieapp.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArtistsFragment : Fragment() {

    private var _binding: FragmentArtistsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var artistsViewModel: ArtistsViewModel

    private lateinit var artistsAdapter : ArtistsAdapter
    private lateinit var recyclerView : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentArtistsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = GridLayoutManager(context,3)
        recyclerView = view.findViewById(R.id.artists_Recycler_view)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        artistsViewModel = ViewModelProvider(this).get(ArtistsViewModel::class.java)
        artistsViewModel.myResponse.observe(viewLifecycleOwner, Observer {response ->
            when(response){
                is Resource.Error -> {
                }
                is Resource.Loading -> {

                }
                is Resource.Success -> {
                    artistsAdapter = response.data?.let { context?.let { it1 ->
                        ArtistsAdapter(it.results,
                            it1
                        )
                    } }!!
                    recyclerView.adapter = artistsAdapter
                }
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}