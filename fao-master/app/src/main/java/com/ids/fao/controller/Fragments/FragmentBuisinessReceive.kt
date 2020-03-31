package com.ids.fao.controller.Fragments


import android.os.Bundle
import androidx.fragment.app.Fragment

import android.view.*
import androidx.recyclerview.widget.GridLayoutManager

import com.ids.fao.controller.Adapters.AdapterNeededWorkList
import com.ids.fao.controller.Adapters.RVOnItemClickListener.RVOnItemClickListener
import com.ids.fao.model.ManageOrders
import com.ids.fao.model.WorkList
import kotlinx.android.synthetic.main.fragment_business_receive.*
import kotlinx.android.synthetic.main.fragment_manage_request.*


class FragmentBuisinessReceive : Fragment() ,RVOnItemClickListener{

    private var arrayNeededWork= java.util.ArrayList<WorkList>()
    lateinit var adapterWorkList: AdapterNeededWorkList

    override fun onItemClicked(view: View, position: Int) {

    }

    var canClick=true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(com.ids.fao.R.layout.fragment_business_receive, container, false)



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity!!.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE or WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
        setWorkList()


    }

    override fun onResume() {
        super.onResume()

    }




    private fun setWorkList() {
        arrayNeededWork.clear()
        arrayNeededWork.add(WorkList(1))

        adapterWorkList = AdapterNeededWorkList(arrayNeededWork, this)
        val glm = GridLayoutManager(activity, 1)
        rvNeededWorks!!.adapter = adapterWorkList
        rvNeededWorks!!.layoutManager = glm
    }






}


