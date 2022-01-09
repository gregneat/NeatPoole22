public class SpecialExpression implements Expression {

	public static final int NORMAL = 0;
	public static final int LN = 1;
	public static final int E_TO_THE = 2;
	public static final int ABS = 3;
	public static final int SIN = 4;
	public static final int COS = 5;
	public static final int TAN = 6;
	
	private int type;
	private Expression expression;
	
	public SpecialExpression(Expression ex, int specialType) {
		expression = ex;
		type = specialType;
	}
	
	public void setType(int specialType) {
		type = specialType;
	}
	
	@Override
	public double valueAt(double input) {
		double origVal = expression.valueAt(input);
		switch(type) {
			case 0: 
				return origVal;
			case 1: 
				return Math.log(origVal);
			case 2:
				return Math.exp(origVal);
			case 3:
				return Math.abs(origVal);
			case 4:
				return Math.sin(origVal);
			case 5:
				return Math.cos(origVal);
			case 6:
				return Math.tan(origVal);
			default:
				return origVal;
		}
	}
	
	public SpecialExpression plugInExpression(Expression input) {
		return new SpecialExpression(expression.plugInExpression(input),type);
	}
	
	public SpecialExpression clone() {
		return new SpecialExpression(expression.clone(),type);
	}
	
	@Override
	public String toString() {
		String origStr = expression.toString();
		switch(type) {
			case 0:
				return origStr;
			case 1:
				return "ln("+origStr+")";
			case 2:
				return "e^("+origStr+")";
			case 3: 
				return "|"+origStr+"|";
			case 4:
				return "sin("+origStr+")";
			case 5:
				return "cos("+origStr+")";
			case 6:
				return "tan("+origStr+")";
			default:
				return origStr;
		}
	}

}