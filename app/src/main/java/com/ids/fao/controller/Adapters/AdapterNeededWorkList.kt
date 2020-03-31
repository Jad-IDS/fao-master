package com.ids.fao.controller.Adapters



import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ids.fao.R
import com.ids.fao.controller.Adapters.RVOnItemClickListener.RVOnItemClickListener

import com.ids.fao.model.WorkList
import com.ids.fao.utils.AppConstants


import java.util.*


class AdapterNeededWorkList(val items: ArrayList<WorkList>, private val itemClickListener: RVOnItemClickListener) :
    RecyclerView.Adapter<AdapterNeededWorkList.VHprivacy>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHprivacy {
        return VHprivacy(LayoutInflater.from(parent.context).inflate(com.ids.fao.R.layout.item_work_list_needed, parent, false))
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

    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class VHprivacy(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
/*        var ivCategoryImage: ImageView = itemView.findViewById(com.ids.fao.R.id.ivCategoryImage) as ImageView
        var cvImage: CardView = itemView.findViewById(com.ids.fao.R.id.cvImage) as CardView
        var ivVerified: ImageView = itemView.findViewById(com.ids.fao.R.id.ivVerified) as ImageView
        var tvCategoryTitle: TextView = itemView.findViewById(com.ids.fao.R.id.tvCategoryTitle) as TextView*/


        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View) {


            itemClickListener.onItemClicked(v, layoutPosition)
        }
    }
}
