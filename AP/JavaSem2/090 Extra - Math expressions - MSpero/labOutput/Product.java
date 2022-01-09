import java.util.ArrayList;

public class Product implements Expression{

	ArrayList<Expression> values;
	
	public Product() {
		values = new ArrayList<Expression>();
	}
	
	public Product(Expression... input) {
		this();
		for(int i = 0; i < input.length; i++) {
			values.add(input[i]);
		}
	}
	
	//to do: check warnings
	@SuppressWarnings("unchecked")
	public Product(ArrayList<Expression> input) {
		values = (ArrayList<Expression>)input.clone();
	}
	
	public void add(Expression e) {
		values.add(e);
	}
	
	public double valueAt(double x) {
		double output = 1;
		for(Expression v : values) {
			output *= v.valueAt(x);
		}
		return output;
	}
	
	public Product plugInExpression(Expression input) {
		ArrayList<Expression> output = new ArrayList<Expression>();
		for(Expression v : values) {
			output.add(v.plugInExpression(input));
		}
		return new Product(output);
	}
	
	public Product clone() {
		ArrayList<Expression> expressions = new ArrayList<Expression>();
		for(Expression e : values) {
			expressions.add(e);
		}
		return new Product(expressions);
	}
	
	@Override
	public String toString() {
		String output = "";
		for(Expression v : values) {
			output += "("+v+")";
		}
		return output;
	}
}
