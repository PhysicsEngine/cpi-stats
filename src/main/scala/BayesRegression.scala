package com.PhysicsEngine.cpistats
import breeze.linalg._

class BayesRegression(M: Int, Alpha: Double, Beta: Double) {
  var _mN  = DenseVector.zeros[Double](M)
  var _sN  = DenseMatrix.zeros[Double](M, M)
  
  private def phi(x: DenseVector[Double], i: Int): Double = {
	Math.pow(x(0), i)
  }
  
  private def designMatrix(xlist: List[DenseVector[Double]]): DenseMatrix[Double] = {
    val designMatrix = DenseMatrix.zeros[Double](xlist.length, M)
    for (i <- 0 until xlist.length) {
      for (j <- 0 until M) {
        designMatrix(i, j) = phi(xlist(i), j)
      }
    }
    designMatrix
  }
  
  def sN(xlist: List[DenseVector[Double]]): DenseMatrix[Double] = {
    val _designMatrix = designMatrix(xlist)
    inv(Alpha * DenseMatrix.eye[Double](M) + Beta * _designMatrix.t * _designMatrix)
  }
  
  def mN(sN: DenseMatrix[Double], xlist: List[DenseVector[Double]], tlist: List[DenseVector[Double]]) = {
    val tVec = DenseVector.zeros[Double](tlist.length)
    for (i <- 0 until tlist.length) tVec(i) = tlist(i)(0)
    Beta * sN * designMatrix(xlist).t * tVec
  }
  
  def train(xlist: List[DenseVector[Double]], tlist:List[DenseVector[Double]]): Unit = {
    _sN = sN(xlist)
    _mN = mN(_sN, xlist, tlist)
  }
  
  def estimate(x:DenseVector[Double]): Pair[Double, Double] = {
    val phiVector = DenseVector.zeros[Double](M)
    for (i <- 0 until M) {
      phiVector(i) = phi((x), i)
    }
    val mean = (_mN.t * phiVector).apply(0)
    val sigma = (1 / Beta) + (phiVector.t * _sN * phiVector).apply(0)
    (mean, sigma)
  }

}