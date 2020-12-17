package com.fjmartins.pexels.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fjmartins.pexels.R
import com.fjmartins.pexels.model.Photo

class PexelAdapter(private val dataSet: List<Photo>) :
    RecyclerView.Adapter<PexelAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val photo: ImageView
        val photographer: TextView

        init {
            // Define click listener for the ViewHolder's View.
            photographer = view.findViewById(R.id.photographer)
            photo = view.findViewById(R.id.photo)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.pexel_photo_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val photo = dataSet[position]

        Glide.with(viewHolder.itemView.context).load(photo.src.portrait).into(viewHolder.photo)
        viewHolder.photographer.text = photo.photographer
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}