package ir.omidrezabagherian.testapplicationfive.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ir.omidrezabagherian.testapplicationfive.ModelHome.Photo
import ir.omidrezabagherian.testapplicationfive.R

class SearchAdapter(private val fragment: Fragment) : RecyclerView.Adapter<SearchAdapter.ViewHolder>() {
    private var dataList = mutableListOf<Photo>()

    fun setDataList(dataList: List<Photo>) {
        this.dataList.clear()
        this.dataList.addAll(dataList)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.image_card)
        val title: TextView = itemView.findViewById(R.id.title_card)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.card_image, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataList[position]

        Log.i("App_Data",data.toString())

        Glide.with(fragment)
            .load(data.url_s)
            .placeholder(R.drawable.ic_baseline_home_24)
            .into(holder.image)

        holder.title.text = data.title

    }

    override fun getItemCount() = dataList.size

}