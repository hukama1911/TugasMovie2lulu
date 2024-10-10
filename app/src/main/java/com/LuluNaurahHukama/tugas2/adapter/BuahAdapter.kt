package com.LuluNaurahHukama.tugas2.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.LuluNaurahHukama.tugas2.DetailBuah
import com.LuluNaurahHukama.tugas2.R
import com.LuluNaurahHukama.tugas2.RecyleBuahImageActivity
import com.LuluNaurahHukama.tugas2.model.ModelBuah

class BuahAdapter(
    val itemList:ArrayList<ModelBuah>,
    private val getActivity: RecyleBuahImageActivity
    )
         : RecyclerView.Adapter<BuahAdapter.MyViewHolder>(){

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var itemNama: TextView

        init {
            itemImage = itemView.findViewById(R.id.gambar) as ImageView
            itemNama = itemView.findViewById(R.id.nama) as  TextView
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val nView = LayoutInflater.from(parent.context).inflate(R.layout.item_custom_buah,
            parent, false)
        return MyViewHolder(nView)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemImage.setImageResource(itemList[position].image)
        holder.itemNama.setText(itemList[position].nama)

        holder.itemView.setOnClickListener(){
            val  intent = Intent(getActivity, DetailBuah::class.java)
            intent.putExtra("image",itemList[position].image)
            intent.putExtra("nama",itemList[position].nama)

            getActivity.startActivity(intent)
        }
    }
}
