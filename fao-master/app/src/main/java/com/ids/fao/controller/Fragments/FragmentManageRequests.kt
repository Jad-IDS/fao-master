package com.ids.fao.controller.Fragments


import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment

import android.view.*
import android.widget.AdapterView
import android.widget.Spinner
import androidx.recyclerview.widget.GridLayoutManager
import com.ids.fao.R
import com.ids.fao.controller.Adapters.AdapterGeneralSpinner
import com.ids.fao.controller.Adapters.AdapterManageOrders
import com.ids.fao.controller.Adapters.RVOnItemClickListener.RVOnItemClickListener
import com.ids.fao.model.ItemSpinner
import com.ids.fao.model.ManageOrders
import com.ids.fao.utils.AppConstants
import kotlinx.android.synthetic.main.fragment_manage_request.*
import kotlinx.android.synthetic.main.loading.*

import java.lang.Exception


class FragmentManageRequests : Fragment(),RVOnItemClickListener {
    override fun onItemClicked(view: View, position: Int) {

    }

    var canClick=true
    private var arrayOrderStatus= java.util.ArrayList<ItemSpinner>()
    private var arrayConfirmType= java.util.ArrayList<ItemSpinner>()

    lateinit var adapterOrderType: AdapterGeneralSpinner
    lateinit var adapterConfirmType: AdapterGeneralSpinner

    var selectedOrderStatusId=0
    var selectedConfirmStatusId=0

    var selectedOrderStatusName=""
    var selectedConfirmStatusName=""

    lateinit var adapterAllOrders: AdapterManageOrders
    var arrayOrders = java.util.ArrayList<ManageOrders>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(com.ids.fao.R.layout.fragment_manage_request, container, false)



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity!!.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE or WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
        setSpinner(spOrderTypes,arrayOrderStatus,AppConstants.SPINNER_ORDER_STATUS)
        setSpinner(spConfirmStatus,arrayConfirmType,AppConstants.SPINNER_CONFIRM_STATUS)
        loading.visibility=View.VISIBLE
        Handler().postDelayed({setOrders() }, 100)



    }

    override fun onResume() {
        super.onResume()

    }

    private fun setOrders() {
        arrayOrders.clear()
        arrayOrders.add(ManageOrders(1,"1/1/2020"))
        arrayOrders.add(ManageOrders(1,"1/1/2020"))
        adapterAllOrders = AdapterManageOrders(arrayOrders, this)
        val glm = GridLayoutManager(activity, 1)
        rvOrders!!.adapter = adapterAllOrders
        rvOrders!!.layoutManager = glm
        loading.visibility=View.GONE
    }


    private fun setSpinner(spinner: Spinner, arrayItems:ArrayList<ItemSpinner>, type:Int){
        if(type== AppConstants.SPINNER_ORDER_STATUS)
            setOrderStatusArray()
        else if(type==AppConstants.SPINNER_CONFIRM_STATUS)
            setConfirmStatusArray()

        val adapter = AdapterGeneralSpinner(activity!!, R.layout.spinner_text_item, arrayItems,AppConstants.LEFT_DARK_GRAY)
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        spinner.adapter = adapter;
        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long){
                try{
                    var item=adapter.getItem(position)
                    Log.wtf("selection_type",type.toString())

                    when (type) {

                        AppConstants.SPINNER_ORDER_STATUS -> {
                            selectedOrderStatusId=item!!.id!!
                            selectedConfirmStatusName=item.name!!
                        }
                        AppConstants.SPINNER_CONFIRM_STATUS -> {
                            selectedConfirmStatusId=item!!.id!!
                            selectedConfirmStatusName=item.name!!

                        }

                    }
                }catch (e: Exception){}}

            override fun onNothingSelected(parent: AdapterView<*>){
                // Another interface callback
            }
        }
        when (type) {
            AppConstants.SPINNER_ORDER_STATUS -> adapterOrderType=adapter
            AppConstants.SPINNER_CONFIRM_STATUS -> adapterConfirmType=adapter

        }
    }




    private fun setOrderStatusArray() {
        arrayOrderStatus.clear()
        arrayOrderStatus.add(ItemSpinner(1, getString(R.string.spinner_order_status_1)))
        arrayOrderStatus.add(ItemSpinner(2, getString(R.string.spinner_order_status_2)))
        arrayOrderStatus.add(ItemSpinner(3, getString(R.string.spinner_order_status_3)))

        if(arrayOrderStatus.size>0)
            selectedOrderStatusId=arrayOrderStatus[0].id!!

    }


    private fun setConfirmStatusArray() {
        arrayConfirmType.clear()
        arrayConfirmType.add(ItemSpinner(1, getString(R.string.spinner_status_confirm_1)))
        arrayConfirmType.add(ItemSpinner(2, getString(R.string.spinner_status_confirm_2)))

        if(arrayConfirmType.size>0)
            selectedOrderStatusId=arrayConfirmType[0].id!!

    }






}


