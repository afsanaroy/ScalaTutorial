import HamiltonianCycle._

//remove if not needed
//import scala.collection.JavaConversions._
import scala.jdk.CollectionConverters._
object HamiltonianCycle {

// driver program to test above function
  def main(args: Array[String]): Unit = {
    val hamiltonian: HamiltonianCycle = new HamiltonianCycle()
    /* Let us create the following graph
           (0)--(1)--(2)
   /    |
  /     |
 /     |
           (3)-------(4)    */

    val graph1: Array[Array[Int]] = Array(Array(0, 1, 0, 1, 0),
                                          Array(1, 0, 1, 1, 1),
                                          Array(0, 1, 0, 0, 1),
                                          Array(1, 1, 0, 0, 1),
                                          Array(0, 1, 1, 1, 0))
// Print the solution
    hamiltonian.hamCycle(graph1)
    /* Let us create the following graph
           (0)--(1)--(2)
   /    |
  /     |
 /     |
           (3)       (4)    */

    val graph2: Array[Array[Int]] = Array(Array(0, 1, 0, 1, 0),
                                          Array(1, 0, 1, 1, 1),
                                          Array(0, 1, 0, 0, 1),
                                          Array(1, 1, 0, 0, 0),
                                          Array(0, 1, 1, 0, 0))
// Print the solution
    hamiltonian.hamCycle(graph2)
  }

}

class HamiltonianCycle {

  val V: Int = 5

  var path: Int = _

  /* A utility function to check if the vertex v can be
       added at index 'pos'in the Hamiltonian Cycle
       constructed so far (stored in 'path[]') */

  def isSafe(v: Int,graph: Array[Array[Int]], path: Array[Int], pos: Int): Boolean = {
    /* Check if this vertex is an adjacent vertex of
           the previously added vertex. */

    if (graph(path(pos - 1))(v) == 0) false
    for (i <- 0 until pos if path(i) == v) false
    true
  }

  /* A recursive utility function to solve hamiltonian
       cycle problem */

  def hamCycleUtil(graph: Array[Array[Int]],
                   path: Array[Int],
                   pos: Int): Boolean = {
    /* base case: If all vertices are included in
           Hamiltonian Cycle */

    if (pos == V) {
// vertex to the first vertex
      if (graph(path(pos - 1))(path(0)) == 1) true else false
    }
// And if there is an edge from the last included
// And if there is an edge from the last included
    for (v <- 1 until V if isSafe(v, graph, path, pos)) {
      path(pos) = v
      /* recur to construct rest of the path */

      if (hamCycleUtil(graph, path, pos + 1) == true) true
      /* If adding vertex v doesn't lead to a solution,
                   then remove it */

      path(pos) = -1
    }
    /* If no vertex can be added to Hamiltonian Cycle
           constructed so far, then return false */

    false
  }
// Try different vertices as a next candidate in
// Hamiltonian Cycle. We don't try for 0 as we
// Try different vertices as a next candidate in
// Hamiltonian Cycle. We don't try for 0 as we

  /* This function solves the Hamiltonian Cycle problem using
       Backtracking. It mainly uses hamCycleUtil() to solve the
       problem. It returns false if there is no Hamiltonian Cycle
       possible, otherwise return true and prints the path.
       Please note that there may be more than one solutions,
       this function prints one of the feasible solutions. */

  def hamCycle(graph: Array[Array[Int]]): Int = {
    path = Array.ofDim[Int](V)
    (0 to V).withFilter.foreach(i => path(i) = -1)
   // for (i <- 0 until  V) yield (path(i) = -1)
    /* Let us put vertex 0 as the first vertex in the path.
           If there is a Hamiltonian Cycle, then the path can be
           started from any point of the cycle as the graph is
           undirected */

    path(0) = 0
    if (hamCycleUtil(graph, path, 1) == false) {
      println("Solution does not exist")
      0
    }
    printSolution(path)
    1
  }

  /* A utility function to print solution */

  def printSolution(path: Array[Int]): Unit = {
    println("Solution Exists: Following" + " is one Hamiltonian Cycle")
    for (i <- 0 until V) yield  path(i)
// complete cycle
    println(" " + path(0) + " ")
  }
// Let us print the first vertex again to show the
// Let us print the first vertex again to show the

}

