

object ListExamples {
  val mylist: List[Int] = List(1,2,5,8,9,6,4);
  val names: List[String] = List("Max", "Tom", "John");
  
  def main(args: Array[String]){
    println(0 :: mylist);
    println(mylist);
    println(names);
    println(1 :: 5 :: 9 :: Nil);
    println(mylist);
    println(mylist.head);
    println(names.tail); //whatever you get after removing first value
    println(names.isEmpty);
    println(names.reverse);
    println(List.fill(5)(2));// a list of 5 2s
    
    println(mylist.max);
    
    //Iterating
    
    mylist.foreach(println)
    var sum : Int = 0;
    mylist.foreach(sum += _);
    println(sum);
    
    for(name <- names){  //assigns vslue from names array to name variable
      println(name);
    }
    
  }
}