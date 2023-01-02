package com.mbs.catinfo

import android.app.Activity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mbs.catinfo.databinding.ActivityMainBinding
import com.mbs.catinfo.databinding.RecyclerContentBinding

class CatsViewHolder(private val bind: RecyclerContentBinding): RecyclerView.ViewHolder(bind.root) {
    fun bind(cat: CatsModel) {
        Glide.with(Activity().applicationContext)
            .load(cat.url).into(bind.catPhoto)
        bind.breedPlaceholder.text = cat.breeds[0].name
        bind.description.text = cat.breeds[0].description
    }
}