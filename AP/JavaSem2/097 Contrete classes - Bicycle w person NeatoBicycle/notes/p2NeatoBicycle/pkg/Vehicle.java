package pkg;
public abstract class Vehicle{
public abstract void translate	(int a, int b);
public abstract int getX();
public abstract int getY();
public abstract int getHeight();
public abstract int getWidth();
public abstract void draw();
public abstract void fill();
public abstract void setColor(Color c);
public abstract void drive();
}
//could get: .translate(2 parameters), getX(), getY(); .draw(), .fill(), .setColor()