package com.example.eletriccar_app.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.eletriccar_app.R
import com.example.eletriccar_app.ui.adapter.TabsAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Lifecycle", "Create")
        setContentView(R.layout.activity_main)

        setupView()
        setupTabs()
    }

    private fun setupView() {
        tabLayout = findViewById(R.id.tab_layout)
        viewPager = findViewById(R.id.vp_view_pager)
    }

    private fun setupTabs() {

        val tabsAdapter = TabsAdapter(this)
        viewPager.adapter = tabsAdapter


        TabLayoutMediator(tabLayout, viewPager) { tab, position ->

            when (position) {
                0 -> tab.text = "Carros"
                1 -> tab.text = "Favoritos"
            }
        }.attach()
    }
}
