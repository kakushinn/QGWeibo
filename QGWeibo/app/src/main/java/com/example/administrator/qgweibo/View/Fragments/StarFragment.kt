package com.example.administrator.qgweibo.View.Fragments

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast
import com.example.administrator.qgweibo.Adapter.StarGridAdapter
import com.example.administrator.qgweibo.R
import com.example.administrator.qgweibo.View.Activities.StarDetailActivity
import com.example.administrator.qgweibo.View.Interfaces.StarFragment.IStarFragment
import kotlinx.android.synthetic.main.fragment_star.view.*

/**
 * Created by guochen on 2017/02/27.
 */
class StarFragment : Fragment(),IStarFragment {

    var gridview : GridView? = null
    var starGridAdapter : StarGridAdapter? = null
    var starNameList  = ArrayList<String>();
    var starDateSpanList = ArrayList<String>();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_star, null)
        initView(view)
        starGridAdapter = StarGridAdapter(activity)
        gridview!!.adapter = starGridAdapter
        starNameList = starGridAdapter!!.getStarNames()
        starDateSpanList = starGridAdapter!!.getStarDateSpan()
        return view
    }

    override fun initView(view: View) {
        gridview = view.gv_star as GridView
        gridview!!.setOnItemClickListener(object : AdapterView.OnItemClickListener{
            override fun onItemClick(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                var intent = Intent(activity, StarDetailActivity :: class.java)
                intent.putExtra("starName",starNameList[position])
                intent.putExtra("starDateSpan",starDateSpanList[position])
                activity.startActivity(intent)
            }
        })
    }
}
