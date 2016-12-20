package com.sk.nai.kdictionary.fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.sk.nai.kdictionary.R

class DetailFragment : Fragment() {

    private var textView: TextView? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater!!.inflate(R.layout.fragment_detail, container, false)
        initViews(savedInstanceState, rootView)
        return rootView
    }

    private fun initViews(savedInstanceState: Bundle?, rootView: View?) {
        textView = rootView?.findViewById(R.id.text_view) as TextView?
        textView?.text = arguments.getString("Result")
    }

}
