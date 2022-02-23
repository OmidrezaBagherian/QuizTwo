package ir.omidrezabagherian.testapplicationfive.Data

import android.text.Editable
import ir.omidrezabagherian.testapplicationfive.ModelHome.ImageHome
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ImageService {

    @GET("/services/rest/?")
    fun uploadImage(
        @Query("api_key") api_key: String,
        @Query("method") method: String,
        @Query("user_id") user_id: String,
        @Query("extras") extras: String,
        @Query("format") format: String,
        @Query("nojsoncallback") noJsonCallBack: Int,
        @Query("per_page") per_page: Int,
        @Query("page") page: Int
    ): Call<ImageHome>

    @GET("/services/rest/?")
    fun searchImage(
        @Query("api_key") api_key: String,
        @Query("method") method: String,
        @Query("text") text: Editable?,
        @Query("user_id") user_id: String,
        @Query("extras") extras: String,
        @Query("format") format: String,
        @Query("nojsoncallback") noJsonCallBack: Int,
        @Query("per_page") per_page: Int,
        @Query("page") page: Int
    ): Call<ImageHome>

}