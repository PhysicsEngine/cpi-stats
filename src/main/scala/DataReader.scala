package com.PhysicsEngine.cpistats
import java.io._
import com.github.tototoshi.csv._


object DataReader {
  def trainRead(filename:String) = {
	val reader = CSVReader.open(new File(filename))
	var l = List[Pair[Double, Double]]()
			
    reader.foreach {
	  fields =>  {
	    l =  (fields(0).toDouble, fields(1).toDouble) :: l
	  }
	}
    
    reader.close()
    l
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

