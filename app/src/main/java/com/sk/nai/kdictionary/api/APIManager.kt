package com.sk.nai.kdictionary.api

import com.sk.nai.kdictionary.model.Formula
import com.squareup.moshi.Moshi
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by naisk133 on 21/12/2559.
 */
object APIManager {

    private val retrofit = Retrofit.Builder().baseUrl("https://simple-api-server-ecswrhooxn.now.sh/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    val medicalcAPI:MedicalcService = retrofit.create(MedicalcService::class.java)
}