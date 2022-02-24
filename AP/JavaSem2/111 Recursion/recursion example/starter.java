class starter {
        public static void main(String args[])
        {
			myMethod(4);
		}
		public static void myMethod(int counter)
		{
			if(counter == 0)
			{
				
			}
			else
			{
				System.out.println(""+counter);
				myMethod(--counter);
				
			}
		}
	}
