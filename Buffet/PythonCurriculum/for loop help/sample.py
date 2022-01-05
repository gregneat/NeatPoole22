# imports graphics library
#
from graphics import *;

window = GraphWin("Window", 500,500);

r1 = Rectangle(Point(20,30),Point(30,70));
r1.draw(window);

# waits for the user to click the mouse in the window
window.getMouse();

# closes the window
window.close();

