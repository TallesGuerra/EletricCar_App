package com.example.eletriccar_app.ui.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.eletriccar_app.ui.CarFragment

class TabsAdapter(fragment: FragmentActivity ) : FragmentStateAdapter(FragmentActivity) {
    constructor(fragment: Fragment): super(fragment)
    override fun createFragment(position: Int): Fragment {
       when(position)
        0 -> CarFragment()
        1 -> FavoriteFragment()
        else -> CarFragment()
    }

    override fun getItemCount(): Int {
        return 2
    }
}
