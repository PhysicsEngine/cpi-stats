package com.PhysicsEngine.cpistats
import breeze.linalg._
import java.io._

class LinearDiscriminant(val D: Int) {
	private var _w = DenseVector.ones[Double](D+1)
	_w = _w * -5.0
	private var _eta = 0.5
	def train(plist: List[DenseVector[Double]]): DenseVector[Double] = {
	  var correct = 0
	  var step = 0
	  while (correct < plist.length) {
	    step += 1
	    correct = 0

	    /*
	    val index = Math.floor(Math.random()*plist.length).toInt
	    val point = plist(index)
	    val phi = DenseVector(1.0, point(0), point(1))
        if ((_w.t * phi).apply(0) * point(2) < 0) {
     	   _w += phi * point(2) * _eta
	    }
	    * 
	    */


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
	    /*
	    plist.foreach {
	      point => {
	        val phi = DenseVector(1, point(0), point(1))
	          if ((_w.t * phi).apply(0) * point(2) < 0) {
	        	_w += phi * point(2) * _eta
	          }
	          else {
	        	correct += 1
	          }
	      }
	    }
	    * 
	    */
	  }
	  println(step)
	  _w
	}
}