package com.ids.fao.model

class FarmRS {


    var Id: Int? = null
    var blockNumber: String? = null
    var total_area: String? = null
    var own_percentage: String? = null
    var soil: String? = null
    var rock_type: String? = null
    var rock_perc: String? = null
    var gradient: String? = null
    var show_off: String? = null
    var land_class: String? = null
    var huby_irr: String? = null
    var height_sea: String? = null

    constructor(Id: Int?) {
        this.Id = Id
    }
}