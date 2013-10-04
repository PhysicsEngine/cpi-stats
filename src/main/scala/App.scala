package com.PhysicsEngine.cpistats
import breeze.linalg._
import scala.io.Source
import java.io._
import com.github.tototoshi.csv._


object App {
  def main(args: Array[String]) {
    var classData = ClassReader.trainRead("./data/classes.csv")
    var testData = ClassReader.testRead("./data/test_cat.csv")
        
    val ld = new LinearDiscriminant(2)
    val w = ld.train(classData)
    println(w)
    
    val a = -w(1)/w(2)
    val b = -w(0)/w(2)
    var estimate_cat = new PrintWriter("./data/estimate_cat.csv")
    testData.foreach {
      x => {
    	  val y = a * x + b
    	  estimate_cat.println(x + "," + y)
      }
    }
    estimate_cat.flush()
    estimate_cat.close()

    
    /*
     * Bayes estimation
    val trainData = DataReader.trainRead("./data/train0.csv")
    val tmpX = trainData._1
    val tmpT = trainData._2
    
    var xlist = List[DenseVector[Double]]()
    var tlist = List[DenseVector[Double]]()
    
    for (i <- 0 until tmpX.length) {
      xlist = DenseVector(tmpX(i)) :: xlist
      tlist = DenseVector(tmpT(i)) :: tlist
    }
    
    val testData  = DataReader.testRead("./data/test.csv")
        
    val bayesRegression = new BayesRegression(100, 0.0001, 15.0)
    bayesRegression.train(xlist, tlist)
    
    val eFile = new PrintWriter("./data/estimate_lr.csv")
    testData.foreach {
      x => {
        val xVec = DenseVector(x)
        val result = bayesRegression.estimate(xVec)
        val up     = result._1 + Math.sqrt(result._2)
        val below  = result._1 - Math.sqrt(result._2)
        eFile.println(x + "," + result._1 + "," + up + "," + below )
      }
    }
    eFile.flush()
    eFile.close()
    
    val evidenseFile = new PrintWriter("./data/evidense.csv")
    for (i <- 2 until 100) {
      val bayesRegression = new BayesRegression(i, 0.0001, 15.0)
      bayesRegression.train(xlist, tlist)
      val evidense = bayesRegression.evidence(xlist, tlist)
      evidenseFile.println(i + "," + evidense)
    }
    evidenseFile.flush()
    evidenseFile.close()
    * 
    */
    
    
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
    for(i <- 0 to 19) {
    	val tfilename = "train" + i + ".csv"
    	val efilename = "estimate" + i + ".csv"
    	val train = DataReader.trainRead(tfilename)
    	val wlist = LeastSquares.estimate(train, 0.000000001)
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
    * 
    */
    

  }
}
