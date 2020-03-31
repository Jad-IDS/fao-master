package com.ids.fao.controller.Fragments


import android.os.Bundle
import androidx.fragment.app.Fragment

import android.view.*
import androidx.recyclerview.widget.GridLayoutManager
import com.ids.fao.controller.Adapters.AdapterManageOrders
import com.ids.fao.controller.Adapters.AdapterStatusFarmRS
import com.ids.fao.controller.Adapters.RVOnItemClickListener.RVOnItemClickListener
import com.ids.fao.model.FarmRS
import com.ids.fao.model.ManageOrders
import kotlinx.android.synthetic.main.fragment_manage_request.*
import kotlinx.android.synthetic.main.fragment_technical_form.*
import kotlinx.android.synthetic.main.loading.*


class FragmentRequestForm : Fragment() ,RVOnItemClickListener{
    override fun onItemClicked(view: View, position: Int) {

    }

    var canClick=true
    private var arrayFarmerRS= java.util.ArrayList<FarmRS>()
    lateinit var adapterFarmerRs: AdapterStatusFarmRS




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(com.ids.fao.R.layout.fragment_technical_form, container, false)



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         activity!!.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE or WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)


        setFarmerRs()

    }

    override fun onResume() {
        super.onResume()

    }










    private fun setFarmerRs() {
        arrayFarmerRS.clear()
        arrayFarmerRS.add(FarmRS(1))

        adapterFarmerRs = AdapterStatusFarmRS(arrayFarmerRS, this)
        val glm = GridLayoutManager(activity, 1)
        rvStatusFarmRS!!.adapter = adapterFarmerRs
        rvStatusFarmRS!!.layoutManager = glm
    }








}


