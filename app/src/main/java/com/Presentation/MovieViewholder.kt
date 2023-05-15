package com.Presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.velmurugan.mvvmretrofitrecyclerviewkotlin.R
import com.velmurugan.mvvmretrofitrecyclerviewkotlin.TopLinks
import com.velmurugan.mvvmretrofitrecyclerviewkotlin.databinding.AdapterMovieBinding as AdapterMovieBinding

class MovieViewholder(val binding: AdapterMovieBinding) :RecyclerView.ViewHolder(binding.root){
    companion object{
        fun create(inflater: LayoutInflater,
                   viewGroup: ViewGroup
        ) : MovieViewholder {
            val binding = DataBindingUtil.inflate<AdapterMovieBinding>(inflater, R.layout.adapter_movie , viewGroup ,false)
            return MovieViewholder(binding)
        }
    }
    private val photo: ImageView = binding.logo

    fun bind(post: TopLinks){
        print("Bind")

        binding.title.text=post.title
        binding.subtitle.text=post.timesAgo
        binding.clicksCount.text=post.totalClicks.toString()
        binding.textView4.text=post.smartLink.toString()
        Glide.with(photo).load(post.originalImage).into(photo)

    }

}
