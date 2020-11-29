package id.filkom.ti.coronaapp.adapter.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import id.filkom.ti.coronaapp.interfce.ItemClickListener
import kotlinx.android.synthetic.main.item_rv.view.*

class ListArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
    View.OnClickListener {
    private lateinit var itemClickListener: ItemClickListener

    var article_title = itemView.news_title
    var article_image = itemView.news_image
    var article_desc = itemView.news_desc
    var article_author = itemView.news_author

    fun setItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListener = itemClickListener
    }

    override fun onClick(v: View?) {
        itemClickListener.onClick(v!!, adapterPosition)
    }
}