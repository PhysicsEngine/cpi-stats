package com.PhysicsEngine.cpistats
import java.io._
import com.github.tototoshi.csv._


object DataReader {
  def trainRead(filename:String) = {
	val reader = CSVReader.open(new File(filename))
	var lx = List[Double]()
	var lt = List[Double]()
			
    reader.foreach {
	  fields =>  {
	    lx = fields(0).toDouble :: lx
	    lt = fields(1).toDouble :: lt
	    //l =  (fields(0).toDouble, fields(1).toDouble) :: l
	  }
	}
    
    reader.close()
    (lx, lt)
  }
  
  def testRead(filename:String) = {
    val reader = CSVReader.open(new File(filename))
    var l = List[Double]()
    
    reader.foreach {
      fields => {
        l = fields(0).toDouble :: l
      }
    }
    reader.close()
    
    l
  }
}

