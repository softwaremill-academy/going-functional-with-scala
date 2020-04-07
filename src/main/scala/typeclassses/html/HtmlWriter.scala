package typeclassses.html

trait HtmlWriter[T] {
  def toHtml: String
}

object HtmlWriter {
  def write(in: Any): String = ???
}