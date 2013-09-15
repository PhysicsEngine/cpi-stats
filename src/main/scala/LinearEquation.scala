package com.PhysicsEngine.cpistats
import breeze.linalg._

object LinearEquation {
	val M = 20
	def y(x:Double, wlist:DenseVector[Double]) = {
	  var ret = wlist(0)
	  for( i <- 1 to M) {
	    ret += wlist(i) * Math.pow(x, i)
	  }
	  ret
	}
	
}