package com.fjmartins.pexels.ui.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.fjmartins.pexels.R
import com.fjmartins.pexels.di.Injectable
import com.fjmartins.pexels.ui.home.HomeViewModel
import javax.inject.Inject

class FavoritesFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var favoritesViewModel: FavoritesViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        activity?.run { // Instantiate viewModel from the activity's context so that we can get this same instance from other fragments
            favoritesViewModel = ViewModelProvider(this, viewModelFactory).get(FavoritesViewModel::class.java)
        }

        val root = inflater.inflate(R.layout.fragment_favorites, container, false)
        val textView: TextView = root.findViewById(R.id.text_gallery)
        favoritesViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}