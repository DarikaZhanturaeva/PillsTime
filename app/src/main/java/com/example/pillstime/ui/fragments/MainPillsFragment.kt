package com.example.pillstime.ui.fragments

import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.pillstime.R
import com.example.pillstime.databinding.FragmentMainPillsBinding
import com.example.pillstime.ui.adapter.ViewPagerAdapter
import com.example.pillstime.ui.base.BaseFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class MainPillsFragment :
    BaseFragment<FragmentMainPillsBinding>(FragmentMainPillsBinding::inflate) {

        private lateinit var viewPager2: ViewPager2
        private lateinit var tabLayout: TabLayout

    override fun setupViews() {

        viewPager2 =requireView().findViewById(R.id.view_pager2)
        tabLayout = requireView().findViewById(R.id.tab_layout)

        initAdapter()
        initialize()
    }

    override fun initClickListeners() {
        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.addPillsFragment)
        }
    }

    private fun initAdapter() {
        val adapter = ViewPagerAdapter(this)
        binding.viewPager2.adapter = adapter
    }

    private fun initialize() = with(binding) {
        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            tab.text = when (position) {
                0 -> "\uD83D\uDFE2"
                1 -> "\uD83D\uDFE0"
                2 -> "\uD83D\uDD34"
                else -> null
            }
        }.attach()
    }

}