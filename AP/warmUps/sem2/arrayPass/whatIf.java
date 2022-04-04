class whatIf {
        public static void main(String args[])
        {
			int[] values = {2, 7, 589, 1717, 3};
			print(values);
			mystery(values);
			print(values);
        }
		public static void print(int[] pm)
		{
			for(int i=0; i< pm.length;i++)
			{
				System.out.print(pm[i] + "  ");
			}
			System.out.println(); 
		}
		public static void mystery(int[] pm)
		{
			for(int i=0; i< pm.length;i++)
			{
				pm[i]=0;
			} 
		}
}

