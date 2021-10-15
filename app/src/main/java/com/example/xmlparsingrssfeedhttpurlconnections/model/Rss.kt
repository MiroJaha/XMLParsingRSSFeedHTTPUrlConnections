package com.example.xmlparsingrssfeedhttpurlconnections.model

import com.example.xmlparsingrssfeedhttpurlconnections.model.channel.Channel
import com.example.xmlparsingrssfeedhttpurlconnections.model.channel.item.Item
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Path
import org.simpleframework.xml.Root
import java.io.Serializable

@Root(name = "rss", strict = false)
class Rss : Serializable {
    @field:ElementList(inline = true,name = "item")
    @field:Path("channel")
    var item: List<Item>? = null

    /*@field:Element(name = "channel")
    var channel: Channel? = null*/

}