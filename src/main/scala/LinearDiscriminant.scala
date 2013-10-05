package com.PhysicsEngine.cpistats
import breeze.linalg._
import java.io._

class LinearDiscriminant(val D: Int) {
	private var _w = DenseVector.ones[Double](D+1)
	private var _eta = 0.5
	def train(plist: List[DenseVector[Double]]): DenseVector[Double] = {
	  var correct = 0
	  var step = 0
	  while (correct < plist.length) {
	    step += 1
	    correct = 0

	    plist.foreach {
	      point => {
	       val phi = DenseVector(1.0, point(0), point(1))
	       if ((_w.t * phi).apply(0) * point(2) < 0) {
	    	   _w += phi * point(2) * _eta
	       }
	      }
	    }
	    
	    plist.foreach {
	      point => {
	       val phi = DenseVector(1.0, point(0), point(1))
	       if ((_w.t * phi).apply(0) * point(2) >= 0) {
	       	 correct += 1
	       }
	      }
	    }
	  }
	  println("Step: " + step)
	  _w
	}
}