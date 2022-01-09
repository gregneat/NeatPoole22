class starter {

	public static void main(String[] args) {
	
		/*
		 *
		 * CHANGES: 
		 * 		Quotient:
		 * 			- No longer returns an error when dividing by zero
		 * 			- Instead returns +Infinity, -Infinity, or NaN (not a number <= 0/0 inf/inf, etc)
		 *		Limit:
		 *			- Actually works for expressions undefined at that point
		 *			- Limit to +/- Infinity also works too
		 *
		 *		Starter:
		 *			- Limit example (this is what I used to test my code)
		 *
		 *		Note: 
		 *			Saying Limit a = new Limit(new Quotient(etc));
		 *			is the same thing as
		 *			Quotient q = new Quotient(etc);
		 *			Limit a = new Limit(q);
		 *
		 */ 
	
		// example in notes
		
		XVal A = new XVal(5,2);

		Polynomial c = new Polynomial(A, new XVal(3,1), new XVal(1,0));
		
		System.out.println(c.valueAt(2));

		//  3x^2/x^2 to 0 = 3
		// Limit a = new Limit(new Quotient(new XVal(3,2),new XVal(1,2)));
		// System.out.println(a.valueAt(0));
		
		// sin(x)/x to 0 = 1
		// Limit b = new Limit(new Quotient(new SpecialExpression(new XVal(1,1),SpecialExpression.SIN),new XVal(1,1)));
		// System.out.println(b.valueAt(0));
		
		// 1/x to 0 = DOES NOT EXIST
		// Limit cc = new Limit(new Quotient(new XVal(1,0),new XVal(1,1)));
		// System.out.println(c.valueAt(0)); RETURNS AN ERROR 
		
		// 1/x^2 to 0 = Infinity
		// Limit d = new Limit(new Quotient(new XVal(1,0),new XVal(1,2)));
		// System.out.println(d.valueAt(0));
		
		// 1/x to Infinity = 0 (in c already);
		// System.out.println(c.valueAt(Double.NEGATIVE_INFINITY));
		
		// cos(x)/x +3 to infinity = 3
		// Limit e = new Limit(new Polynomial(new Quotient(new SpecialExpression(new XVal(1,1),SpecialExpression.COS),new XVal(1,1)),new XVal(3,0)));
		// System.out.println(e.valueAt(Double.POSITIVE_INFINITY));
		
		
	}
}