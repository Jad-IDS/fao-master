package com.ids.fao.controller.Adapters



import android.content.Context
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Spinner
import com.ids.fao.R
import com.ids.fao.controller.Adapters.RVOnItemClickListener.RVOnItemClickListener
import com.ids.fao.model.FarmRS
import com.ids.fao.model.ItemSpinner
import com.ids.fao.model.ManageOrders
import com.ids.fao.utils.AppConstants
import java.lang.Exception


import java.util.*


class AdapterStatusFarmRS(val items: ArrayList<FarmRS>, private val itemClickListener: RVOnItemClickListener) :
    RecyclerView.Adapter<AdapterStatusFarmRS.VHprivacy>() {

     var arrayRockType= java.util.ArrayList<ItemSpinner>()
     var arrayHubbyIrr= java.util.ArrayList<ItemSpinner>()

    lateinit var adapterRockType: AdapterGeneralSpinner
    lateinit var adapterHubbyIrr: AdapterGeneralSpinner

    var selectedRockType=0
    var selectedHubbyIrr=0

    var selectedRockTypeName=""
    var selectedHubbyIrrName=""

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHprivacy {
        return VHprivacy(LayoutInflater.from(parent.context).inflate(com.ids.fao.R.layout.item_status_real_sate, parent, false))
    }

    override fun onBindViewHolder(holder: VHprivacy, position: Int) {

/*        try{holder.tvCategoryTitle.text=items[position].valueEn}catch (e:Exception){}


        holder.itemView.setOnClickListener{
            items[position].isSelected=!items[position].isSelected!!
            notifyItemChanged(position)
        }

          holder.cvImage.visibility=View.GONE

        if(items[position].isSelected!!){
            holder.ivVerified.visibility = View.VISIBLE
        }else{
            holder.ivVerified.visibility = View.INVISIBLE
        }*/

        setSpinner(holder.itemView.context,holder.spRockType,arrayRockType,AppConstants.SPINNER_ROCK_TYPE)
        setSpinner(holder.itemView.context,holder.spHubbyIrr,arrayHubbyIrr,AppConstants.SPINNER_HURRY_IRR)

    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class VHprivacy(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
/*        var ivCategoryImage: ImageView = itemView.findViewById(com.ids.fao.R.id.ivCategoryImage) as ImageView
        var cvImage: CardView = itemView.findViewById(com.ids.fao.R.id.cvImage) as CardView
        var ivVerified: ImageView = itemView.findViewById(com.ids.fao.R.id.ivVerified) as ImageView
        var tvCategoryTitle: TextView = itemView.findViewById(com.ids.fao.R.id.tvCategoryTitle) as TextView*/
        var spHubbyIrr: Spinner = itemView.findViewById(com.ids.fao.R.id.spHubbyIrr) as Spinner
        var spRockType: Spinner = itemView.findViewById(com.ids.fao.R.id.spRockType) as Spinner

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View) {


            itemClickListener.onItemClicked(v, layoutPosition)
        }
    }


    private fun setSpinner(context: Context,spinner: Spinner, arrayItems:ArrayList<ItemSpinner>, type:Int){
        if(type== AppConstants.SPINNER_ROCK_TYPE)
            setRockTypeArray()
        else if(type==AppConstants.SPINNER_HURRY_IRR)
            setHubbyIrrArray()

        val adapter = AdapterGeneralSpinner(context!!, R.layout.spinner_text_item, arrayItems,AppConstants.LEFT_DARK_GRAY)
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        spinner.adapter = adapter;
        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long){
                try{
                    var item=adapter.getItem(position)
                    Log.wtf("selection_type",type.toString())

                    when (type) {

                        AppConstants.SPINNER_ROCK_TYPE -> {
                            selectedRockType=item!!.id!!
                            selectedRockTypeName=item.name!!
                        }
                        AppConstants.SPINNER_HURRY_IRR -> {
                            selectedHubbyIrr=item!!.id!!
                            selectedHubbyIrrName=item.name!!

                        }

                    }
                }catch (e: Exception){}}

            override fun onNothingSelected(parent: AdapterView<*>){
                // Another interface callback
            }
        }
        when (type) {
            AppConstants.SPINNER_ROCK_TYPE -> adapterRockType=adapter
            AppConstants.SPINNER_HURRY_IRR -> adapterHubbyIrr=adapter

        }
    }


    private fun setRockTypeArray() {
        arrayRockType.clear()
        arrayRockType.add(ItemSpinner(1, "1"))
        arrayRockType.add(ItemSpinner(2, "2"))


        if(arrayRockType.size>0)
            selectedRockType=arrayRockType[0].id!!

    }


    private fun setHubbyIrrArray() {
        arrayHubbyIrr.clear()
        arrayHubbyIrr.add(ItemSpinner(1, "1"))
        arrayHubbyIrr.add(ItemSpinner(2, "2"))


        if(arrayHubbyIrr.size>0)
            selectedHubbyIrr=arrayHubbyIrr[0].id!!

    }
}
