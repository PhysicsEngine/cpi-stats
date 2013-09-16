# -*- coding: utf-8 -*-

import os
import sys
import numpy as np

if __name__ == "__main__":
    for k in range(0, 20):
        xlist = np.linspace(0, 1, 25)
        tlist = np.sin(2*np.pi*xlist) + np.random.normal(0, 0.2, xlist.size)
        f = open("train" + str(k) + ".csv", "w")
        for i in range(0, len(xlist)):
            f.write(str(xlist[i]) + "," + str(tlist[i]) + "\n")

        f.close()
