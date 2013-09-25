# -*- coding: utf-8 -*-

import os
import sys
import numpy as np

if __name__ == "__main__":
    N = 500
    xlist = np.linspace(0, 1, N) 
    f = open("test.csv", "w")
    for x in xlist:
        f.write(str(x) + "\n")
    
