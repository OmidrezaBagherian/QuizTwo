package ir.omidrezabagherian.testapplicationfive.Data

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object NetworkManager {
    val okHttpClient: OkHttpClient = OkHttpClient.Builder()
        .readTimeout(15, TimeUnit.SECONDS)
        .connectTimeout(15, TimeUnit.SECONDS)
        .build()

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://www.flickr.com/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create(ImageService::class.java)
}