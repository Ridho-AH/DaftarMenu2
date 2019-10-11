package com.example.daftarmenu.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.daftarmenu.R
import com.example.daftarmenu.R.layout
import com.example.daftarmenu.adapter.MakananRvAdapter
import com.example.daftarmenu.data.MakananModel
import com.example.daftarmenu.data.MenuDB
import kotlinx.android.synthetic.main.fragment_makanan.rv_makanan

class FragmentMakanan : Fragment() {
    companion object {
        fun getInstance(): FragmentMakanan {
            return FragmentMakanan()
        }
    }

    val dataMakanan= mutableListOf<MakananModel>()
    var mMakananRvAdapter= MakananRvAdapter(dataMakanan)
    var db:MenuDB?=null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_makanan,
            container, false

        )

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_makanan.adapter=mMakananRvAdapter
        rv_makanan.layoutManager= LinearLayoutManager(context)
        db= MenuDB.getInstance(context!!)
        getMenuMakanan()


    }

    private fun getMenuMakanan(){
        db?.menuDao()?.ambilMenuMakanan()
            ?.observe(this, Observer { hasil->
                when(hasil.size==0){
                    true->{
                        Toast.makeText(context,
                            "Data Makanan Masih Kosong",
                            Toast.LENGTH_SHORT).show()

                    }
                    false->{
                        dataMakanan.clear()
                        dataMakanan.addAll(hasil)
                        mMakananRvAdapter.notifyDataSetChanged()
                    }
                }
            })
    }



}