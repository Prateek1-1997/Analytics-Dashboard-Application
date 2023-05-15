package com.velmurugan.mvvmretrofitrecyclerviewkotlin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.*
import com.Models.*
import com.Presentation.*

class MainAdapter: ListAdapter<Any,RecyclerView.ViewHolder>(MovieListDiffCallback()) {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder{
        var viewHolder : RecyclerView.ViewHolder? = null
        val inflater = LayoutInflater.from(parent.context)
        when(viewType){
            R.layout.link_card -> viewHolder = CardViewHolder.create(inflater, parent)

            R.layout.name_graph -> viewHolder = HeadingAndGraphViewHolder.create(inflater,parent)

            R.layout.common_button -> viewHolder = CommonButtonViewHolder.create(inflater,parent)

            R.layout.clicks_card -> viewHolder = ClicksDataViewHolder.create(inflater,parent)

            R.layout.common_cta -> viewHolder = CommonViewHolder.create(inflater,parent)



        }
        return  (viewHolder!!)
    }

    override fun getItemViewType(position: Int): Int {
        super.getItemViewType(position)
        val item = getItem(position)
        var itemViewType = 0
        when(item) {
            is CardResponseData -> itemViewType = R.layout.link_card

            is HeadingAndGraphData -> itemViewType = R.layout.name_graph

            is CommonButtonData -> itemViewType = R.layout.common_button

            is ClicksCardData -> itemViewType = R.layout.clicks_card

            is CommonData -> itemViewType = R.layout.common_cta

        }
        return itemViewType


    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        when(holder){
            is CardViewHolder -> holder.bind(item as CardResponseData)

            is HeadingAndGraphViewHolder -> holder.bind(item as HeadingAndGraphData)

            is CommonButtonViewHolder -> holder.bind(item as CommonButtonData)

            is ClicksDataViewHolder -> holder.bind(item as ClicksCardData)

            is CommonViewHolder -> holder.bind(item as CommonData)
        }
    }
}

