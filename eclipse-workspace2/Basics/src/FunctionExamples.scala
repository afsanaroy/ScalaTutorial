

object FunctionExamples {
  
  object Math{//because it is an object there is no need to create a new instance
    
    def add(x: Int,y: Int): Int={
     x +y;
    }  
    def square(x:Int) = x*x; //where there is only 1 parameter, use syntactical sugar
  }
  def add(x: Int,y: Int): Int={
     x +y;
  }
  
  def subtract(x: Int,y: Int): Int={
     x - y;
  }
  
  def multiply(x: Int,y: Int): Int= x * y;
  
  
  def divide(x: Int,y: Int)= x / y;
  
  def main(args: Array[String]){
    println(Math.add(45,15));
    println(Math square 3); //Syntactical sugar; also used in for loop
    println(add(4, 6));
    println(subtract(10, 6));
    println(multiply(10, 6));
    println(divide(10, 5));
    
    
  }
}