public class Numbers{
	
		private int[] list;
		
		public Numbers(int[] n)
        {	
			list = n;
		}
		public void print()
		{
			for(int x:list)
				System.out.print(x+" ");
			System.out.println();
		}
		public void sort()
		{
			bubble();
		}
		private void bubble()
		{
		  // code for bubble sort
		}
		private void insertion()
		{
			// code for insertion sort	
		}
		private void selection()
		{
			// code for selection sort
		}
		private void nonRecurMerge()
		{
			// code for nonRecurMerge
		}
		
}