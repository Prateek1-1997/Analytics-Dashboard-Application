package com.Presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.Models.CardResponseData
import com.SmoothScrollLayoutManager
import com.velmurugan.mvvmretrofitrecyclerviewkotlin.CardAdapter
import com.velmurugan.mvvmretrofitrecyclerviewkotlin.R
import com.velmurugan.mvvmretrofitrecyclerviewkotlin.databinding.LinkCardBinding

class CardViewHolder(val binding: LinkCardBinding) :RecyclerView.ViewHolder(binding.root) {
    companion object {
        fun create(
            inflater: LayoutInflater,
            viewGroup: ViewGroup
        ): CardViewHolder {
            val binding = DataBindingUtil.inflate<LinkCardBinding>(
                inflater,
                R.layout.link_card,
                viewGroup,
                false
            )
            return CardViewHolder(binding)
        }
    }

    fun bind(post: CardResponseData) {

        val imageAdapter = CardAdapter()
        var smoothScrollLayoutManager: SmoothScrollLayoutManager? = null

        binding.cardRv.apply {
            val adapter = binding.cardRv.adapter
            smoothScrollLayoutManager = SmoothScrollLayoutManager(
                binding.cardRv.context,
                RecyclerView.VERTICAL,
                false
            )
            layoutManager = smoothScrollLayoutManager
            itemAnimator = null

            binding.cardRv.adapter = adapter
            binding.cardRv.adapter = imageAdapter
            imageAdapter.submitList(post.liveCoaching as List<Any>?)

            binding.headerSecondTitle.setOnClickListener {
                imageAdapter.submitList(post.recentLink as List<Any>?)
                binding.headerSecondTitle.setTextColor(resources.getColor(R.color.white))
                binding.headerSecondTitle.background=resources.getDrawable(R.drawable.bg_rounded_blue)
                binding.headerTitle.background=resources.getDrawable(R.drawable.bg_rounded)
            }

            binding.headerTitle.setOnClickListener {
                imageAdapter.submitList(post.liveCoaching as List<Any>?)
                binding.headerTitle.setTextColor(resources.getColor(R.color.white))
                binding.headerTitle.background=resources.getDrawable(R.drawable.bg_rounded_blue)
                binding.headerSecondTitle.background=resources.getDrawable(R.drawable.bg_rounded)
            }

        }

    }
}

