package com.example.xmlparsingrssfeedhttpurlconnections.model

import com.example.xmlparsingrssfeedhttpurlconnections.model.channel.Channel
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root
import java.io.Serializable

@Root(name = "rss", strict = false)
class Rss : Serializable {
    @field:Element(name = "channel")
    var channel: Channel? = null

}