import scala.annotation.{tailrec, targetName}
import scala.language.implicitConversions

// Define traits and case classes for the AST
sealed trait Expr{
  @targetName("add")
  def <+>(that: Expr): Expr = Add(this, that)
  @targetName("multiply")
  def <*>(that: Expr): Expr = Multiply(this, that)
}

case class Add(lhs: Expr, rhs: Expr) extends Expr
case class Multiply(lhs: Expr, rhs: Expr) extends Expr
case class Literal(value: Int) extends Expr


def eval(expr: Expr): Int = expr match {
  case Add(lhs, rhs) => eval(lhs) + eval(rhs)
  case Multiply(lhs, rhs) => eval(lhs) * eval(rhs)
  case Literal(value) => value
}

def describe(expr: Expr): String = expr match {
  case Add(lhs, rhs) => s"(${describe(lhs)} + ${describe(rhs)})"
  case Multiply(lhs, rhs) => s"(${describe(lhs)} * ${describe(rhs)})"
  case Literal(value) => value.toString
}

val expr = Add(Multiply(Literal(2), Literal(3)), Add(Literal(4), Literal(5)))

println(describe(expr)) // Output: ((2 * 3) + (4 + 5))
println(eval(expr)) // Output: 15

val expr2 = Literal(2) <*> Literal(3) <+> (Literal(4) <+> Literal(5))

// Implicit conversion from Int to Expr
implicit def intToExpr(value: Int): Expr = Literal(value)

// turn on show implicit hints
val a: Expr = 2

val expr4 = a <*> 300000 <+> (4 <+> 5)

// To optimize recursive methods like describe and eval, we can use tail recursion.
// Tail recursion allows the compiler to optimize the recursion to a loop,
// which can help avoid stack overflow errors and generally improve performance.

def eval1(expr: Expr): Int = {
//  @tailrec
// this can't be tail recursive
  def loop(expr: Expr, acc: Int => Int): Int = expr match {
    case Add(lhs, rhs) => loop(lhs, v1 => loop(rhs, v2 => acc(v1 + v2)))
    case Multiply(lhs, rhs) => loop(lhs, v1 => loop(rhs, v2 => acc(v1 * v2)))
    case Literal(value) => acc(value)
  }
  loop(expr, identity)
}

println(eval1(expr)) // Output: 15


// Eval method using tail recursion
def eval2(expr: Expr): Int = {
  @tailrec
  def evalHelper(stack: List[Expr], values: List[Int], operations: List[(Int, Int) => Int]): Int = stack match {
    case Nil => values match {
      case result :: Nil => result
      case _ => throw new IllegalStateException("Invalid state")
    }
    case Literal(value) :: tail => values match {
      case Nil => evalHelper(tail, value :: values, operations)
      case x :: xs => operations match {
        case op :: ops => evalHelper(tail, op(x, value) :: xs, ops)
        case Nil => evalHelper(tail, value :: values, operations)
      }
    }
    case Add(lhs, rhs) :: tail => evalHelper(lhs :: rhs :: tail, values, ((_: Int) + (_: Int)) :: operations)
    case Multiply(lhs, rhs) :: tail => evalHelper(lhs :: rhs :: tail, values, ((_: Int) * (_: Int)) :: operations)
  }

  evalHelper(List(expr), Nil, Nil)
}

println(eval2(expr)) // Should output: 15