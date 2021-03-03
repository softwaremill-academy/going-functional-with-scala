package transformers

import scala.concurrent.{ExecutionContext, Future}
import scala.concurrent.ExecutionContext.global

case class FutureOptionT[A](value: Future[Option[A]])(implicit ec: ExecutionContext) {
  def map[B](f: A => B): FutureOptionT[B] = FutureOptionT(value.map(_.map(f)))

  def flatMap[B](f: A => FutureOptionT[B]): FutureOptionT[B] = FutureOptionT(value.flatMap {
    case Some(a) => f(a).value
    case None => Future.successful(None)
  })
}
