# -*- coding: utf-8 -*-

import os
import sys
import csv
from  numpy import *
from pylab import *

home = "/Users/sasakiumi/MyWorks/cpi-stats"

if __name__ == "__main__":
    train = open(home + '/data/classes.csv', 'rb')
    estimate = open(home + '/data/estimate_cat.csv', 'rb')

    reader = csv.reader(train)
    trainxs1 = []
    trainys1 = []
    trainxs2 = []
    trainys2 = []

    for row in reader:
        if int(row[2]) == 1:
            trainxs1.append(row[0])
            trainys1.append(row[1])
        else:
            trainxs2.append(row[0])
            trainys2.append(row[1])

    trainxs1 = array(trainxs1)
    trainyx1 = array(trainys1)
    trainxs2 = array(trainxs2)
    trainys2 = array(trainys2)

    estxs = []
    estys = []
    estReader = csv.reader(estimate)
    for row in estReader:
        estxs.append(row[0])
        estys.append(row[1])

    estxs = array(estxs)
    estys = array(estys)
        
    
    plot(trainxs1, trainys1, 'bo')
    plot(trainxs2, trainys2, 'ro')
    plot(estxs, estys, 'g-')
    xlim(-2.0, 2.0)   
    ylim(-2.0, 2.0)
    
    show()  
        
