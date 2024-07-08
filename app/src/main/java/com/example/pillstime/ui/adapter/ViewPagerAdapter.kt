package com.example.pillstime.ui.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.pillstime.ui.fragments.green_screen.PillsGreenFragment
import com.example.pillstime.ui.fragments.PillsOrangeFragment
import com.example.pillstime.ui.fragments.PillsRedFragment

class ViewPagerAdapter(fragment: Fragment):FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> PillsGreenFragment()
            1 -> PillsOrangeFragment()
            2 -> PillsRedFragment()
            else -> PillsGreenFragment()
        }
    }
}