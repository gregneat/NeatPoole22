import java.awt.*;
import java.util.ArrayList;

public class temp {
        public static void main(String args[])
        {
 		int[] sam = new int[5];
		sam[0]= 4;
		sam[1]= 2;
		sam[2]= 1;
		sam[3]= 5;
		sam[4]= 3;
		printIt(sam);
		quickSort(sam,0,sam.length-1);
		System.out.println();
		printIt(sam);				
        }

	  public static void printIt(int[] l)
	  {
		for(int i=0; i< l.length; i++)
		{
			System.out.print(l[i]+ " ");
		}
	  }

	public static void quickSort (int[] list, int first, int last)
	{
  		int g = first, h = last;

  		int midIndex = (first + last) / 2;
  		int dividingValue = list[midIndex];
  		do
  		{	
    			while (list[g] < dividingValue)
      			g++;
    			while (list[h] > dividingValue)
      			h--;
    			if (g <= h)
    			{
      				//swap(list[g], list[h]);
      				int temp = list[g];
      				list[g] = list[h];
      				list[h] = temp;
      				g++;
      				h--;
    			}
  		}
  		while (g < h);

  		if (h > first)
    			quickSort (list,first,h);
  		if (g < last)
    			quickSort (list,g,last);
	}

}

