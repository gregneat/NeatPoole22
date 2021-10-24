// String examples using String class methods.

class temp {
        public static void main(String args[])
        {
		int pos;

		String bob = new String("I love computers and the beach!");
		System.out.println("The String object is: "+ bob);
		
		System.out.println("The phrase contains " + bob.length() + " characters.");

		pos = bob.indexOf("love");
		if(pos >= 0)
		{
			System.out.println("The first occurrence of the word love is at index: "+ pos);
		}
		else
		{
			System.out.println("The word love does not occur in the phrase.");
		}
	
		System.out.println("Note, the first character in a String is at index 0 not 1.");
		
		pos = bob.indexOf("hate");
		if(pos >= 0)
		{
			System.out.println("The first occurrence of the word hate is at index: "+ pos);
		}
		else
		{
			System.out.println("The word hate does not occur in the phrase.");
		}

		System.out.println("But if I had to choose, I would pick " + bob.substring(21,31));
		
        }
}
