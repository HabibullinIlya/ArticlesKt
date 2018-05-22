package com.gimba.handbookkt.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class Article() {
    @SerializedName("tags")
    @Expose
    var tags: String? = null
    @SerializedName("article_text")
    @Expose
     var articleText: String? = null
    @SerializedName("name_acticle")
    @Expose
     var nameActicle: String? = null
    @SerializedName("id")
    @Expose
    var id: Int? = null

    constructor(id:Int, name:String,tags:String,text:String) : this() {
        this.id = id
        nameActicle = name
        this.tags = tags
        articleText = text
    }
    constructor(name:String,tags:String,text:String) : this() {
        nameActicle = name
        this.tags = tags
        articleText = text
    }

}
