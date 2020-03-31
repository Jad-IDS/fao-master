package com.ids.fao.controller.Fragments


import android.os.Bundle
import androidx.fragment.app.Fragment

import android.view.*
import androidx.recyclerview.widget.GridLayoutManager

import com.ids.fao.controller.Adapters.RVOnItemClickListener.RVOnItemClickListener
import com.ids.fao.model.ManageOrders
import kotlinx.android.synthetic.main.fragment_manage_request.*


class FragmentWorkFlow : Fragment() ,RVOnItemClickListener{
    override fun onItemClicked(view: View, position: Int) {

    }

    var canClick=true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(com.ids.fao.R.layout.fragment_work_flow, container, false)



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity!!.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE or WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)



    }

    override fun onResume() {
        super.onResume()

    }


















}


