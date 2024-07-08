package com.example.pillstime.ui.fragments

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.icu.text.SimpleDateFormat
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.pillstime.R
import com.example.pillstime.data.local.entity.model.PillsModel
import com.example.pillstime.databinding.FragmentAddPillsBinding
import com.example.pillstime.receiver.setAlarm
import com.example.pillstime.ui.base.BaseFragment
import com.example.pillstime.ui.fragments.green_screen.PillsGreenViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.Calendar
import java.util.Locale

class AddPillsFragment : BaseFragment<FragmentAddPillsBinding>(FragmentAddPillsBinding::inflate) {

    private val pillsViewModel: PillsGreenViewModel by viewModel()
    private val calendar: Calendar? = null

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
            val currentTime = Calendar.getInstance()
            val hour = currentTime.get(Calendar.HOUR_OF_DAY)
            val minute = currentTime.get(Calendar.MINUTE)

            val timePickerDialog = TimePickerDialog(
                requireContext(),
                { _, selectedHour: Int, selectedMinute: Int ->
                    val selectedTime = Calendar.getInstance()
                    selectedTime.set(Calendar.HOUR_OF_DAY, selectedHour)
                    selectedTime.set(Calendar.MINUTE, selectedMinute)
                    val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
                    val formattedTime = timeFormat.format(selectedTime.time)
                    binding.btnAddTime.text = formattedTime
                },
                hour,
                minute,
                true
            )
            timePickerDialog.show()
        }
    }

    private fun initClickSave() {
        with(binding) {
            btnSave.setOnClickListener {
                etTitle.text?.toString()?.let { title ->
                    etDescription.text?.toString()?.let { description ->
                        btnAddTime.text?.toString()?.let { time ->
                            val pillsModel = PillsModel(
                                title = title,
                                description = description,
                                time = time,
                                id = 0
                            )
                            pillsViewModel.addPillToTop(pillsModel)
                            pillsViewModel.insert(pillsModel)
                            calendar?.let { cal ->
                                setAlarm(requireContext(), cal.timeInMillis)
                            }
                            findNavController().navigate(R.id.mainPillsFragment)
                        }
                    }
                }
            }
        }
    }
}

private fun initClickChange() {

}

private fun initClickPutOff() {

}