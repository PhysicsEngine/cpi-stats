package com.PhysicsEngine.cpistats
import scala.io.Source
import scala.xml.XML
import scala.xml.parsing.{ConstructingParser,XhtmlParser}

class StatsRequest {
    val appId = "904f6b530a97c03f66afe10ec54013d7123682ac"
      
    def statsList(params:Map[String,String]) = {
      var url = "http://statdb.nstac.go.jp/api/1.0b/app/getStatsList?lang=J&appId=" + appId + "&"
      params.foreach { 
        case(key, value) => url += key + "=" + value + "&"   
      }
      val src = Source.fromURL(url)
      val xml = XML.loadString( src.getLines.mkString )

      val titles = xml \\ "TITLE"
      
      println(titles.size)
    }

    def statsData(params:Map[String,String]) = {
      var url = "http://statdb.nstac.go.jp/api/1.0b/app/getStatsData?lang=E&appId=" + appId + "&"
      params.foreach { 
        case(key, value) => url += key + "=" + value + "&"   
      }
      val src = Source.fromURL(url)
      val xml = XML.loadString( src.getLines.mkString )
    }
}