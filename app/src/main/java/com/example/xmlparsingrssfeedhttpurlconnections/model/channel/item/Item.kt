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

    //&#58;
    /*@field:Element(name = "dc:creator")
    @param:Element(name = "dc:creator")
    var author: String? = null,*/
    /*@Path("dc:creator")
    @Text(required=false)
    var author: String? = null,*/

    @field:Element(name = "description")
    @param:Element(name = "description")
    var description : String? = null//,

    /*@field:Element(name = "content:encoded")
    @param:Element(name = "content:encoded")
    var contentEncoded: String? = null*/

) : Serializable