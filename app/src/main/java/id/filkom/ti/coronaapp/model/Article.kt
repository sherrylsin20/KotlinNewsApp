package id.filkom.ti.coronapp.model

import id.filkom.ti.coronaapp.model.Source
import java.util.*

class Article {
    var source: Source? = null
    var author: String? = null
    var title: String? = null
    var description: String? = null
    var url: String? = null
    var urlToImage: String? = null
    var publishedAt: Date? = null
    var content: String? = null
}
