package com.PhysicsEngine.cpistats
import java.io._
import com.github.tototoshi.csv._

object EmployeeData {
  def read() = {
	val reader = CSVReader.open(new File("employee.csv"))
	var l = List[Pair[Double, Double]]()
			
    reader.foreach {
	  fields =>  {
	    l =  (fields(1).substring(0,4).toDouble, fields(5).toDouble) :: l
	  }
	}
    
    reader.close()
    l
  }
        
}