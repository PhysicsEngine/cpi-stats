# -*- coding: utf-8 -*-

import os
import sys
import csv
from  numpy import *
from pylab import *

if __name__ == "__main__":
    for i in range(0, 19):
        estimate = open('estimate' + str(i) + '.csv', 'rb')
            
        estreader = csv.reader(estimate)
        estxs = []
        estts = []
        for row in estreader:
            estxs.append(row[0])
            estts.append(row[1])
        estxs = array(estxs)
        estts = array(estts)
                
                
#        plot(trainxs, traints, 'bo')
        plot(estxs, estts, 'g-')
        xlim(0.0, 1.0)   
        ylim(-1.5, 1.5)
        estimate.close()
        
    show()  
        
        
