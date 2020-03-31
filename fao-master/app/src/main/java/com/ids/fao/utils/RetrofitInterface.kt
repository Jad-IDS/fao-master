package com.ids.fao.utils

import com.ids.fao.model.*
import com.ids.fao.model.response.*
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface RetrofitInterface {

/*    @GET("/video/{video_id}/config")
    fun getVideoInfo(
        @Path(value="video_id",encoded = true) video_id: String): Call<ResponseVimeo>


    @GET("Api/Login/ValidateUser")
    fun validateUser(
        @Query(ApiParameters.EMAIL) email: String,
        @Query(ApiParameters.PASSWORD) password: String,
        @Query(ApiParameters.LANG) lang: String

    ): Call<ResponseUserInfos>




    @Multipart
    @POST("Api/UploadFile/PostProfileImage")
    fun uploadProfileImage(
        @Part(ApiParameters.PAGE_USER_ID) id: RequestBody,
        @Part file: MultipartBody.Part
    ): Call<String>



    @POST("Api/UserNotification/SetNotificationSeen")
    fun setSeenNotification( @Query(ApiParameters.ID) id: Int): Call<ResponseNotification>



    @POST("Api/TeamMessage/Save")
    fun sendTeamChat(
        @Body param:ResponseChat
    ):  Call<ResponseChat>*/


}
