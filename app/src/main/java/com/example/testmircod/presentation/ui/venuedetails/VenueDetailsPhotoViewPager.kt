package com.example.testmircod.presentation.ui.venuedetails


import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.venue_details_pager_view.view.*
import com.example.testmircod.R


class VenueDetailsPhotoViewPager(val images: Pair<List<String>, Boolean>, val listener: ((image: String) -> Unit)? = null): PagerAdapter() {

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun getCount(): Int {
        return images.first.size
    }


    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(container.context)
        val layout =
            inflater.inflate(R.layout.venue_details_pager_view, container, false) as ViewGroup

        Glide.with(layout.context)
            .load(images.first[position])
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
                    layout.progressBar.visibility = View.GONE

                    if(images.second) {
                        layout.category_image.visibility = View.VISIBLE
                        layout.pagerImage.visibility = View.INVISIBLE
                    }else{
                        layout.category_image.visibility = View.INVISIBLE
                        layout.pagerImage.visibility = View.VISIBLE
                    }

                    return false
                }

                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: com.bumptech.glide.request.target.Target<Drawable?>?,
                    isFirstResource: Boolean
                ): Boolean {
                    layout.progressBar.visibility = View.GONE
                    return true
                }
            })
            .into(
                if (images.second)
                    layout.category_image
                            else
                    layout.pagerImage)

        if(!images.second) {
            layout.setOnClickListener {
                listener?.invoke(images.first[position])
            }
        }

        container.addView(layout)

        return layout
}

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View?)
    }

}