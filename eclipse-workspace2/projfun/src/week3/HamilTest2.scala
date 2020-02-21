import java.util.Scanner

import java.util.Arrays

import HamiltonianCycle._
import scala.jdk.CollectionConverters._
import scala.io.Source
import java.io._
import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.Set

object HamiltonianCycle {

  /**
 Main function *
    */
  def main(args: Array[String]): Unit = {
    val scan: Scanner = new Scanner(System.in)
    println("HamiltonianCycle Algorithm Test\n")

    /**
 Make an object of HamiltonianCycle class *
      */
    val hc: HamiltonianCycle = new HamiltonianCycle()

    /**
 Accept number of vertices *
      */
    println("Enter number of vertices\n")
    val V: Int = scan.nextInt()

    /**
 get graph *
      */
println("\nEnter matrix\n")
    val graph: Array[Array[Int]] = Array.ofDim[Int](V, V)
    for (i <- 0 until V; j <- 0 until V) graph(i)(j) = scan.nextInt()
    hc.findHamiltonianCycle(graph)
  }

}

/**
 Class HamiltonianCycle *
  */
class HamiltonianCycle {

  private var V: Int = _

  private var pathCount: Int = _

  private var path: Array[Int] = _

  private var graph: Array[Array[Int]] = _

  /**
 Function to find cycle *
    */
  def findHamiltonianCycle(g: Array[Array[Int]]): Unit = {
    V = g.length
    path = Array.ofDim[Int](V)
    Arrays.fill(path, -1)
    graph = g
    try {
      path(0) = 0
pathCount = 1
      solve(0)
      println("No solution")
    } catch {
      case e: Exception => {
        println(e.getMessage)
        display()
      }

    }
  }

  /**
 function to find paths recursively *
    */
  def solve(vertex: Int): Unit = {

    /**
 solution *
      */
    if (graph(vertex)(0) == 1 && pathCount == V)
      throw new Exception("Solution found")

    /**
 all vertices selected but last vertex not linked to 0 *
      */
    if (pathCount == V) return
    for (v <- 0 until V if graph(vertex)(v) == 1) {

      /**
 add to path *
        */
path({ pathCount += 1; pathCount - 1 }) = v

      /**
 remove connection *
        */
      graph(vertex)(v) = 0
      graph(v)(vertex) = 0

      /**
 if vertex not already selected  solve recursively *
        */
      if (!isPresent(v)) solve(v)

      /**
 restore connection *
        */
      graph(vertex)(v) = 1
      graph(v)(vertex) = 1

      /**
 remove path *
        */
      path() = -1
    }
  }

  /**
 function to check if path is already selected *
    */
  def isPresent(v: Int): Boolean =
    (0 until pathCount - 1).find(path(_) == v).map(_ => true).getOrElse(false)
/**
 display solution *
    */
  def display(): Unit = {
    System.out.print("\nPath : ")
    var i: Int = 0
    while (i <= V) { System.out.print(path(i % V) + " ") { i += 1; i - 1 } }
    println()
  }

}
