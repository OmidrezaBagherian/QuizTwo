package ir.omidrezabagherian.testapplicationfive

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.google.gson.GsonBuilder
import ir.omidrezabagherian.testapplicationfive.databinding.FragmentHomeBinding
import ir.omidrezabagherian.testapplicationfour.NetworkManager
import retrofit2.Call
import retrofit2.Response
import java.util.*

class HomeFragment:Fragment(R.layout.fragment_home) {
    private lateinit var bindingHome: FragmentHomeBinding
    private lateinit var videoAdapter: ImageAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        bindingHome = FragmentHomeBinding.bind(view)

        bindingHome.recyclerviewHome.layoutManager = GridLayoutManager(context,2)

        NetworkManager.service.uploadImage(100).enqueue(object :
            retrofit2.Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                val body = response.body().toString()
                val gson = GsonBuilder().create()
                val result = gson.fromJson(body, ImageModel::class.java)
                Log.i("App", body)
                val adapter = ImageAdapter(this@HomeFragment,result)

                bindingHome.recyclerviewHome.adapter = adapter
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                Log.i("TAG_APP",t.toString())
            }

        })

        super.onViewCreated(view, savedInstanceState)
    }
}