package com.ids.fao.model



import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ManageOrders {


    var Id: Int? = null
    var date: String? = null

    constructor(Id: Int?, date: String?) {
        this.Id = Id
        this.date = date
    }
}