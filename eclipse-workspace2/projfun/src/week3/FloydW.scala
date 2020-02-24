//remove if not needed
//import scala.collection.JavaConversions._
import scala.jdk.CollectionConverters._
object FloydWarshell {

// vertex u from source vertex v
  private def printPath(path: Array[Array[Int]], v: Int, u: Int): Unit = {
    if (path(v)(u) == v) return
    printPath(path, v, path(v)(u))
    print(path(v)(u) + " ")
  }

// information between all pairs of vertices
  private def printSolution(cost: Array[Array[Int]],
                            path: Array[Array[Int]],
                            N: Int): Unit = {
    for (v <- 0 until N; u <- 0 until N if u != v && path(v)(u) != -1) {
      System.out.print(
        "Shortest Path from vertex " + v + " to vertex " + u + " is (" + v + " ")
      printPath(path, v, u)
      println(u)
    }
  }

// Function to run Floyd-Warshall algorithm
  def FloydWarshell(adjMatrix: Array[Array[Int]], N: Int): Unit = {
// (shortest-cost/shortest route) information
    val cost: Array[Array[Int]] = Array.ofDim[Int](N, N)
    val path: Array[Array[Int]] = Array.ofDim[Int](N, N)
    for (v <- 0 until N; u <- 0 until N) {
// of the edge
      cost(v)(u) = adjMatrix(v)(u)
      path(v)(u) =
        if (v == u) 0
        else if (cost(v)(u) != java.lang.Integer.MAX_VALUE) v
        else -1
    }
// initally cost would be same as weight
    for (k <- 0 until N; v <- 0 until N) {
      for (u <- 0 until N if cost(v)(k) != java.lang.Integer.MAX_VALUE && cost(
             k)(u) != java.lang.Integer.MAX_VALUE &&
             (cost(v)(k) + cost(k)(u) < cost(v)(u))) {
        cost(v)(u) = cost(v)(k) + cost(k)(u)
        path(v)(u) = path(k)(u)
      }
// graph contains a negative weight cycle
      if (cost(v)(v) < 0) {
        println("Negative Weight Cycle Found!!")
        return
      }
    }
// if diagonal elements become negative, then
// Print the shortest path between all pairs of vertices
    printSolution(cost, path, N)
  }
// cost[] and parent[] stores shortest-path
// cost[] and parent[] stores shortest-path

  def main(args: Array[String]): Unit = {
// Number of vertices in the adjMatrix
    val N: Int = 4
    val M: Int = java.lang.Integer.MAX_VALUE
// given adjacency representation of matrix
    val adjMatrix: Array[Array[Int]] = Array(Array(0, M, -2, M),
                                             Array(4, 0, 3, M),
                                             Array(M, M, 0, 2),
                                             Array(M, -1, M, 0))
// Run Floyd Warshall algorithm
    FloydWarshell(adjMatrix, N)
  }

}

