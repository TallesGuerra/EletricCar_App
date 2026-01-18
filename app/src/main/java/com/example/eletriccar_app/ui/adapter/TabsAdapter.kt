package com.example.eletriccar_app.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.eletriccar_app.ui.CarFragment
import com.example.eletriccar_app.ui.FavoriteFragment // Adicione esta linha quando criar o FavoriteFragment

class TabsAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun createFragment(position: Int): Fragment {
        // Retorna o fragmento correspondente à posição da aba
        return when (position) {
            0 -> CarFragment()
            1 -> FavoriteFragment()
            else -> CarFragment() // Um valor padrão seguro
        }
    }

    override fun getItemCount(): Int {
        // Retorna o número total de abas
        return 2
    }
}
