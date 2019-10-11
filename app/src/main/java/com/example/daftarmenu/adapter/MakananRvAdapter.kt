package com.example.daftarmenu.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.daftarmenu.R
import com.example.daftarmenu.R.layout
import com.example.daftarmenu.adapter.MakananRvAdapter.MenuViewHolder
import com.example.daftarmenu.data.MakananModel
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_menu.iv_mie
import kotlinx.android.synthetic.main.list_menu.tv_harga_mie
import kotlinx.android.synthetic.main.list_menu.tv_mie

class MakananRvAdapter(private val data:List<MakananModel>) :
    RecyclerView.Adapter<MakananRvAdapter.MenuViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        return MenuViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_menu, parent, false)
        )
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bindData(data[position])
    }

    class MenuViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView),
        LayoutContainer {
        fun bindData(item:MakananModel){
            tv_mie.text=item.namaMenu
            tv_harga_mie.text=item.hargaMenu
            Glide.with(containerView)
                .load(item.gambarMenu)
                .into(iv_mie)

            itemView.setOnClickListener{
                Toast.makeText(containerView.context, item.namaMenu, Toast.LENGTH_SHORT).show()
            }
            //tv_mie.setOnClickListener {

            //}
        }
    }
}