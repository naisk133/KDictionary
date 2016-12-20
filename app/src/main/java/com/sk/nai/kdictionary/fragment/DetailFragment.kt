package com.sk.nai.kdictionary.fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.sk.nai.kdictionary.R
import com.sk.nai.kdictionary.activity.adapter.MyRecyclerAdapter
import com.sk.nai.kdictionary.model.Person

class DetailFragment : Fragment() {

    private var textView: TextView? = null
    private var recyclerView: RecyclerView? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater!!.inflate(R.layout.fragment_detail, container, false)
        initViews(savedInstanceState, rootView)
        return rootView
    }

    private fun initViews(savedInstanceState: Bundle?, rootView: View?) {
        textView = rootView?.findViewById(R.id.text_view) as TextView?
        recyclerView = rootView?.findViewById(R.id.recycler_view) as RecyclerView?

        textView?.text = arguments.getString("Result")
        val llm = LinearLayoutManager(context)
        llm.orientation = LinearLayoutManager.VERTICAL
        recyclerView?.layoutManager = llm
        recyclerView?.adapter = MyRecyclerAdapter(listOf(Person("Nai","Sk"), Person("Thad","Blead"),Person("Pun","Thinc"),Person("Poom","iOS"),Person("Peaw","Joke")))

    }

}
