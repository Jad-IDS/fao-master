package com.ids.fao.controller.Fragments


import android.app.Activity
import android.app.AlertDialog
import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.text.InputType
import android.view.*
import android.widget.Toast
import com.ids.fao.controller.Activities.ActivityLogin
import com.ids.fao.controller.Adapters.RVOnItemClickListener.RVOnItemClickListener

import kotlinx.android.synthetic.main.fragment_signup.*



import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import com.ids.fao.R
import com.ids.fao.controller.MyApplication
import com.ids.fao.utils.*
import com.ids.fao.utils.AppHelper.Companion.hideKeyboard
import kotlinx.android.synthetic.main.fragment_login.*

import kotlinx.android.synthetic.main.loading_trans.*
import java.lang.Exception


class FragementSignup : Fragment() , RVOnItemClickListener {

    private lateinit var birthDateListener: DatePickerDialog.OnDateSetListener
    private lateinit var myBithDayCalendar: Calendar
    private var selectedDate = ""
    private var isPerson=true
    private var canClick= true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(com.ids.fao.R.layout.fragment_signup, container, false)



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }



    override fun onResume() {
        canClick=true
        super.onResume()
    }

/*    private fun signup(){
        if(etName.text.toString().isEmpty() || etalender.text.toString().isEmpty() || etEmail.text.toString().isEmpty() || etPassword.text.toString().isEmpty() )
             Toast.makeText(activity,getString(R.string.check_empty_fields),Toast.LENGTH_LONG).show()
        else if(!AppHelper.isValidEmail(etEmail.text.toString()))
             Toast.makeText(activity,getString(R.string.enter_valid_email),Toast.LENGTH_LONG).show()
        else
            register()
            //(activity!! as ActivityLogin).removeFrag(AppConstants.SIGNUP_FRAG)
    }*/





    override fun onItemClicked(view: View, position: Int) {


    }



  /*  private fun register(){
        loading.visibility=View.VISIBLE
        RetrofitClient.client?.create(RetrofitInterface::class.java)
            ?.registration(
                etName.text.toString(),
                etEmail.text.toString(),
                etPassword.text.toString(),
                etalender.text.toString(),
                (if (isPerson) 1 else 2),
                MyApplication.languageCode

            )?.enqueue(object : Callback<String> {
                override fun onResponse(call: Call<String>, response: Response<String>) {

                    loading.visibility=View.GONE
                    try{createDialog(activity!!,response.body().toString())}catch (e:Exception){}

                }
                override fun onFailure(call: Call<String>, throwable: Throwable) {
                    Toast.makeText(activity,"failed", Toast.LENGTH_LONG).show()
                }
            })
    }

*/


}


