

object MatchExample {
  def main(args: Array[String]){
    val age = 18;//match as statement
    age match {
      case 20 => println(age);
      case 18 => println(age);
      case _ => println("default");
      
    }
    
    var result = age match {//match as expression
      case 20 => age;
      case 18 => age;
      case _ => "default";
      
    }
    println(result);
    val i= 7;
    i match {
      case 1 | 3 | 5 |7|9 => println("odd");
      case 2|4 => println("even");
    }
  }
}