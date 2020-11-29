package id.filkom.ti.coronaapp.adapter.viewholder

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import id.filkom.ti.coronaapp.R
import id.filkom.ti.coronaapp.interfce.ItemClickListener
import id.filkom.ti.coronaapp.model.News

class ListArticleAdapter(
    private val context: Context,
    private val news: News
) : RecyclerView.Adapter<ListArticleViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListArticleViewHolder {
        val inflater = LayoutInflater.from(parent!!.context)
        val itemView = inflater.inflate(R.layout.item_rv, parent, false)
        return ListArticleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ListArticleViewHolder, position: Int) {
        holder!!.article_title.text = news.articles!![position].title
        holder!!.article_author.text = news.articles!![position].author
        holder!!.article_desc.text = news.articles!![position].description
        var image = news.articles!![position].urlToImage
        Glide.with(context)
            .load(image)
            .apply(RequestOptions().placeholder(R.drawable.ic_baseline_help).centerCrop())
            .into(holder!!.article_image)

        holder.setItemClickListener(object : ItemClickListener {
            override fun onClick(view: View, position: Int) {
                Toast.makeText(context, "Will be implemented in next tutorial", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }

    override fun getItemCount(): Int {
        return news.articles!!.size
    }
}