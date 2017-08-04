package com.nnd.tripper.model

import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by Android dev on 8/4/17.
 */
interface RESTInterface {
    @GET("/")
    fun checkStatus(): Observable<ResponseREST>
}