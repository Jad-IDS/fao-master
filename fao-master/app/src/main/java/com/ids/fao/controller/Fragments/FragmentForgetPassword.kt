package com.ids.fao.controller.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.text.InputType
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.ids.fao.R
import com.ids.fao.controller.Activities.ActivityHome
import com.ids.fao.controller.Activities.ActivityLogin
import com.ids.fao.controller.Adapters.RVOnItemClickListener.RVOnItemClickListener
import com.ids.fao.controller.MyApplication
import com.ids.fao.utils.AppHelper
import kotlinx.android.synthetic.main.fragment_forget_password.*
import kotlinx.android.synthetic.main.fragment_forget_password.etUsername
import kotlinx.android.synthetic.main.fragment_login.*


class FragmentForgetPassword : Fragment() , RVOnItemClickListener {

    private var canClick=true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(com.ids.fao.R.layout.fragment_forget_password, container, false)



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()



    }

    override fun onResume() {
        super.onResume()
        canClick=true
    }



    private fun init(){
      btBack.setOnClickListener{
          activity!!.onBackPressed()
      }

        btSend.setOnClickListener{sendForgetPassword()}
    }



    private fun callSend(){
        Toast.makeText(activity,"sending...",Toast.LENGTH_LONG).show()
        activity!!.onBackPressed()
    }


    private fun sendForgetPassword(){
        if(etUsername.text.toString().isEmpty())
            AppHelper.createDialog(this.activity!!,getString(R.string.enter_username))
        else if(!AppHelper.isValidEmail(etUsername.text.toString()))
            AppHelper.createDialog(this.activity!!,getString(R.string.enter_valid_email))
        else
            callSend()
    }



    fun canClick(){
        canClick=true
    }


    override fun onItemClicked(view: View, position: Int) {


    }



}


