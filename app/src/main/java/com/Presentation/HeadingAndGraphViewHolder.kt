package com.Presentation

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.Models.HeadingAndGraphData
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries
import com.velmurugan.mvvmretrofitrecyclerviewkotlin.R
import com.velmurugan.mvvmretrofitrecyclerviewkotlin.databinding.NameGraphBinding
import java.util.*


class HeadingAndGraphViewHolder(val binding: NameGraphBinding) :RecyclerView.ViewHolder(binding.root) {
    companion object {
        fun create(
            inflater: LayoutInflater,
            viewGroup: ViewGroup
        ): HeadingAndGraphViewHolder {
            val binding = DataBindingUtil.inflate<NameGraphBinding>(
                inflater,
                com.velmurugan.mvvmretrofitrecyclerviewkotlin.R.layout.name_graph,
                viewGroup,
                false
            )
            return HeadingAndGraphViewHolder(binding)
        }
    }

    fun bind(post: HeadingAndGraphData) {
        val c = Calendar.getInstance()
        val hour = c.get(Calendar.HOUR_OF_DAY)

        if (hour in 1..11) {
            binding.headerTitle.text = "Good Morning"
        } else if (hour in 12..18) {
            binding.headerTitle.text = "Good Afternoon"
        } else {
            binding.headerTitle.text = "Good Evening"
        }


        val graphView = binding.myGraphView

        graphView.setOnTouchListener { v, event ->
            v.parent.requestDisallowInterceptTouchEvent(true)
            false
        }

        val dataPoints = arrayOf(
            DataPoint(0.0, post.graphData.day2.toDouble()),
            DataPoint(1.0, post.graphData.day3.toDouble()),
            DataPoint(2.0, post.graphData.day4.toDouble()),
            DataPoint(3.0, post.graphData.day5.toDouble()),
            DataPoint(4.0, post.graphData.day6.toDouble()),
            DataPoint(5.0, post.graphData.day7.toDouble()),
            DataPoint(6.0, post.graphData.day8.toDouble()),
            DataPoint(7.0, post.graphData.day9.toDouble()),
            DataPoint(8.0, post.graphData.day10.toDouble()),
            DataPoint(9.0, post.graphData.day11.toDouble()),
            DataPoint(10.0, post.graphData.day12.toDouble()),
            DataPoint(11.0, post.graphData.day13.toDouble()),
            DataPoint(12.0, post.graphData.day14.toDouble()),
            DataPoint(13.0, post.graphData.day15.toDouble()),
            DataPoint(14.0, post.graphData.day16.toDouble()),
            DataPoint(15.0, post.graphData.day17.toDouble()),
            DataPoint(16.0, post.graphData.day18.toDouble()),
            DataPoint(17.0, post.graphData.day19.toDouble()),
            DataPoint(18.0, post.graphData.day20.toDouble()),
            DataPoint(19.0, post.graphData.day21.toDouble()),
            DataPoint(20.0, post.graphData.day22.toDouble()),
            DataPoint(21.0, post.graphData.day23.toDouble()),
            DataPoint(22.0, post.graphData.day24.toDouble()),
            DataPoint(23.0, post.graphData.day25.toDouble()),
            DataPoint(24.0, post.graphData.day26.toDouble()),
            DataPoint(25.0, post.graphData.day27.toDouble()),
            DataPoint(26.0, post.graphData.day28.toDouble()),
            DataPoint(27.0, post.graphData.day29.toDouble()),
            DataPoint(28.0, post.graphData.day30.toDouble()),

        )

        val series = LineGraphSeries<DataPoint>(dataPoints)
        graphView.viewport.borderColor= R.color.black
        graphView.addSeries(series)

        graphView.title = "My Graph"
        graphView.gridLabelRenderer.horizontalAxisTitle = "X Axis"
        graphView.gridLabelRenderer.verticalAxisTitle = "Y Axis"
        graphView.gridLabelRenderer.verticalAxisTitleColor=Color.BLACK
        graphView.gridLabelRenderer.horizontalAxisTitleColor=Color.BLACK
        graphView.gridLabelRenderer.gridColor = Color.BLACK
        graphView.gridLabelRenderer.verticalLabelsColor = Color.BLUE
        graphView.gridLabelRenderer.horizontalLabelsColor = Color.RED
        val viewport = graphView.viewport
        viewport.isScalable = true
        viewport.isScrollable = true









    }

}


