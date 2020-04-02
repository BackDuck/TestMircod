package com.example.testmircod.presentation.ui.venuelist

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.venue_list_item.view.*
import com.example.testmircod.R
import com.example.testmircod.presentation.model.VenueModel


class VenueRecyclerviewAdapter : RecyclerView.Adapter<VenueRecyclerviewAdapter.ThemesViewHolder>() {

    var items: List<VenueModel> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var isChild = false

    var listener: ((task: VenueModel) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThemesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.venue_list_item, parent, false)
        return ThemesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ThemesViewHolder, position: Int) {
        holder.bind(position)
    }


    inner class ThemesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal fun bind(position: Int) {
            val item = items[position]

            itemView.setOnClickListener {
                listener?.invoke(item)
            }

            itemView.name.text = item.name
            itemView.distance.text = StringBuilder().append("Расстояние ").append(item.distance.toString()).append("м.")

            Glide.with(itemView.context)
                .load( if (item.photos.isNotEmpty()) {
                    item.photos.first()
                } else {
                    item.categoryIcon
                })
                .apply(
                    RequestOptions()
                        .centerCrop()

                )
                .listener(object : RequestListener<Drawable?> {
                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: com.bumptech.glide.request.target.Target<Drawable?>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        itemView.progressBar.visibility = View.GONE
                        if (item.photos.isNotEmpty()) {
                            itemView.imageView.visibility = View.VISIBLE
                            itemView.category_image.visibility = View.INVISIBLE
                        } else {
                            itemView.imageView.visibility = View.INVISIBLE
                            itemView.category_image.visibility = View.VISIBLE
                        }
                        return false
                    }

                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: com.bumptech.glide.request.target.Target<Drawable?>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        itemView.progressBar.visibility = View.GONE
                        return true
                    }
                })
                .into(if (item.photos.isNotEmpty()) {
                    itemView.imageView
                } else {
                    itemView.category_image
                })

        }
    }
}