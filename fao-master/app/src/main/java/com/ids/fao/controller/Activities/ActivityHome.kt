package com.ids.fao.controller.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.ids.fao.R
import com.ids.fao.controller.Base.ActivityBase
import com.ids.fao.controller.Base.AppCompactBase
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.fragment.app.FragmentManager
import com.ids.fao.controller.Fragments.*
import com.ids.fao.controller.MyApplication
import com.ids.fao.utils.AppConstants
import com.ids.fao.utils.AppHelper
import com.ids.fao.utils.LocaleUtils
import java.util.*


class ActivityHome : AppCompactBase() {

    private lateinit var fragmentManager: FragmentManager
    var fragmentAvailable= AppConstants.LOGIN
    var canClickLogin=true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportActionBar!!.hide()



        //window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN or WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
         init()
         defaultFragment()
    }

    private fun init(){
        supportActionBar!!.hide()
        fragmentManager = supportFragmentManager

    }

    fun defaultFragment(){

        fragmentAvailable=AppConstants.HOME
        val fragment = FragmentManageRequests()
       // val fragment = FragmentRequestForm()
        //val fragment = FragmentSignature()
      // val fragment = FragmentWorkFlow()
       // val fragment = FragmentBuisinessReceive()
        // val fragment = FragmentCoordinates()
        fragmentManager.beginTransaction()
            .replace(com.ids.fao.R.id.container, fragment, AppConstants.HOME_FRAG)
            .commit()
    }
}
