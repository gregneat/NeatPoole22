public class XVal implements Expression {

	private double coef;
	private double exp;
	private Expression ex;
	
	public XVal(double coefficient, double exponent) {
		coef = coefficient;
		exp = exponent;
		ex = null;
	}
	
	public XVal(double coefficient, double exponent, Expression x) {
		coef = coefficient;
		exp = exponent;
		ex = x;
	}
	
	public void setCoef(double coefficient) {
		coef = coefficient;
	}
	
	public void setExp(double exponent) {
		exp = exponent;
	}
	
	public double getCoef() {
		return coef;
	}
	
	public double getExp() {
		return exp;
	}
	
	
	public double valueAt(double input) {
		if(ex == null) {
			return coef * Math.pow(input, getExp());
		}
		else {
			return coef * Math.pow(ex.valueAt(input),exp);
		}
	}
	
	public XVal plugInExpression(Expression input) {
		if(ex == null) {
			return new XVal(coef, exp, input);
		}
		else {
			return new XVal(coef, exp, ex.plugInExpression(input));
		}
	}
	
	public XVal clone() {
		return new XVal(coef, exp, ex);
	}
	
	@Override
	public String toString() {
		String x = ex==null ? "x" : "("+ex.toString()+")";
		String coefstr;
		String expstr;
		if ((coef == 1 || coef == 0) && exp != 0)
			coefstr = "";
		else if(coef%1 == 0)
			coefstr = "" + (int)coef;
		else
			coefstr = "" + coef;
		if (exp == 1)
			expstr = x;
		else if (exp == 0)
			expstr = "";
		else if(exp%1 == 0 ) {
			expstr = x + "^" + (int)exp;
		}
		else
			expstr = x + "^" + exp;
		return coefstr + expstr;
	}

}