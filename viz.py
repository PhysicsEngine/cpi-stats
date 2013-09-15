# -*- coding: utf-8 -*-

import os
import sys
import csv
from  numpy import *
from pylab import *

if __name__ == "__main__":
    train = open('train.csv', 'rb')
    estimate = open('estimate.csv', 'rb')

    reader = csv.reader(train)
    trainxs = []
    traints = []
    for row in reader:
        trainxs.append(row[0])
        traints.append(row[1])
    trainxs = array(trainxs)
    traintx = array(traints)

    estreader = csv.reader(estimate)
    estxs = []
    estts = []
    for row in estreader:
        estxs.append(row[0])
        estts.append(row[1])
    estxs = array(estxs)
    estts = array(estts)

    
    plot(trainxs, traints, 'bo')
    plot(estxs, estts, 'g-')
    xlim(0.0, 1.0)   
    ylim(-1.5, 1.5)
    
    show()  
        
        
