package com.ids.fao.controller.Activities


import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.ids.fao.R
import com.ids.fao.controller.Base.AppCompactBase
import com.ids.fao.controller.Fragments.FragementSignup
import com.ids.fao.controller.Fragments.FragmentForgetPassword
import com.ids.fao.controller.Fragments.FragmentLogin
import com.ids.fao.utils.AppConstants
import com.ids.fao.utils.AppHelper


class ActivityLogin : AppCompactBase() {
    private lateinit var fragmentManager: FragmentManager
    var fragmentAvailable= AppConstants.LOGIN
    var canClickLogin=true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        init()
        defaultFragment()
    }


    private fun init(){
        supportActionBar!!.hide()
        fragmentManager = supportFragmentManager
      //  LocaleUtils.updateConfig(this@ActivityLogin)


    }

    fun defaultFragment(){

        fragmentAvailable=AppConstants.LOGIN
        val login = FragmentLogin()
        fragmentManager.beginTransaction()
            .replace(com.ids.fao.R.id.container, login, AppConstants.LOGIN_FRAG)
            .commit()
    }

    fun getForgetPassword(){
       AppHelper.AddFragment(fragmentManager,AppConstants.FORGET_PASSWORD,FragmentForgetPassword(),AppConstants.FROGET_PASSWORD_FRAG)
    }




    override fun onBackPressed() {
        try{
            val fragment = fragmentManager.findFragmentByTag(AppConstants.LOGIN_FRAG) as FragmentLogin?
            fragment!!.canClick()
        }catch (E:Exception){

        }
        super.onBackPressed()
    }



}
