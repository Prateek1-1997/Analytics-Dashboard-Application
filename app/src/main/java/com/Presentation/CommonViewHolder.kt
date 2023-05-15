package com.Presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.Models.CommonData
import com.velmurugan.mvvmretrofitrecyclerviewkotlin.R
import com.velmurugan.mvvmretrofitrecyclerviewkotlin.databinding.CommonCtaBinding

class CommonViewHolder(val binding: CommonCtaBinding) :RecyclerView.ViewHolder(binding.root) {
    companion object {
        fun create(
            inflater: LayoutInflater,
            viewGroup: ViewGroup
        ): CommonViewHolder {
            val binding = DataBindingUtil.inflate<CommonCtaBinding>(
                inflater,
                R.layout.common_cta,
                viewGroup,
                false
            )
            return CommonViewHolder(binding)
        }
    }

    fun bind(post: CommonData) {

        if(post.isForFaq){
            binding.textView5.text="View All Links"
            binding.imageview5.setImageResource(R.drawable.ic_link)

        }

    }
}

