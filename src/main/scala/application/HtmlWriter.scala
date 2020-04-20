package application


trait HtmlWriter[T] {
  def toHtml(in: T): String
}

object HtmlWriter {
  implicit class HtmlWriterOps[T](in: T) {
    def toHtml(implicit writer: HtmlWriter[T]): String = writer.toHtml(in)
  }
}