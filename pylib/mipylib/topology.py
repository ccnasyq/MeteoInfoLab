# coding=utf-8
#-----------------------------------------------------
# Author: Yaqiang Wang
# Date: 2014-12-26
# Purpose: MeteoInfoLab topology module
# Note: Jython
#-----------------------------------------------------

from org.meteoinfo.data import ArrayUtil
from org.meteoinfo.shape import Graphic
            
def asshape(a):
    if isinstance(a, Graphic):
        return a.getShape()
    else:
        return a
        
def intersect(a, b):
    ap = asshape(a)
    bp = asshape(b)
    cp = ap.intersection(bp)
    c = Graphic(cp, a.getLegend())
    return c
    
def union(a, b):
    ap = asshape(a)
    bp = asshape(b)
    cp = ap.union(bp)
    c = Graphic(cp, a.getLegend())
    return c 
    
def difference(a, b):
    ap = asshape(a)
    bp = asshape(b)
    cp = ap.difference(bp)
    c = Graphic(cp, a.getLegend())
    return c
    
def symdifference(a, b):
    ap = asshape(a)
    bp = asshape(b)
    cp = ap.symDifference(bp)
    c = Graphic(cp, a.getLegend())
    return c
    
def buffer(a, dis):
    ap = asshape(a)
    cp = ap.buffer(dis)
    c = Graphic(cp, a.getLegend())
    return c
    
def convexhull(*args):
    if len(args) == 1:
        a = args[0]
        ap = asshape(a)
        cp = ap.convexHull()
        c = Graphic(cp, a.getLegend())
        return c
    else:
        x = args[0]
        y = args[1]
        r = ArrayUtil.convexHull(x.asarray(), y.asarray())
        return r
    
def split(a, b):
    ap = asshape(a)
    bp = asshape(b)
    cps = ap.split(bp)
    r = []
    for cp in cps:
        r.append(Graphic(cp, a.getLegend()))
    return r