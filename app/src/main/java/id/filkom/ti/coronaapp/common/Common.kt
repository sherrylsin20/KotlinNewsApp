package id.filkom.ti.coronaapp.common

import id.filkom.ti.coronaApp.remote.RetrofitClient
import id.filkom.ti.pemint.interfce.NewsService

object Common {
    val BASE_URL = "https://newsapi.org/"
    val API_KEY = "b2d8a3ef27844f13be496c3285fe6c4a"

    val newsService:NewsService
        get()= RetrofitClient.getClient(BASE_URL).create(NewsService::class.java)
}