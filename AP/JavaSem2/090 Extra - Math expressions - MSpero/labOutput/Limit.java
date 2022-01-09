public class Limit implements Expression{

	Expression eq;

	public Limit( Expression expression ) {
		eq = expression;
	}
	
	public double valueAt(double xApproaches) {
		if(xApproaches == Double.POSITIVE_INFINITY) {
			return valueAtPosInf();
		}
		if(xApproaches == Double.NEGATIVE_INFINITY) {
			return valueAtNegInf();
		}
		double ans1 = -100;
		int c = 0;
		for(double i = xApproaches + 0.1; i > xApproaches; i = xApproaches + ((i - xApproaches)/2)) {
			try {
				if(ans1 == eq.valueAt(i)) {
					break;
				}
				else {
					c++;
					ans1 = eq.valueAt(i);
				}
			}
			catch(ArithmeticException e) {
				break;
			}
		}
		double ans2 = 100;
		int d = 0;
		for(double i = xApproaches - 0.1; i < xApproaches; i = xApproaches - ((xApproaches - i)/2)) {
			try {
				if(ans2 == eq.valueAt(i)) {
					break;
				}
				else {
					d++;
					ans2 = eq.valueAt(i);
				}
			}
			catch(ArithmeticException e) {
				break;
			}
		}
		double finalAns = (ans1+ans2)/2;
		if(c == 0 || d == 0 || Math.abs(ans1 - ans2) > 1) {
			throw new ArithmeticException("LIMIT DOES NOT EXIST");
		}
		return finalAns;
	}
	
	private double valueAtPosInf() {
		double ans = 0;
		for(double val = 10000; val < Double.MAX_VALUE; val *= 10) {
			if(ans == eq.valueAt(val)) {
				return ans;
			}
			else {
				ans = eq.valueAt(val);
			}
		}
		if(ans > 100000) {
			return Double.POSITIVE_INFINITY;
		}
		else if(ans < -100000) {
			return Double.NEGATIVE_INFINITY;
		}
		else if(ans < 0.001 && ans > -0.001) {
			return 0;
		}
		else {
			return ans;
		}
	}
	
	private double valueAtNegInf() {
		double ans = 0;
		for(double val = -10000; val < -Double.MAX_VALUE; val *= 10) {
			if(ans == eq.valueAt(val)) {
				return ans;
			}
			else {
				ans = eq.valueAt(val);
			}
		}
		if(ans > 100000) {
			return Double.POSITIVE_INFINITY;
		}
		else if(ans < -100000) {
			return Double.NEGATIVE_INFINITY;
		}
		else if(ans < 0.001 && ans > -0.001) {
			return 0;
		}
		else {
			return ans;
		}
	}
	
	public Expression plugInExpression(Expression e) {
		return new Limit(eq.plugInExpression(e));
	}
	public Expression clone() {
		return new Limit(eq.clone());
	}
}