package com.example.pillstime.ui.fragments.green_screen

import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.pillstime.databinding.FragmentPillsGreenBinding
import com.example.pillstime.ui.base.BaseFragment


class PillsGreenFragment : BaseFragment<FragmentPillsGreenBinding>(FragmentPillsGreenBinding::inflate) {

    private lateinit var pillsGreenAdapter: PillsGreenAdapter
    private val viewModel: PillsGreenViewModel by viewModel()

    override fun setupViews() {
        setupRecyclerView()
    }

    override fun setupObservers() {
        super.setupObservers()
        viewModel.getAllPills().observe(viewLifecycleOwner) {
            pillsGreenAdapter.submitList(it)
        }
    }

    private fun setupRecyclerView() {
        pillsGreenAdapter = PillsGreenAdapter()
        binding.rvPills.adapter = pillsGreenAdapter
    }

}