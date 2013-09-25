# -*- coding: utf-8 -*-

import os
import sys
import csv
from  numpy import *
from pylab import *

if __name__ == "__main__":
    sumts = []
    sumxs = []
    for j in range(0, 500):
        sumts.append(0)
    
    for i in range(0, 19):
        estimate = open('estimate' + str(i) + '.csv', 'rb')
            
        estreader = csv.reader(estimate)
        estxs = []
        estts = []
        k = 0
        for row in estreader:
            estxs.append(row[0])
            estts.append(row[1])
            if len(sumxs) < 500:
                sumxs.append(row[0])
            sumts[k] = float(row[1]) + sumts[k]
            k += 1
        estxs = array(estxs)
        estts = array(estts)
                
                
#        plot(trainxs, traints, 'bo')
        plot(estxs, estts, 'g-')
        xlim(0.0, 1.0)   
        ylim(-1.5, 1.5)
        estimate.close()

    for i in range(0, 500):
        sumts[i] = sumts[i] / 20

    sumts = array(sumts)
    sumxs = array(sumxs)
    print len(sumts)
    print len(sumxs)
    plot(sumxs, sumts, 'r|')
    show()  
        
        
