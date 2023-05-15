package com.Presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.Models.ClicksCardData
import com.velmurugan.mvvmretrofitrecyclerviewkotlin.R
import com.velmurugan.mvvmretrofitrecyclerviewkotlin.databinding.ClicksCardBinding


class ClicksDataViewHolder(val binding: ClicksCardBinding) :RecyclerView.ViewHolder(binding.root) {
    companion object {
        fun create(
            inflater: LayoutInflater,
            viewGroup: ViewGroup
        ): ClicksDataViewHolder {
            val binding = DataBindingUtil.inflate<ClicksCardBinding>(
                inflater,
                R.layout.clicks_card,
                viewGroup,
                false
            )
            return ClicksDataViewHolder(binding)
        }
    }

    fun bind(post: ClicksCardData) {

      binding.textView1.text=post.clicksCount.toString()
      binding.textView2.text= post.location
      binding.textView3.text=post.topSource

    }

}

