package com.PhysicsEngine.cpistats
import breeze.linalg._

object BayesEstimation {
	val M = 20
	val BETA = 11.1
	val ALPHA = 0.005
	def estimate(dataList:List[Pair[Double,Double]]) = {
		val sums = DenseMatrix.zeros[Double](M+1, M+1)
		for(i <- 0 to dataList.length) {
		  sums += phi(dataList(i)._1) * phi(dataList(i)._1).t
		}
		val I = DenseMatrix.eye[Double](M+1)
		val S_inv =  I :* ALPHA + sums :* BETA
		val S = inv(S_inv)
	}
	
	def phi(x:Double) = {
	  var T = DenseVector.zeros[Double](M+1)
	  for(i <- 0 to M) {
	    T(i) = Math.pow(x, i) 
	  }
	  T
	}
	
	def mean(x:Double, dataList:List[Pair[Double, Double]], S:DenseMatrix[Double]) = {
	  val sums = DenseVector.zeros[Double](M+1)
	  for(i <- 0 to dataList.length-1) {
	    sums += phi(dataList(i)._1) :* dataList(i)._2
	  }
	  BETA * phi(x).t * S * sums
	}
	
	def variance(x:Double, dataList:List[Pair[Double, Double]], S:DenseMatrix[Double]) = {
	  phi(x).t * S * phi(x) + (1.0 / BETA)
	}
}