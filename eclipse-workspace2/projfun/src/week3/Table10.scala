import scala.io.StdIn.{readLine, readInt}
object Table10{
  
  def calc(a:Int) ={
    for(i <- 1 to a) println(i +" * " + "10 = " + i * 10)
      //println(i * 10)
}  
  
  def main(args: Array[String])
  {
    var n = readLine.toInt
    
    calc(n)
  }
}

