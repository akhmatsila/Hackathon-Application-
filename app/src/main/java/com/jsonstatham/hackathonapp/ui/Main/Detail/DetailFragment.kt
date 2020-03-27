package com.jsonstatham.hackathonapp.ui.Main.Detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.core.view.GravityCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.jsonstatham.hackathonapp.Api.Models.Main.ZoneAnalyzis
import com.jsonstatham.hackathonapp.Models.ProcessionData
import com.jsonstatham.hackathonapp.R
import dagger.android.support.DaggerFragment
import org.w3c.dom.Text
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class DetailFragment : DaggerFragment() {

    @Inject
    lateinit var data: LiveData<ProcessionData<ZoneAnalyzis>>

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private lateinit var district: TextView
    private lateinit var femaleCount: TextView
    private lateinit var femaleAge: TextView
    private lateinit var maleCount: TextView
    private lateinit var maleAge: TextView
    private lateinit var rentCost: TextView
    private lateinit var concurrent: TextView
    private lateinit var chance: TextView
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()
        district = view.findViewById(R.id.district)
        femaleCount = view.findViewById(R.id.female_count)
        femaleAge = view.findViewById(R.id.female_age)
        maleCount = view.findViewById(R.id.male_count)
        maleAge = view.findViewById(R.id.male_age)
        rentCost = view.findViewById(R.id.rent_val)
        concurrent = view.findViewById(R.id.concr)
        chance = view.findViewById(R.id.success)

        requireActivity().onBackPressedDispatcher.addCallback(
            this,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    navController.popBackStack()
                }

            })

        initFields()

    }

    private fun initFields() {
        district.text = district.text.toString() + (data.value?.data?.dis_name ?: "no data")
        femaleCount.text =
            femaleCount.text.toString() + (data.value?.data?.female_count ?: "no data")
        femaleAge.text = femaleAge.text.toString() + (data.value?.data?.female_age ?: "no data")
        maleAge.text = maleAge.text.toString() + (data.value?.data?.male_age ?: "no data")
        maleCount.text = maleCount.text.toString() + (data.value?.data?.male_count ?: "no data")
        rentCost.text = rentCost.text.toString() + (data.value?.data?.rent_val ?: "no data")
        concurrent.text = concurrent.text.toString() + (data.value?.data?.item_count ?: "no data")
        chance.text = chance.text.toString() + (data.value?.data?.koeff ?: "no data")
    }


}
