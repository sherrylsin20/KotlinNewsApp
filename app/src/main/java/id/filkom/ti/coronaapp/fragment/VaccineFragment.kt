package id.filkom.ti.coronaapp.fragment

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.google.gson.Gson
import dmax.dialog.SpotsDialog
import id.filkom.ti.coronaapp.R
import id.filkom.ti.coronaapp.adapter.viewholder.ListArticleAdapter
import id.filkom.ti.coronaapp.common.Common
import id.filkom.ti.coronaapp.model.News
import id.filkom.ti.pemint.interfce.NewsService
import io.paperdb.Paper
import retrofit2.Call
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class VaccineFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var layoutManager: LinearLayoutManager
    lateinit var mService: NewsService
    lateinit var newsAdapter: ListArticleAdapter
    lateinit var dialog: AlertDialog

    lateinit var swiper: SwipeRefreshLayout

    lateinit var recycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_vaccine, container, false)

        swiper = view!!.findViewById(R.id.swipeVac)
        recycler = view!!.findViewById(R.id.rvVac)

        //News
        Paper.init(this.requireActivity())

        mService = Common.newsService

        swiper.setOnRefreshListener {
            loadNews(true)
        }

        recycler.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this.requireActivity())
        recycler.layoutManager = layoutManager

        dialog = SpotsDialog(this.requireActivity())

        loadNews(false)

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                VaccineFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
    private fun loadNews(isRefresh: Boolean) {
        if(!isRefresh) {
            val cache = Paper.book().read<String>("vaccine")
            if(cache != null && !cache.isBlank() && cache != "null") {
                val news = Gson().fromJson<News>(cache, News::class.java)
                newsAdapter = ListArticleAdapter(this.requireActivity().baseContext, news)
                newsAdapter.notifyDataSetChanged()
                recycler.adapter = newsAdapter
            }
            else {
                dialog.show()

                mService.vaccine.enqueue(object:retrofit2.Callback<News>{
                    override fun onResponse(call: Call<News>, response: Response<News>) {
                        newsAdapter = ListArticleAdapter(activity!!.baseContext, response!!.body()!!)
                        newsAdapter.notifyDataSetChanged()
                        recycler.adapter = newsAdapter

                        Paper.book().write("vaccine", Gson().toJson(response!!.body()!!))

                        dialog.dismiss()
                    }

                    override fun onFailure(call: Call<News>, t: Throwable) {
                        Toast.makeText(activity!!.baseContext, "Failed", Toast.LENGTH_SHORT).show()
                    }

                })
            }
        }
        else {
            swiper.isRefreshing = true

            mService.vaccine.enqueue(object:retrofit2.Callback<News>{
                override fun onResponse(call: Call<News>, response: Response<News>) {
                    newsAdapter = ListArticleAdapter(activity!!.baseContext, response!!.body()!!)
                    newsAdapter.notifyDataSetChanged()
                    recycler.adapter = newsAdapter

                    Paper.book().write("vaccine", Gson().toJson(response!!.body()!!))

                    swiper.isRefreshing = false
                }

                override fun onFailure(call: Call<News>, t: Throwable) {
                    Toast.makeText(activity!!.baseContext, "Failed", Toast.LENGTH_SHORT).show()
                }

            })
        }
    }
}