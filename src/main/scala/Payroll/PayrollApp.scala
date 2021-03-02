package Payroll

case class USPayroll[A](payees: Seq[A])(implicit payrollProcessor: PayrollProcessor[USPayroll, A]) {
  def processPayroll = payrollProcessor.processPayroll(payees)
}

case class CanadaPayroll[A](payees: Seq[A])(implicit payrollProcessor: PayrollProcessor[CanadaPayroll, A]) {
  def processPayroll = payrollProcessor.processPayroll(payees)
}

import scala.language.higherKinds
trait PayrollProcessor[C[_], A] {
  def processPayroll(payees: Seq[A]): Either[Throwable, String]
}

case class Employee(name: String, id: Long)

object Processors {

  implicit object USPayrollProcessor extends PayrollProcessor[USPayroll, Employee] {
    def processPayroll(payees: Seq[Employee]) = Right("us employees are processed")
  }

  implicit object CanadaPayrollProcessor extends PayrollProcessor[CanadaPayroll, Employee] {
    def processPayroll(payees: Seq[Employee]) = Right("canada employees are processed")
  }
}
object PayrollApp extends App {
  import Processors._
  val r = USPayroll(Vector(Employee("bubu", 1))).processPayroll
  println(r)
}
