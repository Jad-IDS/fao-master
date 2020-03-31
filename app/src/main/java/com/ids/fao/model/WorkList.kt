package com.ids.fao.model


class WorkList {


    var Id: Int? = null

    var blockNbr: Int? = null
    var workType: String? = null
    var unitExecNbr: Int? = null
    var unitPrice: String? = null
    var totalValue: String? = null




    constructor(Id: Int?) {
        this.Id = Id
    }
}