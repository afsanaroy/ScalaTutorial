

object FunctionsAdvanced {
  
  object Math{
    def add(x: Int = 45, y: Int = 15): Int ={
      return x + y;
    }
    def **(x:Int)= x*x;
  }
  def print(x:Int, y:Int): Unit = {
    println(x+y);
  }
  def main(args:Array[String]){
    
    var add =(x : Int, y: Int) => x+y; //anonymous function; add is a variable
    println(add(300,500));
    print(100,400);
    println(Math.add(60,50));
    println(Math ** 3);
  }
}