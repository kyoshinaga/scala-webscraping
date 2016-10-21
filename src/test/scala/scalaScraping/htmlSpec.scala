package scalaScraping

import org.scalatest.{FlatSpec, Matchers}

import scala.io.Source

/**
  * Created by kenta-yoshinaga on 2016/10/20.
  */
class htmlSpec extends FlatSpec with Matchers{

  "html" should "get source from the page" in {
    println(ScalaHtml.prefix("domestic", 1))
    1 should be (1)
  }

}
