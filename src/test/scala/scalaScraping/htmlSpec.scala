package scalaScraping

import org.scalatest.{FlatSpec, Matchers}

import scala.io.Source

/**
  * Created by kenta-yoshinaga on 2016/10/20.
  */
class htmlSpec extends FlatSpec with Matchers{

  "html" should "get source from the page" in {
    val source = Source.fromURL("http://news.yahoo.co.jp/list/?c=domestic&p=1", "utf-8")
    val lines = source.getLines()
    lines.foreach(println)
    1 should be (1)
  }

}
