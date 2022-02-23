package ir.omidrezabagherian.testapplicationfive

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import ir.omidrezabagherian.testapplicationfive.Adapter.SearchAdapter
import ir.omidrezabagherian.testapplicationfive.ModelHome.ImageHome
import ir.omidrezabagherian.testapplicationfive.databinding.FragmentSearchBinding
import ir.omidrezabagherian.testapplicationfive.Data.NetworkManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchFragment : Fragment(R.layout.fragment_search) {

    private lateinit var bindingSearch: FragmentSearchBinding
    private lateinit var imageAdapter: SearchAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        bindingSearch = FragmentSearchBinding.bind(view)

        bindingSearch.recyclerviewSearch.layoutManager = LinearLayoutManager(context)

        imageAdapter = SearchAdapter(this)


        val text = bindingSearch.edittextSearch.text

        bindingSearch.imageviewSearch.setOnClickListener {
            bindingSearch.recyclerviewSearch.adapter = imageAdapter

            NetworkManager.service.searchImage(
                "1c04e05bce6e626247758d120b372a73",
                "flickr.photos.search",
                text,
                "34427466731@N01",
                "url_s",
                "json",
                1,
                100,
                1
            ).enqueue(object : Callback<ImageHome> {

                override fun onResponse(call: Call<ImageHome>, response: Response<ImageHome>) {
                    imageAdapter.setDataList(response.body()!!.photos.photo)
                    Log.i("APP1", response.body()!!.photos.photo.toString())
                }

                override fun onFailure(call: Call<ImageHome>, t: Throwable) {
                    Log.i("TAG_APP", t.toString())
                }

            })
        }

        super.onViewCreated(view, savedInstanceState)
    }
}