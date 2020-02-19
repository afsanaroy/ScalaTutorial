package week3

object exer extends App {
  val numList1 = List(1,2)
	val numList2 = List(3,4)

	  for(first <- numList1; second <- numList2) yield println(first + second)
}