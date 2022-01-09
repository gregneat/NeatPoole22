class starter {

	public static void main(String[] args) {
		/*
		 *	This is a tutorial for using the Expression interface 
		 *	and the classes that use it.
		 *
		 * 	Every one of these classes implements the Expression interface.
		 * 	It's very simple, take a look at it: only three methods to implement.
		 * 	
		 * 	We are going to go through each class and see how to create it
		 * 	As we look at each class, take a look at the source code.
		 * 	Even if you don't understand everything that is going on,
		 * 	it is important that you understand what each method does.
		 * 
		 * 	We will also see how each expression can be used to 
		 * 	contain another expression.
		 * 	This is a very powerful tool that can be used to  
		 * 	create a great variety of expressions.
		 * 
		 */
	
		/*
		 *	First, we are going to create an XVal.
		 *	The most basic constructor takes in the parameters:
		 * 	(double coefficient, double exponent)
		 *	Ignore the constructor with an Expression, we will deal with that later.
		 *
		 */
		//Create an X value 5x^2
		XVal a = new XVal(5,2);
		System.out.println(a);
		
		//What if we want to see what 5x^2 is if we plug in 4?
		// Let's get the value of our XVal a at 4. 5*(4)^2
		double value = a.valueAt(4);
		System.out.println(value);
		
		/*
		 *	Now, let's make a SpecialExpression.
		 *	This is a powerful tool to create complicated functions.
		 *	
		 *	You can surround an existing expression f with:
		 * 	ln(f), e^f, |f|, sin(f), cos(f), tan(f)
		 *
		 *	Take a look at the SpecialExpression.java file.
		 *	As you can see, there are constants that will help you select
		 *	the type of function you are creating.
		 *
		 *	You can even add your own function, if you need to add something 
		 *	that doesn't exist in the original file!
		 *
		 */
		//Create a Special expression ln( x )
		SpecialExpression b = new SpecialExpression(new XVal(1,1),SpecialExpression.LN);
		System.out.println(b);
		
		/*
		 *	Let's make a polynomial now.
		 *	The parameters are any expressions you want to add (any number of them).
		 *	We will fill our polynomial with XVals.
		 *
		 */
		//Create a Polynomial x^2 + 4x^0.5 + 7
		Polynomial c = new Polynomial(new XVal(1,2), new XVal(4,1), new XVal(7,0));
		System.out.println(c);
		
		/*
		 *	Now, we will make a Product.
		 * 	The parameters are any expressions you want to multiply.
		 *	Similar to Polynomials, you can enter any number of expressions.
		 *
		 */
		//Create a Product (5x^2)(ln(x))
		Product d = new Product(a, b);
		System.out.println(d);
		
		/*
		 *	Next, we will make a Quotient.
		 *	This is just a fraction, with expressions as numerators and denominators.
		 * 	The parameters are simply the numerator expression, then the denominator.
		 *	
		 */
		//Create a Quotient (5x^2)(ln(x)) / (x^2 + 4x + 7)
		Quotient e = new Quotient(d,c);
		System.out.println(e);
		
		/*
		 *	SpecialExpressions can also contain larger expressions, like our quotient.
		 *
		 */
		//Create a Special Expression cos( (5x^2)(ln(x))/(x^2+4x+7) )
		SpecialExpression f = new SpecialExpression(e, SpecialExpression.COS);
		
		/*
		 *	XVals can also be used to raise a larger expression to a power.
		 *	In this case, we use the second constructor, with an expression as 
		 * 	the third parameter.
		 * 
		 *	Here we will raise our already large expression to the negative third power.
		 *
		 */
		//Create an Exponent ( cos((5x^2)(ln(x))/(x^2+4x+7)) )^-3 
		//	note: [cos(x)]^-1 == sec(x)
		XVal g = new XVal(1,-3,f);
		System.out.println(g);
		
		/*
		 *	Now if we wanted to find the value of this massive function, at pi, we could.
		 *	It just might be an odd number.
		 *
		 *	(cos((5*pi^2)(ln(pi))/(pi^2+4*pi+7)))^-3 
		 *
		 */
		double num = g.valueAt(Math.PI);
		System.out.println(num);
		
		/*
		 *
		 *	We could also make a limit of this equation as it approaches pi
		 *
		 */
		 
		Limit h = new Limit(g);
		double val = h.valueAt(Math.PI);
		System.out.println(val);
		 
		/*
		 *	That's it for the example!
		 *	If you have any questions, you can read the class files and google what 
		 *	you can't understand (switch/case, @Override, one-line-if statements, etc.)
		 *
		 *	If you want to explore more complicated (and useful) things:
		 *		- Create a method to find the derivative of an expression using
		 *			the limit definiton.
		 *			f'(x) = lim h=>0 [ ((f(a+h)-f(a))/h ] 
		 *				OR
		 *			f'(x) = lim x=>a [ ((f(x)-f(a))/(x-a) ]
		 * 
		 *		- *Bonus* Create a method to find the definite integral of an  
		 *			expression using the limit definition.
		 *  		You might have to make a Summation class that implements expression.
		 *
		 */
		
	}
}