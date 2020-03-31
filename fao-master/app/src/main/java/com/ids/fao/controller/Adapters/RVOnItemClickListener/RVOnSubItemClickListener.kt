package com.ids.fao.controller.Adapters.RVOnItemClickListener

import android.view.View

interface RVOnSubItemClickListener {
    fun onSubItemClicked(view: View, position: Int,parentPosition:Int)
}
