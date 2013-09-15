package com.PhysicsEngine.cpistats
import breeze.linalg._
import scala.io.Source
import java.io._
import com.github.tototoshi.csv._


object App {
  def main(args: Array[String]) {
    //val data = EmployeeData.read()
    val train = DataReader.trainRead("train.csv")
    
    //val data = List[Pair[Double,Double]]((0.07218849, 1.47822651), (1.61854596, 11.57308266), (2.74441742, 23.53791146), (3.36337206, 36.71027063), (4.96067527, 40.60451491), (5.13515737, 58.41530339), ( 6.43154354, 64.22937428), (7.68320999, 79.51190066), (8.3692042, 91.04207353), ( 9.85696038, 97.7546571))
    //val data = List[Pair[Double,Double]]((1.0,1.0),(2.0,2.0),(3.0,3.0))
    
    //val data = List[Pair[Double,Double]]((1.0, Math.sin(1.0)), (2.0, Math.sin(2.0)), (3.0, Math.sin(3.0)))
    val wlist = LeastSquares.estimate(train, 0.0)
    val test = DataReader.testRead("test.csv")
    
    
    val estimate = new PrintWriter("estimate.csv")
   	val sums = DenseMatrix.zeros[Double](BayesEstimation.M+1, BayesEstimation.M+1)
    for(i <- 0 to train.length-1) {
	  sums += BayesEstimation.phi(train(i)._1) * BayesEstimation.phi(train(i)._1).t
	}
	val I = DenseMatrix.eye[Double](BayesEstimation.M+1)
	val S_inv =  I * BayesEstimation.ALPHA + sums * BayesEstimation.BETA
	val S = inv(S_inv)
	
    test.foreach {
      x => {
    	  val m = BayesEstimation.mean(x, train, S)(0)
    	  val s = Math.sqrt(BayesEstimation.variance(x, train, S)(0))
    	  val u = m + s
    	  val l = m - s
    	  estimate.println(x + "," + m + "," + u + "," + l)
      }
    }
    
    /*
    test.foreach {
      x => {
        estimate.println(x + "," + LinearEquation.y(x, wlist))
      }
    }
    * 
    */
	
    estimate.flush()
    estimate.close()
    

  }
}
