// None vs Option.empty, covariance
val some: Option[Int] = Some(42)
val none: Option[Int] = Option.empty[Int]

// Option as collection

// map+getOrElse
def mapGetOrElse(opt: Option[String]): String = {
  //  opt.map(v => s"present: $v").getOrElse("empty")
  //  opt.fold("empty")(v => s"present: $v")
  opt match {
    case Some(value) => s"present: $value"
    case None => "empty"
  }
}

mapGetOrElse(Some("test"))
mapGetOrElse(None)

// fold

// pattern matching