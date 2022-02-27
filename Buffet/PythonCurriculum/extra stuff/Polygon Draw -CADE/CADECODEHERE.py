# sample graphics program
#
# imports graphics library
#
from graphics import *;
from array import *
from random import randint
import time
#opt=input("Do you want 'poly' or 'click'?:")
opt='poly'
x=0
Win=GraphWin("yawyeet",500,600)
Win.setBackground('black')
for i in range(10):
    v=Line(Point(x+50,0),Point(x+50,500))
    h=Line(Point(0,50+x),Point(500,50+x))
    h.draw(Win)
    v.draw(Win)
    v2=Line(Point(x+25,0),Point(x+25,500))
    h2=Line(Point(0,25+x),Point(500,25+x))
    h2.draw(Win)
    v2.draw(Win)
    h2.setFill('grey')
    v2.setFill('grey')
    h.setFill('white')
    v.setFill('white')
    x=x+50
Greendone=Oval(Point(0,510),Point(250,590))
Greendone.draw(Win)
Greendone.setFill('green1')
done=Text(Greendone.getCenter(),"DONE")
done.draw(Win)
done.setSize(15)
bluedone=Oval(Point(250,510),Point(375,590))
bluedone.draw(Win)
bluedone.setFill('blue')
bdone=Text(bluedone.getCenter(),"NEW")
bdone.draw(Win)
bdone.setSize(15)
reddone=Oval(Point(375,510),Point(500,590))
reddone.draw(Win)
reddone.setFill('red')
rdone=Text(reddone.getCenter(),"EXIT")
rdone.draw(Win)
rdone.setSize(15)
xcoords=[]
ycoords=[]
circles=[]
lines=[]
points=[]


##############################################
if(opt=='poly'):
    while True:
        counter=0
        print('Polygon(',end='')
        while True:
    ##############################################
            Coord=Win.getMouse()
            x=Coord.getX()
            y=Coord.getY()
            if(y>500):
                if(x<250):
                    P=Polygon(points)
                    P.draw(Win)
                    P.setFill('cyan')
                    print(')')
                    for i in range(0,counter):
                        circles[i].undraw()
                    for i in range(0,counter-1):
                        lines[i].undraw()
                    break
            xcoords.append(x)
            ycoords.append(y)
            if(counter>0):
                print(',',end='')
            print("Point("+str(x)+","+str(y)+")",end='')
            C=Circle(Point(x,y),5)
            C.setFill('cyan')
            C.draw(Win)
            circles.append(C)
            if(counter>0):
                L=Line(Point(xcoords[counter-1],ycoords[counter-1]),Point(xcoords[counter],ycoords[counter]))
                L.draw(Win)
                L.setFill('white')
                lines.append(L)
            coord=Point(xcoords[counter],ycoords[counter])
            points.append(coord)
            counter=counter+1
        Coord=Win.getMouse()
        x=Coord.getX()
        y=Coord.getY()
        if(y>500):
            if(x>250):
                if(x<375):
                    P.undraw()
                    del points[:]
                    del xcoords[:]
                    del ycoords[:]
                    del circles[:]
                    del lines[:]
                       
                        
                        
        if(y>500):
            if(x>250):
                if(x>375):
                    Win.close()
                    
##############################################







        
if(opt=='click'):
    switch=1
    ft=0
    while True:
##############################################
        if(switch==1):
            Coord=Win.getMouse()
            x=Coord.getX()
            y=Coord.getY()
            print("Point("+str(x)+","+str(y)+"),",end='')
            c1=Circle(Point(int(x),int(y)),5)
            c1.setFill('cyan')
            c1.draw(Win)
##############################################
            if(ft>0):
                l1=Line(Point(x2,y2),Point(int(x),int(y)))
                l1.draw(Win)
            switch=0
##############################################
        else:
            Coord2=Win.getMouse()
            x2=Coord2.getX()
            y2=Coord2.getY()
            print("Point("+str(x2)+","+str(y2)+"),",end='')
            c2=Circle(Point(int(x2),int(y2)),5)
            c2.setFill('cyan')
            c2.draw(Win)
            l2=Line(Point(int(x),int(y)),Point(x2,y2))
            l2.draw(Win)
            switch=1
##############################################
        ft=ft+1

    
'''   
if(opt=='coords'):
    Winin=GraphWin("type coordinates",250,150)
    box1=Entry(Point(100,75),3)
    box2=Entry(Point(200,75),3)
    box1.draw(Winin)
    box2.draw(Winin)
    s=1
    ft=0
    d=0
    import time 
    while True:
        if(s==1):
            Winin.getMouse()
            x1=box1.getText()
            y1=box2.getText()
            Win.getMouse()
            if(x1==""):
                d=0
            elif(y1==""):
                d=0
            else:
                p1=Circle(Point(int(x1),int(y1)),5)
                p1.setFill('cyan')
                p1.draw(Win)
                if(ft>0):
                    l1=Line(Point(int(x2),int(y2)),Point(int(x1),int(y1)))
                    l1.draw(Win)
                if(Winin.getMouse==True):
                    break
                    s=0
                    print("Point("+str(x1)+","+str(y1)+"),",end='')
        else:
            Winin.getMouse()
            while True:
                x2=box1.getText()
                y2=box2.getText()
                time.sleep(.25)
                if(x1==""):
                    d=0
                elif(y1==""):
                    d=0
                else:
                    p2=Circle(Point(int(x2),int(y2)),5)
                    p2.setFill('cyan')
                    p2.draw(Win)
                    l2=Line(Point(int(x1),int(y1)),Point(int(x2),int(y2)))
                    l2.draw(Win)
                    if(Winin.getMouse):
                        print("Point("+str(x2)+","+str(y2)+"),",end='')
                        s=1
                        ft=ft+1
                        break
            

            Coord=Win.getMouse()
            x=Coord.getX()
            y=Coord.getY()
            print("Point("+str(x)+","+str(y)+"),",end='')
            p1=Circle(Point(int(x),int(y)),5)
            p1.setFill('cyan')
            p1.draw(Win)
            if(ft>0):
                l1=Line(Point(x2,y2),Point(int(x),int(y)))
                l1.draw(Win)
            s=0
        else:
            Coord2=Win.getMouse()
            x2=Coord2.getX()
            y2=Coord2.getY()
            print("Point("+str(x2)+","+str(y2)+"),",end='')
            p2=Circle(Point(int(x2),int(y2)),5)
            p2.setFill('cyan')
            p2.draw(Win)
            l2=Line(Point(int(x),int(y)),Point(x2,y2))
            l2.draw(Win)
            s=1
        ft=ft+1
        '''
        
        
        
    
    


    











    

