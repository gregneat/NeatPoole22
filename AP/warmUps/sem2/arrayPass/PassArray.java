

public class PassArray
{
	private int[] inside;
	
	public PassArray(int[] a)
	{
                inside = a;
	/*	inside = new int[a.length]; 
   		for(int i=0; i< a.length;i++)
		{
			inside[i]=a[i];
		} */
	     	inside[0] = 589;
	}
	
	public void showArray()
	{
		for(int i=0; i< inside.length;i++)
		{
			System.out.print(inside[i] + ", ");
		}
		System.out.println();
	}
}
		