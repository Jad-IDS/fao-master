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
import com.ids.fao.model.response.*
import com.ids.fao.utils.*
import kotlinx.android.synthetic.main.fragment_login.*


import retrofit2.*


class FragmentLogin : Fragment() , RVOnItemClickListener {

     private var canClick=true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
     }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(com.ids.fao.R.layout.fragment_login, container, false)



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         init()


    }

    override fun onResume() {
        canClick=true
        super.onResume()

    }



    private fun init(){
        btLogin.setOnClickListener{
            login()
        }
        btForgetPassword.setOnClickListener{
            if (canClick) {
                canClick=false
                try {(activity!! as ActivityLogin).getForgetPassword()} catch (e: Exception) {}
            }
        }
    }



    private fun login(){
        if(etUsername.text.toString().isEmpty())
            AppHelper.createDialog(this.activity!!,getString(R.string.enter_username))
        else if(etPassword.text.toString().isEmpty())
            AppHelper.createDialog(this.activity!!,getString(R.string.enter_password))
        else if(!AppHelper.isValidEmail(etUsername.text.toString()))
            AppHelper.createDialog(this.activity!!,getString(R.string.enter_valid_email))
        else
            checkLogin()
    }


    private fun checkLogin(){
        startActivity(Intent(activity, ActivityHome::class.java))
        activity!!.finish()
    }

/*
    private fun checkLogin(){
                 loading.visibility=View.VISIBLE
                   RetrofitClient.client?.create(RetrofitInterface::class.java)
                    ?.validateUser(
                        etUsrname.text.toString(),
                        etPassword.text.toString(),
                        MyApplication.languageCode
                    )?.enqueue(object : Callback<ResponseUserInfos> {
                        override fun onResponse(call: Call<ResponseUserInfos>, response: Response<ResponseUserInfos>) {
                            try{
                                loading.visibility=View.GONE
                              onValidateRetrieved(response)

                            }catch (E:Exception){
                                AppHelper.createDialog(activity!!,response.errorBody()!!.string().replace("\"", ""))
                             }
                          }
                          override fun onFailure(call: Call<ResponseUserInfos>, throwable: Throwable) {

                              AppHelper.createDialog(activity!!,throwable.message.toString())

                                  //checkLoginMessage()
                        }
                    })



    }

*/




    fun canClick(){
        canClick=true
    }


    override fun onItemClicked(view: View, position: Int) {


    }



/*    private fun getUserTeams(){
        RetrofitClientAuth.client?.create(RetrofitInterface::class.java)
            ?.getUserTeams(
            )?.enqueue(object : Callback<java.util.ArrayList<ResponseUserTeam>> {
                override fun onResponse(call: Call<java.util.ArrayList<ResponseUserTeam>>, response: Response<java.util.ArrayList<ResponseUserTeam>>) {
                    try{
                        MyApplication.arrayUserTeams.clear()
                        MyApplication.arrayUserTeams=response.body()!!
                    }catch (E: java.lang.Exception){
                    }
                }
                override fun onFailure(call: Call<java.util.ArrayList<ResponseUserTeam>>, throwable: Throwable) {
                    // Toast.makeText(activity,"",Toast.LENGTH_LONG).show()
                }
            })

    }*/

}


