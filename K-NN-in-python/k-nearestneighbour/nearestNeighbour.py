import operator
import random
import matplotlib.pyplot as plt


def calculateDistance(x1, y1, x, y):
    distance = (((x1 - x) ** 2) + ((y1 - y) ** 2)) ** .5
    return distance


def grpPlot(points, grp, k):
    near = [] #storing values of co-ordinates thier distance and thier group
    near1 = []#storing values of co-ordinates
    (x1, y1) = points[0]
    for x, y in points[1:]:
        dist = calculateDistance(x1, y1, x, y)
        near.append((x,y,dist,grp))
    near.sort(key=operator.itemgetter(2))
    for x,y,w,z in near:
        near1.append((x,y))
    near1.append((x1,y1))
    near = near[0:k]
    plt.scatter(*zip(*near1))#plotting the points of groups
    near.append((x1, y1,0,grp))
    print(near1)
    print(near)
    return near


def locate(loc, k):
    useLess = []
    i = 0
    loc1 = loc
    while loc1:
        for x, y in loc:
            print(loc1)
            useLess = grpPlot(loc1, i, k)
            for m, n, o, p in useLess:
                del loc1[loc1.index((m, n))]
                if len(loc1) < k:
                    return
            i = i+1

    return

rangeX = (0,1000)
rangeY = (1500,2500)
rangeX1 = (1500,2500)
rangeY1 = (0,1000)
i = 0
loc=[]
while i is not 51:
    x = random.randrange(*rangeX)
    y = random.randrange(*rangeY)
    loc.append((x,y))
    i=i+1
i = 0
while i is not 50:
    x = random.randrange(*rangeX1)
    y = random.randrange(*rangeY1)
    loc.append((x,y))
    i=i+1

loc1 = loc
k = int(input('Enter k of nearest neighbour'))
locate(loc, k)
plt.show()
