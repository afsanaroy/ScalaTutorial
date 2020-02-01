

object SetExamples {
  var myset: Set[Int] = Set(1,2,3,44,9,6,5,5);
  val names: Set[String] = Set("max", "john", "Kobe");
  def main(args:Array[String]){
    println(myset + 10);
    println(names("Maxxxxx"));
    
  }
}