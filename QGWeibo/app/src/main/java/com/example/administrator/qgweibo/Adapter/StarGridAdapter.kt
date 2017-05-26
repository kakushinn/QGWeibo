package com.example.administrator.qgweibo.Adapter

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.administrator.qgweibo.R
import com.squareup.picasso.Picasso

/**
 * Created by Administrator on 2017/5/24.
 */
class StarGridAdapter(private val mContext : Context) : BaseAdapter() {
    private val layoutInflate : LayoutInflater
    private var starIconList = ArrayList<Int>()
    private var starNameList = ArrayList<String>()
    private var starTimeSpanList = ArrayList<String>()

    init {
        layoutInflate = LayoutInflater.from(mContext)
        initStarIconList()
        initStarNameList()
        initStarTimeSpanList()
    }

    fun initStarNameList(){
        starNameList.add("白羊座")
        starNameList.add("金牛座")
        starNameList.add("双子座")
        starNameList.add("巨蟹座")
        starNameList.add("狮子座")
        starNameList.add("处女座")
        starNameList.add("天秤座")
        starNameList.add("天蝎座")
        starNameList.add("射手座")
        starNameList.add("魔羯座")
        starNameList.add("水瓶座")
        starNameList.add("双鱼座")
    }

    fun initStarTimeSpanList(){
        starTimeSpanList.add("3.21-4.19")
        starTimeSpanList.add("4.20-5.20")
        starTimeSpanList.add("5.21-6.21")
        starTimeSpanList.add("6.22-7.22")
        starTimeSpanList.add("7.23-8.22")
        starTimeSpanList.add("8.23-9.22")
        starTimeSpanList.add("9.23-10.23")
        starTimeSpanList.add("10.24-11.22")
        starTimeSpanList.add("11.23-12.12")
        starTimeSpanList.add("12.22-1.19")
        starTimeSpanList.add("1.20-2.18")
        starTimeSpanList.add("2.19-3.20")
    }

    fun initStarIconList(){
        starIconList.add(R.mipmap.icon_sx_21)
        starIconList.add(R.mipmap.icon_sx_22)
        starIconList.add(R.mipmap.icon_sx_23)
        starIconList.add(R.mipmap.icon_sx_24)
        starIconList.add(R.mipmap.icon_sx_25)
        starIconList.add(R.mipmap.icon_sx_26)
        starIconList.add(R.mipmap.icon_sx_27)
        starIconList.add(R.mipmap.icon_sx_28)
        starIconList.add(R.mipmap.icon_sx_29)
        starIconList.add(R.mipmap.icon_sx_30)
        starIconList.add(R.mipmap.icon_sx_31)
        starIconList.add(R.mipmap.icon_sx_32)
    }

    fun getStarNames() :  ArrayList<String>{
        return starNameList;
    }

    fun getStarDateSpan() : ArrayList<String> {
        return starTimeSpanList
    }

    override fun getCount(): Int {
        return starIconList.size
    }

    override fun getItem(position: Int): Any {
        return starIconList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
//        var view = convertView
        var convertView = convertView
        var viewHolder : ViewHolder
        if(convertView == null){
            viewHolder = ViewHolder()
            convertView = layoutInflate.inflate(R.layout.view_star, null)
            viewHolder.starIconView = convertView?.findViewById(R.id.star_icon) as ImageView
            viewHolder.starNameView = convertView?.findViewById(R.id.star_name) as TextView
            viewHolder.starTimeSpanView = convertView?.findViewById(R.id.star_timespan) as TextView
            convertView.tag = viewHolder
        }else{
            viewHolder = convertView.tag as ViewHolder
        }
        Picasso.with(mContext).load(starIconList[position]).placeholder(R.mipmap.loading).error(R.mipmap.load_error).into(viewHolder.starIconView)
        viewHolder.starNameView?.setText(starNameList[position])
        viewHolder.starTimeSpanView?.setText(starTimeSpanList[position])
        return convertView
    }

    internal class ViewHolder{
        var starNameView : TextView? =null
        var starTimeSpanView : TextView? =null
        var starIconView : ImageView? =null
    }

}