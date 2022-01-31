import pkg.*;
// package pkg;
public abstract class Vehicle{
	public abstract void draw();
	public abstract void fill();
	public abstract void setStep(int x);
	public abstract void translate(double x, double y);
	public abstract double getX();
	public abstract double getY();
	public abstract void driveRandom();
	public abstract void setColor(Color c);
}