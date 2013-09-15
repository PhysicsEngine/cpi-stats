package com.PhysicsEngine.cpistats
import breeze.linalg._
import scala.io.Source
import java.io._
import com.github.tototoshi.csv._


object App {
  def main(args: Array[String]) {
    val data = EmployeeData.read()
    
    //val data = List[Pair[Double,Double]]((0.07218849, 1.47822651), (1.61854596, 11.57308266), (2.74441742, 23.53791146), (3.36337206, 36.71027063), (4.96067527, 40.60451491), (5.13515737, 58.41530339), ( 6.43154354, 64.22937428), (7.68320999, 79.51190066), (8.3692042, 91.04207353), ( 9.85696038, 97.7546571))
    //val data = List[Pair[Double,Double]]((1.0,1.0),(2.0,2.0),(3.0,3.0))
    val wlist = LeastSquares.estimate(data)
    print("at 2009: " + LinearEquation.y(2009.0, wlist))
  }
}
