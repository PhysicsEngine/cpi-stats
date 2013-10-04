package com.PhysicsEngine.cpistats
import breeze.linalg._
import java.io._
import com.github.tototoshi.csv._

object ClassReader {
  def trainRead(filename:String) = {
	val reader = CSVReader.open(new File(filename))
	var lp = List[DenseVector[Double]]()
				
    reader.foreach {
	  fields =>  {
	    lp = DenseVector(fields(0).toDouble, fields(1).toDouble, fields(2).toDouble) :: lp
	  }
	}
    
    reader.close()
    lp
  }
  
  def testRead(filename: String): List[Double] = {
    var reader = CSVReader.open(new File(filename))
    var lx = List[Double]()
    reader.foreach {
      pointx => {
        lx = pointx(0).toDouble :: lx
      }
    }
    lx
  }
  
}