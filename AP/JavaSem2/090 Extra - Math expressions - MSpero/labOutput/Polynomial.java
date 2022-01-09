import java.util.ArrayList;
import java.util.Arrays;

public class Polynomial implements Expression {

	ArrayList<Expression> values;
	
	public Polynomial() {
		values = new ArrayList<Expression>();
	}
	
	public Polynomial(Expression... input)  {
		values = new ArrayList<Expression>(Arrays.asList(input));
	}
	
	//to do: check cast
	@SuppressWarnings("unchecked")
	public Polynomial(ArrayList<Expression> input) {
		values = (ArrayList<Expression>)input.clone();
	}
	
	public void add(Expression x) {
		values.add(x);
	}
	
	public double valueAt(double x) {
		double ans = 0;
		for(Expression v : values) {
			ans += v.valueAt(x);
		}
		return ans;
	}
	
	public Polynomial plugInExpression(Expression input) {
		ArrayList<Expression> output = new ArrayList<Expression>();
		for(Expression v : values) {
			output.add(v.plugInExpression(input));
		}
		return new Polynomial(output);
	}
	
	public Polynomial clone() {
		ArrayList<Expression> expressions = new ArrayList<Expression>();
		for(Expression e : values) {
			expressions.add(e);
		}
		return new Polynomial(expressions);
	}
	
	@Override
	public String toString() {
		String str = "";
		for(Expression x : values) {
			str += x +"+";
		}
		return str.substring(0,str.length()-1);
	}
}
