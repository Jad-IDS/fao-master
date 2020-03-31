package com.ids.fao.controller

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import android.os.Build
import android.preference.PreferenceManager
import com.ids.fao.utils.AppConstants
import java.util.*

class MyApplication : Application() {

    companion object {

        @JvmField
        var isSignatureEmpty: Boolean = true
        var UNIQUE_REQUEST_CODE: Int=0
        lateinit var sharedPreferences : SharedPreferences
        lateinit var sharedPreferencesEditor : SharedPreferences.Editor


        internal lateinit var instance: MyApplication
        var isLoggedIn : Boolean
            get() = sharedPreferences.getBoolean(AppConstants.IS_LOGGED_IN, false)
            set(value) { sharedPreferencesEditor.putBoolean(AppConstants.IS_LOGGED_IN, value).apply() }

        var cashedUserName : String
            get() = sharedPreferences.getString(AppConstants.CASHED_USERNAME, "")
            set(value) { sharedPreferencesEditor.putString(AppConstants.CASHED_USERNAME, value).apply() }

        var cashedPassword : String
            get() = sharedPreferences.getString(AppConstants.CASHED_PASSWORD, "")
            set(value) { sharedPreferencesEditor.putString(AppConstants.CASHED_PASSWORD, value).apply() }

        var languageCode : String
            get() = sharedPreferences.getString(AppConstants.SELECTED_LANGUAGE, AppConstants.LANG_ENGLISH)
            set(value) { sharedPreferencesEditor.putString(AppConstants.SELECTED_LANGUAGE, value).apply() }

        var showNotifications : Boolean
            get() = sharedPreferences.getBoolean("key_show_notifications", true)
            set(value){
                sharedPreferencesEditor.putBoolean(
                    "key_show_notifications",
                    value
                ).apply()
            }

        //<editor-fold desc="Shared Prefs">

        //</editor-fold>
    }


    override fun onCreate() {
        super.onCreate()

        //<editor-fold desc="Shared Prefs">
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        sharedPreferencesEditor = sharedPreferences.edit()
        instance=this
        //</editor-fold>
/*        AppHelper.changeLanguage(this, languageCode)
        Log.wtf("language_code", languageCode)
        BaseActivityLang.dLocale = Locale(languageCode) //set any locale you want here*/
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

    }

    override fun attachBaseContext(newBase: Context) {
        var newBase = newBase
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val config = newBase.resources.configuration
            config.setLocale(Locale.getDefault())
            newBase = newBase.createConfigurationContext(config)
        }
        super.attachBaseContext(newBase)
    }



}
