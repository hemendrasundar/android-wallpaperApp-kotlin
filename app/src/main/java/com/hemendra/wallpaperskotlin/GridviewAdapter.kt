package com.hemendra.wallpaperskotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.grid_item.view.*

class GridviewAdapter(var context:Context,var img:Array<Int>) :BaseAdapter() {

    override fun getView(position: Int, p1: View?, p2: ViewGroup?): View
    {
        var inflater = LayoutInflater.from(context)

        var v:View = inflater.inflate(R.layout.grid_item,null)

        v.grid_item_iv.setImageResource(img[position])

        return v
    }

    override fun getItem(p0: Int): Any {
        return 0
    }

    override fun getItemId(p0: Int): Long {
        return  0
    }

    override fun getCount(): Int {
        return img.size
    }
}