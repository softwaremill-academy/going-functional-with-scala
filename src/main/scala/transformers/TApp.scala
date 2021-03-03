package transformers


case class User(username: String, email: String)
case class Address(street: String, city: String, postalCode: String)

import java.util.concurrent.TimeUnit

import scala.collection.immutable.HashMap
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}
import scala.util.{Failure, Success}

object TApp extends App {

  val userDB: HashMap[Long, User] = HashMap(
    1L -> User("bubu", "bubu@sml.com"),
    2L -> User("kuba", "kuba@sml.com")
  )

  val adddressDB: HashMap[User, Address] = HashMap(
    User("bubu", "bubu@sml.com") -> Address("Mysliwska", "Gdańsk", "80283"),
    User("kuba", "kuba@sml.com") -> Address("Kiełczowska", "Kiełczów", "06500")
  )

  def findUserById(id: Long): Future[Option[User]] = Future {
    userDB.get(id)
  }

  def findAddressByUser(user: User): Future[Option[Address]] = Future {
    adddressDB.get(user)
  }

  def findAddressByUserId(id: Long) : Future[Option[Address]] =
    (for {
      user <- FutureOptionT(findUserById(id))//findUserById(id)
      address <- FutureOptionT(findAddressByUser(user))
    } yield address).value


  val result = Await.result(findAddressByUserId(1), Duration(5, TimeUnit.SECONDS))

  result match {
    case Some(address) => println(s"Address: ${address}")
    case _ => println("No Address found.")
  }

}
