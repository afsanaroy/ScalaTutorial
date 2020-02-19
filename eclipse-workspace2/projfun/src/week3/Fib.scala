object Fib extends App{
  
  def fibo(a:Int): Int = a match{  
  case 0 | 1 => a
    case _ => fibo(a - 1) + fibo(a - 2)
  }
  for(i <- 0 to 6)
  println( fibo(i))
}
