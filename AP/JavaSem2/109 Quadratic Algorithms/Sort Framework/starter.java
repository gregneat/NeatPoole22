public class starter{
		public static void main(String args[])
        {	
			int[] a = new int[5];
			for(int i=0;i<a.length;i++)
				a[i] = (int)(Math.random()*100);
			Numbers joe = new Numbers(a);
			joe.print();
			joe.sort();
			joe.print();
		}
}