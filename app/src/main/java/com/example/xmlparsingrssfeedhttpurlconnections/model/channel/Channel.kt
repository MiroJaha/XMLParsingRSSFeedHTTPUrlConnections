package com.example.xmlparsingrssfeedhttpurlconnections.model.channel

import com.example.xmlparsingrssfeedhttpurlconnections.model.channel.item.Item
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root
import java.io.Serializable

@Root(name = "channel", strict = false)
class Channel : Serializable {
    @field:ElementList(inline = true,name = "item")
    var item: List<Item>? = null
}