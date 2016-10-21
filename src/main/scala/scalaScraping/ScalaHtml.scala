package scalaScraping

import java.io.{File, PrintWriter}

import scala.io.Source
import scala.util.matching.Regex

/**
  * Created by kenta-yoshinaga on 2016/10/19.
  */
class ScalaHtml {

  def getURLfromSource(url: String): List[String] = {
    val src = Source.fromURL(url, "utf-8").getLines.toList
    var charset: String = null
    val regex = new Regex("""charset[ ]*=[ ]*[0-9a-z|\-|_]+""")
    var cnt: Int = 0
    var urls = List.empty[String]

    for(line <- src){
      if( line.contains("<div class=\"listArea\">"))  cnt = 1
      if( line.contains("</div><!-- /.listArea -->")) cnt = 0

      if(cnt == 1){
        if(line.contains("pickup")) {
          val ss = line.split('"')
          urls = ss(1) :: urls
        }
      }
    }
    urls
  }

  def getTextfromSource(urls: List[String], dirName: String): Unit = {
    var newFile = new File(dirName)
    if (!newFile.exists())  newFile.mkdir()

    for ( i <- urls){
      var durl = i.split('/')
      var filename:String = durl.last

      val src = Source.fromURL(i, "utf-8").getLines.toList
      val regex = new Regex("""charset[ ]*=[ ]*[0-9a-z|\-|_]+""")
      var cnt: Int = 0
      var tmp:String = null

      for (j <- src){
        if(j.contains("hbody"))                     cnt = 1
        if(j.contains("</div><!--/.headline -->"))  cnt = 0
        if(cnt == 1)  tmp += j
      }

      var tmp2 = tmp.replaceAll("<br>", "")
      var ss = tmp2.split('>')
      var ss2 = ss(1).replaceAll("</p", "")

      var ss3: String = ss2
      if(ss2.endsWith("p")) ss3 = ss2.init
      var last: String = ss3
      if(ss3.endsWith(("/"))) last = ss3.init

      if(last.trim != null && last.trim != "\n"){
        val out = new PrintWriter( dirName + "/" + filename)
        out.write(last.stripLineEnd)
        out.close
      }
    }
  }

}

object ScalaHtml{

  def prefix(category: String, page: Int):String =
    "http://news.yahoo.co.jp/list/?c=%s&p=%d".format(category, page)

  def main(args: Array[String]): Unit = {
    println("Hello")
    val html = new ScalaHtml
    val url = prefix(args(0), args(1).toInt)
    val src = html.getURLfromSource(url)
    html.getTextfromSource(src, "./data/%s".format(args(0)))
  }
}