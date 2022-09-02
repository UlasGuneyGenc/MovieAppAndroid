package com.ugg.movieapp.ui.artists

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
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

        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                // Add menu items here
                menuInflater.inflate(R.menu.main_menu, menu)

                val search: SearchView = menu.findItem(R.id.search_action).actionView as SearchView
                search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                    override fun onQueryTextSubmit(s: String?): Boolean {
                        return false
                    }

                    override fun onQueryTextChange(s: String?): Boolean {
                        if (s != null) {
                            if(s.length >= 3 || s.isEmpty()){
                                artistsAdapter.displayedList = artistsViewModel.filterResponse(s)
                                artistsAdapter.notifyDataSetChanged()
                            }
                        }
                        return false
                    }
                })
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                // Handle the menu selection

                return true
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}