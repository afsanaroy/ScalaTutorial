
import java.util.Date
object PartiallyApplied {
  
  def log(date: Date, message: String) ={
    println(date + "" + message);
  }
  
  def main(args:Array[String]){
    val sum = (a: Int, b: Int, c: Int) => a + b +c
    
    val f = sum(10, 20, _ : Int) //datatype of expected argument
    
    println(f(30));
    
    val date = new Date;
    val newLog = log(date, _: String);
    newLog(" The message 1");
    newLog(" The message 2");
    newLog(" The message 3");

            
  }
}