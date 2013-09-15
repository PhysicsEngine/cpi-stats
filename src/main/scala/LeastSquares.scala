package com.PhysicsEngine.cpistats
import breeze.linalg._

object LeastSquares {
	def estimate(dataList:List[Pair[Double,Double]]) = {
	  val M = 3
	  val dataLength = dataList.length
	  var A = DenseMatrix.zeros[Double](M+1, M+1)
	  var T = DenseVector.zeros[Double](M+1)
	  
	  for(i <- 0 to M) {
	    for( j <- 0 to M) {
	      var temp = 0.0
	      dataList.foreach {
	        dataPair => {
	          temp += Math.pow(dataPair._1, i+j) 
	        }
	      }
	      A(i, j) = temp
	    }
	  }
	  //print(A)
	  
	  for(i <- 0 to M) {
		  var temp = 0.0
		  dataList.foreach {
		    dataPair => {
		    	temp += Math.pow(dataPair._1, i) * dataPair._2
		    }
		  }
		  T(i) = temp
	  }
	  //print(T)
	  
	  val wlist = A \ T
	  wlist
	}
	
	
}