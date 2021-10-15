package com.example.xmlparsingrssfeedhttpurlconnections.model.channel.item

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root
import org.simpleframework.xml.Text
import retrofit2.http.Path
import java.io.Serializable

@Root(name = "item", strict = false)
class Item @JvmOverloads constructor(
    @field:Element(name = "title")
    @param:Element(name = "title")
    var title: String? = null,


    @field:Element(name = "creator", required = false)
    @param:Element(name = "creator", required = false)
    var author: String? = "null",
    /*@field:Element(name = "dc:creator")
    @param:Element(name = "dc:creator")
    var author: String? = "null",*/


    @field:Element(name = "description", required = false)
    @param:Element(name = "description", required = false)
    var description : String? = "null",


    @field:Element(name = "encoded", required = false)
    @param:Element(name = "encoded", required = false)
    var contentEncoded: String? = "null"


    /*@field:Element(name = "content:encoded")
    @param:Element(name = "content:encoded")
    var contentEncoded: String? = null*/

) : Serializable