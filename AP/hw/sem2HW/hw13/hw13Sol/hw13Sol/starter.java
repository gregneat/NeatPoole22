import java.util.ArrayList;

public class starter {
	
	public static void main(String args[]) {
		
		int[][] patio = new int[5][3];
		int c = 11;
		for(int i=0; i<patio.length;i++)
		{
			for(int j = 0; j<patio[0].length;j++)
			{
				patio[i][j]=c;
				c++;
			}
		}
		printMat(patio);
		System.out.println(findPosition(18, patio));
		// System.out.println(findMin(patio));
		Position[][] answer = getSuccessorArray(patio);
		printPosMat(answer);
	}

	
	public static void printMat(int[][] a)
	{
		for(int[] aRow: a)
		{
			for(int b: aRow)
			{
				System.out.print(b+ " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void printPosMat(Position[][] aPos)
	{
		for(Position[] bb: aPos)
		{
			for(Position ccc: bb)
			{
				System.out.print(ccc+ " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	public static int findMin(int[][] intArr)
	{
		int min = 0;
		for(int rr=0; rr < intArr.length; rr++)
		{
			for(int cc = 0; cc < intArr[0].length; cc++)
			{
				if(intArr[rr][cc] > min)
				{
					min = intArr[rr][cc];
				}
			}
		}
		return min;
	}
	public static Position findPosition(int num, int[][] arrMat)
	{
		for(int rr = 0; rr < arrMat.length; rr++)
		{
			for(int cc = 0; cc < arrMat[0].length; cc++)
			{
				if(num == arrMat[rr][cc])
				{
					return new Position(rr,cc);
				}
			}
		}
		return null;
	}
		public static Position[][] 	getSuccessorArray(int[][] arrMat)
		{
			int c = 1;
			int fm = findMin(arrMat);
			Position[][] sa = new Position[arrMat.length][arrMat[0].length];
			
			for(int rr = 0; rr < arrMat.length; rr++)
			{
				for(int cc = 0; cc < arrMat[0].length; cc++)
				{
					if(arrMat[rr][cc] == fm)
					{ 
						sa[rr][cc] = null;
						return sa;
					}
					sa[rr][cc] = findPosition(arrMat[rr][cc]+1,arrMat);
					// c++;
				}
			}
			return sa;
		}
}
