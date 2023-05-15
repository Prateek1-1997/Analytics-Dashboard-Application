package com.Presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.Models.DashboardPageData
import com.Models.MainRepository
import com.RequestResult
import com.velmurugan.mvvmretrofitrecyclerviewkotlin.*
import com.velmurugan.mvvmretrofitrecyclerviewkotlin.databinding.FragmentBlankBinding
import kotlinx.android.synthetic.main.fragment_blank.*

class MovieFragment : Fragment() {
    lateinit var binding: FragmentBlankBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_blank, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }


    companion object {
        fun newInstance() = MovieFragment()

    }

    private fun init(){
        initViewModel()
        initData()
        initViewModelObserver()
        initAdapter()
    }
    private val retrofitService = RetrofitService.getInstance()
    private lateinit var postListViewModel: MainViewModel
    private fun initViewModel(){
        postListViewModel = ViewModelProvider(this, MyViewModelFactory(MainRepository(retrofitService))).get(
            MainViewModel::class.java)
    }

    private fun initData(){
        postListViewModel.getAllMovies()
    }

    private fun initViewModelObserver(){
        postListViewModel.dashboardDataMLD.observe(viewLifecycleOwner) {
            if (it is RequestResult.Success)
                onGetPostListResponse(it.data as DashboardPageData)
        }
    }

    private lateinit var linearLayoutManager: LinearLayoutManager
    var mAdapter: MainAdapter? = null
    private fun initAdapter() {
        linearLayoutManager = LinearLayoutManager(activity , RecyclerView.VERTICAL , false)
        mAdapter = MainAdapter()
        movie_recycler.adapter = mAdapter
        movie_recycler.layoutManager = linearLayoutManager
    }

    private fun onGetPostListResponse(resultResponse : DashboardPageData){
        if (resultResponse != null) {
            adapterListSubmit(resultResponse)
        }
    }

    lateinit var data : List<*>
    private fun adapterListSubmit(resultResponse: DashboardPageData) {
        data = resultResponse.list!!
        mAdapter?.submitList(data)
    }
}