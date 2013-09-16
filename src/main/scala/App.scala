package com.PhysicsEngine.cpistats
import breeze.linalg._
import scala.io.Source
import java.io._
import com.github.tototoshi.csv._


object App {
  def main(args: Array[String]) {
    /*
    val train = DataReader.trainRead("train.csv")
    
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
    * 
    */

    for(i <- 0 to 19) {
    	val tfilename = "train" + i + ".csv"
    	val efilename = "estimate" + i + ".csv"
    	val train = DataReader.trainRead(tfilename)
    	val wlist = LeastSquares.estimate(train, 10.0)
    	val test  = DataReader.testRead("test.csv")
    	val estimate = new PrintWriter(efilename)
    
    	test.foreach {
    		x => {
    			estimate.println(x + "," + LinearEquation.y(x, wlist))
    		}
    	}
    	estimate.flush()
    	estimate.close()
    }
    

  }
}
