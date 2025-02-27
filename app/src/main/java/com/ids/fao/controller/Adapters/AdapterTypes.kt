package com.ids.fao.controller.Adapters


import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ids.fao.R
import com.ids.fao.controller.Adapters.RVOnItemClickListener.RVOnItemClickListener
import com.ids.fao.utils.AppConstants


import java.util.*


class AdapterTypes(val itemSpinner: ArrayList<String>, private val itemClickListener: RVOnItemClickListener,from:Int) :
    RecyclerView.Adapter<AdapterTypes.VHprivacy>() {

    var type=from
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHprivacy {
        return VHprivacy(LayoutInflater.from(parent.context).inflate(com.ids.fao.R.layout.activity_login, parent, false))
    }

    override fun onBindViewHolder(holder: VHprivacy, position: Int) {

/*        try{holder.tvCategoryTitle.text=itemSpinner[position].valueEn}catch (e:Exception){}


        holder.itemView.setOnClickListener{
            itemSpinner[position].isSelected=!itemSpinner[position].isSelected!!
            notifyItemChanged(position)
        }

          holder.cvImage.visibility=View.GONE

        if(itemSpinner[position].isSelected!!){
            holder.ivVerified.visibility = View.VISIBLE
        }else{
            holder.ivVerified.visibility = View.INVISIBLE
        }*/

    }

    override fun getItemCount(): Int {
        return itemSpinner.size
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
            if(type==AppConstants.SPINNER_POST_PRIVACY)
                itemView.id= R.id.IdSpinnerTypes

            itemClickListener.onItemClicked(v, layoutPosition)
        }
    }
}
