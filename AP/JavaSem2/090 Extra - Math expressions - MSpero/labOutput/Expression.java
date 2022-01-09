public interface Expression {
	public double valueAt(double x);
	public Expression plugInExpression(Expression e);
	public Expression clone();
}