

object MapsExample {
  
  val mymap : Map[Int, String] = Map(801 -> "Max", 802 ->"Tom", 803 -> "June");
  val mymap2 : Map[Int, String] = Map(807 -> "Matt");
  def main(args: Array[String]){
    println(mymap);
    println(mymap(803));
    println(mymap.keys);
    println(mymap.values);
    
    mymap.keys.foreach { key =>
      println("Key " + key);
      println("Value " +mymap(key));
    }
    
    println(mymap.contains(801000));
    println(mymap ++ mymap2);
    println(mymap.size);
    
    
  }
}