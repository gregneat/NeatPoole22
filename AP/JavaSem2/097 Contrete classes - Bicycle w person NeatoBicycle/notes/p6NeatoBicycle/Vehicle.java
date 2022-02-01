import pkg.*;
import java.util.ArrayList;

public abstract class Vehicle{
	
	public abstract void translate(double x, double y);
	public abstract void driveRandom();
	public abstract int getX();
	public abstract int getY();
	public abstract void setStep(int x);
	public abstract void draw();
	public abstract int getStep();
	public abstract void fill();
}