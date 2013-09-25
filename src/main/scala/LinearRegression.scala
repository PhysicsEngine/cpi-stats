package com.PhysicsEngine.cpistats
import breeze.linalg._

class LinearRegression(val M: Int) {
  var _wML = DenseVector.zeros[Double](0)
  def phi(x: DenseVector[Double], i: Int): Double = {
	Math.pow(x(0), i)
  }
  
  def designMatrix(xlist: List[DenseVector[Double]]): DenseMatrix[Double] = {
    val designMatrix = DenseMatrix.zeros[Double](xlist.length, M)
    for (i <- 0 until xlist.length) {
      for (j <- 0 until M) {
        designMatrix(i, j) = phi(xlist(i), j)
      }
    }
    designMatrix
  }
  
  def wML(designMatrix:DenseMatrix[Double], tlist:List[DenseVector[Double]]): DenseVector[Double] = {
    val tVec = DenseVector.zeros[Double](tlist.length)
    for (i <- 0 until tlist.length) tVec(i) = tlist(i)(0)
    inv(designMatrix.t * designMatrix) * designMatrix.t * tVec   
  }
  
  def train(xlist: List[DenseVector[Double]], tlist:List[DenseVector[Double]]): Unit = {
    this._wML = wML(designMatrix(xlist), tlist)
  }
  
  def estimate(x:DenseVector[Double]): Double = {
    val phiVector = DenseVector.zeros[Double](M)
    for (i <- 0 until M) {
      phiVector(i) = phi((x), i)
    }
    (_wML.t * phiVector).apply(0)
  }
}