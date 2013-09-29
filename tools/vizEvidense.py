# -*- coding: utf-8 -*-

import os
import sys
import csv
from  numpy import *
from pylab import *

if __name__ == "__main__":
    evidense = open('../data/evidense.csv', 'rb')

    reader = csv.reader(evidense)
    ms = []
    evidenses = []
    for row in reader:
        ms.append(row[0])
        evidenses.append(row[1])
    ms = array(ms)
    evidense = array(evidenses)


    maxm = array([4.0, 4.0])
    maxevidense = array([-80.0, 0.0])
    print maxm
    print maxevidense

    plot(ms, evidense, 'g-')
    plot(maxm, maxevidense, 'r-')
    xlim(0.0, 100.0)   
    ylim(-80.0, 0.0)
    
    show()  
        
        
