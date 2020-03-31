package com.ids.fao.controller.Activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import com.crashlytics.android.Crashlytics
import com.google.firebase.iid.FirebaseInstanceId
import com.ids.fao.R
import com.ids.fao.controller.Base.ActivityBase
import com.ids.fao.controller.MyApplication
import com.ids.fao.model.response.*
import com.ids.fao.utils.*

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class ActivitySplash : ActivityBase() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        MyApplication.languageCode = AppConstants.LANG_ARABIC
        LocaleUtils.setLocale(Locale("ar"))
        LocaleUtils.updateConfig(application, baseContext.resources.configuration)
        AppHelper.setLocal(this)


        Log.wtf("cashing_isloggedin","---"+MyApplication.isLoggedIn.toString())
        Log.wtf("cashing_username","---"+MyApplication.cashedUserName)
        Log.wtf("cashing_password","---"+MyApplication.cashedPassword)

        FirebaseInstanceId.getInstance().instanceId.addOnSuccessListener { instanceIdResult ->
            val token = instanceIdResult.token
            Log.wtf("token","token is " + token)

        }

        Handler().postDelayed({

              goToLogin()


        }, 1000)

    }





    private fun goToLogin(){
        startActivity(Intent(this, ActivityLogin::class.java))
       // startActivity(Intent(this, ActivityHome::class.java))
        finish()
    }

}
