# -*- coding: utf-8 -*-

import os
import sys
import numpy as np
from pylab import *

K = 2
N = 50

if __name__ == "__main__":
    cls1 = []
    cls2 = []
    
    
    mean1 = [-1.2, 1.4]  
    mean2 = [-0.5, 0.5]  
    mean3 = [1.6, -1.4]
    cov = [[0.2,0.1], [0.1,0.1]]  

    cls1.extend(np.random.multivariate_normal(mean1, cov, N/2))
    cls2.extend(np.random.multivariate_normal(mean2, cov, N/2))
    cls2.extend(np.random.multivariate_normal(mean3, cov, N/2))


    f = open("/Users/sasakiumi/MyWorks/cpi-stats/data/classes.csv", "w")
    for i in cls1:
        f.write(str(i[0]) + "," + str(i[1]) + ",1" +  "\n")

    for i in cls2:
        f.write(str(i[0]) + "," + str(i[1]) + ",-1" + "\n")

    f.close()

    t = open("/Users/sasakiumi/MyWorks/cpi-stats/data/test_cat.csv", "w")
    testxs = np.linspace(-2.0, 2.0, 1000)
    for i in testxs:
        t.write(str(i) + "\n")
    t.close()

    x1, x2 = np.transpose(np.array(cls1))
    plot(x1, x2, 'rx')
    
    x1, x2 = np.transpose(np.array(cls2))
    plot(x1, x2, 'bo')

    xlim(-2.0, 2.0)
    ylim(-2.0, 2.0)
    show()


