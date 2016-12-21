package com.sk.nai.kdictionary.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.sk.nai.kdictionary.R
import com.sk.nai.kdictionary.activity.adapter.MyRecyclerAdapter
import com.sk.nai.kdictionary.api.APIManager
import com.sk.nai.kdictionary.model.Formula
import com.sk.nai.kdictionary.model.Person
import kotlinx.android.synthetic.main.fragment_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class DetailFragment : Fragment() {

    private var formulas: List<Formula> = listOf()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater!!.inflate(R.layout.fragment_detail, container, false)
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initViews(savedInstanceState)
    }

    private fun initViews(savedInstanceState: Bundle?) {

        text_view?.text = arguments.getString("Result")
        val llm = LinearLayoutManager(context)
        llm.orientation = LinearLayoutManager.VERTICAL
        recycler_view?.layoutManager = llm
        recycler_view?.adapter = MyRecyclerAdapter(formulas)
    }

    private fun loadFormulaFromServer() {
        val call = APIManager.medicalcAPI.listFormula()
        call.enqueue(object : Callback<List<Formula>> {
            override fun onResponse(call: Call<List<Formula>>?, response: Response<List<Formula>>?) {
                if (response?.isSuccessful ?: false) {
                    formulas = response?.body() ?: formulas
                    recycler_view?.adapter = MyRecyclerAdapter(formulas)
                    recycler_view?.adapter?.notifyDataSetChanged()
                } else {
                    Log.d("DetailFragment", "Response not successful")
                }
            }
            override fun onFailure(call: Call<List<Formula>>?, t: Throwable?) {
                Log.d("DetailFragment", "Load data Failure")
            }
        })
    }

    override fun onResume() {
        super.onResume()
        loadFormulaFromServer()
    }
}
