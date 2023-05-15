package com.Presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.Models.CommonButtonData
import com.velmurugan.mvvmretrofitrecyclerviewkotlin.R
import com.velmurugan.mvvmretrofitrecyclerviewkotlin.databinding.CommonButtonBinding

class CommonButtonViewHolder(val binding: CommonButtonBinding) :RecyclerView.ViewHolder(binding.root) {
    companion object {
        fun create(
            inflater: LayoutInflater,
            viewGroup: ViewGroup
        ): CommonButtonViewHolder {
            val binding = DataBindingUtil.inflate<CommonButtonBinding>(
                inflater,
                R.layout.common_button,
                viewGroup,
                false
            )
            return CommonButtonViewHolder(binding)
        }
    }

    fun bind(post: CommonButtonData) {

        if(post.isForFaq){
            binding.whatsappText.text="Frequently Asked Questions"
            binding.whatsAppImage.setImageResource(R.drawable.question_mark)
            binding.card.setCardBackgroundColor(itemView.context.resources.getColor(R.color.blue_60))
            binding.whatsAppImage.setColorFilter(ContextCompat.getColor(itemView.context, R.color.green_teal), android.graphics.PorterDuff.Mode.MULTIPLY);

        }

    }
}

