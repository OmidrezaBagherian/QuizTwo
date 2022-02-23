package ir.omidrezabagherian.testapplicationfive

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import ir.omidrezabagherian.testapplicationfive.Adapter.ImageAdapter
import ir.omidrezabagherian.testapplicationfive.ModelHome.ImageHome
import ir.omidrezabagherian.testapplicationfive.databinding.FragmentHomeBinding
import ir.omidrezabagherian.testapplicationfive.Data.NetworkManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var bindingHome: FragmentHomeBinding
    private lateinit var imageAdapter: ImageAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        bindingHome = FragmentHomeBinding.bind(view)

        bindingHome.recyclerviewHome.layoutManager = LinearLayoutManager(context)

        imageAdapter = ImageAdapter(this)

        bindingHome.recyclerviewHome.adapter = imageAdapter

        NetworkManager.service.uploadImage(
            "1c04e05bce6e626247758d120b372a73",
            "flickr.photos.getPopular",
            "34427466731@N01",
            "url_s",
            "json",
            1,
            100,
            1
        ).enqueue(object : Callback<ImageHome> {
            override fun onResponse(call: Call<ImageHome>, response: Response<ImageHome>) {
                imageAdapter.setDataList(response.body()!!.photos.photo)
            }

            override fun onFailure(call: Call<ImageHome>, t: Throwable) {
                Log.i("Throwable", t.toString())
            }

        })

        super.onViewCreated(view, savedInstanceState)
    }
}