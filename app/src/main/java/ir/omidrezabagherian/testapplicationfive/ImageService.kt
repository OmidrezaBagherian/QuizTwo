package ir.omidrezabagherian.testapplicationfour

import android.graphics.Bitmap
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*

interface ImageService {

    @Multipart
    @GET("/{api_key}&{method}&{user_id}&{extras}&{format}&{nojsoncallback}&{per_page}&{page}")
    fun uploadImage(
        @Path("api_key") api_key: String,
        @Path("method") method: String,
        @Path("user_id") user_id: String,
        @Path("extras") extras: String,
        @Path("format") format: String,
        @Path("nojsoncallback") noJsonCallBack: Int,
        @Path("per_page") per_page: Int,
        @Path("page") page: Int
    ): Call<Any>

}