package com.mbs.catinfo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mbs.catinfo.databinding.RecyclerContentBinding

class CatsAdapter : RecyclerView.Adapter<CatsViewHolder>() {
    private var cats: List<CatsModel> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatsViewHolder {
        val item = RecyclerContentBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return CatsViewHolder(item)
    }

    override fun onBindViewHolder(holder: CatsViewHolder, position: Int) {
        holder.bind(cats[position])
    }

    override fun getItemCount(): Int {
        return cats.size
    }
    fun updateCats(list: List<CatsModel>) {
        cats = list
    }
}