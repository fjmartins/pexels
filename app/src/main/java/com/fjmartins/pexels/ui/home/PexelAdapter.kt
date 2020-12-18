package com.fjmartins.pexels.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.fjmartins.pexels.R
import com.fjmartins.pexels.model.Photo

class PexelAdapter(private val listener: PhotoOnClickListener, private val photos: List<Photo>) :
    RecyclerView.Adapter<PexelAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val photo: ImageView = view.findViewById(R.id.photo)
        val photographer: TextView = view.findViewById(R.id.photographer)
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
        val photo = photos[position]

        Glide.with(viewHolder.itemView.context)
            .load(photo.src.portrait)
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .into(viewHolder.photo)

        viewHolder.photographer.text = photo.photographer

        viewHolder.itemView.setOnClickListener {
            listener.onClick(position, photo)
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = photos.size
}

interface PhotoOnClickListener {
    fun onClick(index: Int, photo: Photo)
}