package com

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPager2AdapterWithFragmentManager(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    constructor(
        fragmentManager: FragmentManager,
        lifecycle: Lifecycle,
        fragments: List<Fragment>
    ) : this(fragmentManager, lifecycle) {
        mFragmentList.addAll(fragments)
    }

    val mFragmentList = mutableListOf<Fragment>()

    override fun createFragment(position: Int): Fragment {
        return mFragmentList[position]
    }

    override fun getItemCount(): Int {
        return mFragmentList.size
    }

    fun addFrag(fragment: Fragment) {
        mFragmentList.add(fragment)
    }

    fun getFragment(position: Int): Fragment {
        return mFragmentList[position]
    }

    fun removeFrag(fragment: Fragment) {
        mFragmentList.remove(fragment)
    }

    override fun getItemId(position: Int): Long {
        return try {
            if (fragmentIdList.size != mFragmentList.size) {
                recreateFragmentIdList()
            }
            fragmentIdList[position]
        } catch (e: Exception) {
            e.printStackTrace()
            position.toLong()
        }
    }

    private fun recreateFragmentIdList() {
        fragmentIdList = mFragmentList.map { it.hashCode().toLong() }
    }

    private var fragmentIdList = mFragmentList.map { it.hashCode().toLong() }

    override fun containsItem(itemId: Long): Boolean {
        return fragmentIdList.contains(itemId)
    }
}
