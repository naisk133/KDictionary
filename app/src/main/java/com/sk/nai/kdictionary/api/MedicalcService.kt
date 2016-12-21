package com.sk.nai.kdictionary.api

import com.sk.nai.kdictionary.model.Formula
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by naisk133 on 21/12/2559.
 */
interface MedicalcService {
    @GET("/get")
    fun listFormula(): Call<List<Formula>>
}