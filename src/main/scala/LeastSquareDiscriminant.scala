package com.PhysicsEngine.cpistats
import breeze.linalg._

class LeastSquareDiscriminant(D: Int, K: Int) {
	private var _w = DenseVector.ones[Double](D+1)

	def train(plist: List[DenseVector[Double]]): DenseMatrix[Double] = {
	  val n = plist.length
	  val T = DenseMatrix.zeros[Double](n, K)
	  val X = DenseMatrix.zeros[Double](n, D+1)
	  
	  for (i <- 0 until n) {
	    val x = plist(i)
	    X(i, 0) = 1.0
	    for (j <- 1 until D+1) {
	    	X(i, j) = x(j-1)
	    }
	  }
	  
	  for (i <- 0 until n) {
	    val t = plist(i)
	    if (t(2) > 0.0) {
	      T(i, 0) = 1
	      T(i, 1) = 0
	    } else {
	      T(i, 0) = 0
	      T(i, 1) = 1
	    }
	  }

	  //println(inv(X.t * X) * X.t * T)
	  val W = inv(X.t * X) * X.t * T
	  W.t
	}
}