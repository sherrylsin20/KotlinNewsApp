package id.filkom.ti.pemint.interfce

import id.filkom.ti.coronaapp.model.News
import retrofit2.Call
import retrofit2.http.GET

interface NewsService {
    @get:GET("v2/everything?language=en&sortBy=relevancy&pageSize=100&q=+corona&excludeDomains=reuters.com&apiKey=b2d8a3ef27844f13be496c3285fe6c4a")
    val top: Call<News>

    @get:GET("v2/top-headlines?pageSize=100&q=vaccine&apiKey=b2d8a3ef27844f13be496c3285fe6c4a")
    val vaccine: Call<News>

    @get:GET("v2/everything?pageSize=100&language=id&q=corona&apiKey=b2d8a3ef27844f13be496c3285fe6c4a")
    val indo: Call<News>

    @get:GET("v2/everything?pageSize=100&q=+corona+virus+america&sortBy=popularity&language=en&apiKey=b2d8a3ef27844f13be496c3285fe6c4a")
    val global: Call<News>
}