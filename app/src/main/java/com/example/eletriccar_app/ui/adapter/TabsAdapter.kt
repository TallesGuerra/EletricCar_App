package com.example.eletriccar_app.ui.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabsAdapter : FragmentStateAdapter {
    constructor(fragment: Fragment): super(fragment)

    override fun createFragment(position: Int): Fragment {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}