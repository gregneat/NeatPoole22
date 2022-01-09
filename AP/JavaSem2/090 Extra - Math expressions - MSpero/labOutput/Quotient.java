import java.util.ArrayList;

public class Quotient implements Expression{

	Expression num, denom;
	
	public Quotient(Expression numerator, Expression denominator) {
		num = numerator;
		denom = denominator;
	}
	
	public Expression getNum() {
		return num;
	}
	
	public Expression getDenom() {
		return denom;
	}
	
	public void setNum(Expression newExpression) {
		num = newExpression;
	}
	
	public void setDenom(Expression newExpression) {
		denom = newExpression;
	}
	
	public double valueAt(double x) {
		double n = num.valueAt(x);
		double d = denom.valueAt(x);
		// if(d==0) throw new ArithmeticException("DIVIDE BY ZERO");
		return n/d;
	}
	
	public Quotient plugInExpression(Expression input) {
		return new Quotient(num.plugInExpression(input), denom.plugInExpression(input));
	}
	
	public Quotient clone() {
		return new Quotient(num.clone(), denom.clone());
	}
	
	
	@Override
	public String toString() {
		return "("+num+")/("+denom+")";
	}
}
