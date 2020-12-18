package com.fjmartins.pexels.ui.home

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fjmartins.pexels.R
import com.fjmartins.pexels.di.Injectable
import com.fjmartins.pexels.model.Photo
import javax.inject.Inject


class HomeFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.run { // Instantiate viewModel from the activity's context so that we can get this same instance from other fragments
            homeViewModel = ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)
        }

        val root = inflater.inflate(R.layout.fragment_home, container, false)
        setHasOptionsMenu(true)

        homeViewModel.photos.observe(viewLifecycleOwner, Observer { photos ->
            val mLayoutManager: RecyclerView.LayoutManager = GridLayoutManager(context, 2)
            root.findViewById<RecyclerView>(R.id.homeRecyclerView).apply {
                layoutManager = mLayoutManager
                adapter = PexelAdapter(object : PhotoOnClickListener {
                    override fun onClick(index: Int, photo: Photo) {
                        val intent = Intent()
                        intent.action = Intent.ACTION_VIEW
                        intent.setDataAndType(Uri.parse(photo.src.original), "image/*")
                        startActivity(intent)
                    }
                }, photos)
            }
        })

        return root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main, menu)

        val searchItem: MenuItem? = menu.findItem(R.id.action_search)
        val searchManager = activity?.getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView: SearchView? = searchItem?.actionView as SearchView

        searchView?.setSearchableInfo(searchManager.getSearchableInfo(activity?.componentName))
        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                homeViewModel.getImages(query)
                return true
            }

            override fun onQueryTextChange(s: String): Boolean {
                return false
            }
        })

        super.onCreateOptionsMenu(menu, inflater)
    }
}