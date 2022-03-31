import java.util.ArrayList;

class starter {
	public static void main(String args[]) {
		
		int[][] patio = new int[5][3];
		for(int i=0; i<patio.length;i++)
		{
			for(int j = 0; j<patio[0].length;j++)
			{
				patio[i][j]=(int)(Math.random()*10);
			}
		}
		// printMat(butt);
	}
	
	public static void printMat(int[][] a)
	{
		
	}
		
}
