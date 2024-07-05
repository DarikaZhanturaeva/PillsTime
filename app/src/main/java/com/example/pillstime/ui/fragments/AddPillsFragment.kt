package com.example.pillstime.ui.fragments

import android.app.DatePickerDialog
import android.icu.text.SimpleDateFormat
import androidx.navigation.fragment.findNavController
import com.example.pillstime.R
import com.example.pillstime.databinding.FragmentAddPillsBinding
import com.example.pillstime.ui.base.BaseFragment
import java.util.Calendar
import java.util.Locale

class AddPillsFragment : BaseFragment<FragmentAddPillsBinding>(FragmentAddPillsBinding::inflate) {

    private val calendar = Calendar.getInstance()

    override fun setupViews() {

    }

    override fun initClickListeners() {
        initClickBack()
        initClickTime()
        initClickSave()
        initClickChange()
        initClickPutOff()
    }
    private fun initClickBack() {
        binding.imgBack.setOnClickListener {
            findNavController().navigate(R.id.mainPillsFragment)
        }
    }
    private fun initClickTime() {
        binding.btnAddTime.setOnClickListener {
//                val datePickerDialog = DatePickerDialog(
//                    requireContext(),
//                    { DatePicker, year: Int, monthOfYear: Int, dayOfMonth: Int ->
//                        val selectedDay = Calendar.getInstance()
//                        selectedDay.set(year, monthOfYear, dayOfMonth)
//                        val dateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
//                        val formattedDate = dateFormat.format(selectedDay.time)
//
//                    },
//                    calendar.get(Calendar.YEAR),
//                    calendar.get(Calendar.MONTH),
//                    calendar.get(Calendar.DAY_OF_MONTH)
//                )
//                datePickerDialog.show()
//            }
        }
    }
    private fun initClickSave() {

    }
    private fun initClickChange() {

    }

    private fun initClickPutOff() {

    }
}