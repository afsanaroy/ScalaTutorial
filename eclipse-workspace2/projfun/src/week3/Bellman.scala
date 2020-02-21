// The program is for adjacency matrix representation of the graph
import java.util._
import scala.jdk.CollectionConverters._
import java.lang._

import java.io._


object ShortestPath {

// from the set of vertices not yet included in shortest path tree
  val V: Int = 5

// Driver method
  def main(args: Array[String]): Unit = {
    /* Let us create the example graph discussed above */

    val graph: Array[Array[Int]] = Array(
      Array(0, -1, 4, 0, 0),
      Array(0, 0, 3, 2, 2),
      Array(0, 0, 2, 0, 0),
      Array(0, 1, 5, -2, 0),
      Array(0, 0, 0, -3,1)
    )
    val t: ShortestPath = new ShortestPath()
    t.bell(graph, 0)
  }

}

class ShortestPath {

  def minDistance(dist: Array[Int], sptSet: Array[java.lang.Boolean]): Int = {
// Initialize min value
    var min: Int = java.lang.Integer.MAX_VALUE
    var min_index: Int = -1
    for (v <- 0 until 5 if sptSet(v) == false && dist(v) <= min) {
      min = dist(v)
      min_index = v
    }
    min_index
  }

// A utility function to print the constructed distance array
  def printSolution(dist: Array[Int], n: Int): Unit = {
    println("Vertex Distance from Source")
    for (i <- 0 until 5) println(i, dist(i))
  }
// representation
  def bell(graph: Array[Array[Int]], src: Int): Unit = {
// The output array. dist[i] will hold
    val dist: Array[Int] = Array.ofDim[Int](5)
// path tree or shortest distance from src to i is finalized
    val sptSet: Array[java.lang.Boolean] = Array.ofDim[Boolean](9)
    for (i <- 0 until 5) {
      dist(i) = java.lang.Integer.MAX_VALUE
      sptSet(i) = false
    }
// Distance of source vertex from itself is always 0
    dist(src) = 0
    for (count <- 0 until 4) {
// iteration.
      val u: Int = minDistance(dist, sptSet)
// Mark the picked vertex as processed
      sptSet(u) = true
      for (v <- 0 until 5)
           if( !sptSet(v) && graph(u)(v) != 0 && dist(u) != java.lang.Integer.MAX_VALUE &&
             dist(u) + graph(u)(v) < dist(v)) dist(v) = dist(u) + graph(u)(v)
    }
    printSolution(dist, 5)
  }
}


