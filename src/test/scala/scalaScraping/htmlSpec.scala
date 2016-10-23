package scalaScraping

import com.ibm.icu.text.Transliterator
import org.scalatest.{FlatSpec, Matchers}

import scala.io.Source

/**
  * Created by kenta-yoshinaga on 2016/10/20.
  */
class htmlSpec extends FlatSpec with Matchers{

  "html" should "get source from the page" in {
    val transliterator = Transliterator.getInstance("Halfwidth-Fullwidth")
    println(transliterator.transliterate("（1760～1849）の"))
    println(ScalaHtml.prefix("domestic", 1))
    1 should be (1)
  }
}
