public class Chessy 
{
	private int[][] mat;
	private int numMove;
	private static int[] ex = {-2, -1, 1, 2, 2, 1, -1, -2};
	private static int[] why = {-1, -2, -2, -1, 1, 2, 2, 1};
	private int presRow;
	private int presCol;
	
        public Chessy()
        {
			
			mat = new int[8][8];
			for(int i=0; i<mat.length;i++)
			{
				for(int j=0; j<mat[0].length;j++)
				{
					mat[i][j] = 0;
				}
			}
			numMove =0;
			presRow = (int)(Math.random()*8);
			presCol = (int)(Math.random()*8);
			while(!isValidMove(presRow,presCol))
			{
				presRow = (int)(Math.random()*8);
				presCol = (int)(Math.random()*8);
			}
			numMove++;
			mat[presRow][presCol] = numMove;
        }
		private boolean isValidMove(int xx, int yy)
		{
			if(xx > 7 || xx < 0 || yy > 7 || yy < 0)
			{
				return false;
			}
			if(mat[xx][yy] != 0)
			{
				return false;
			}
			return true;
		}
		public int play()
		{
			int tempEx;
			int tempWhy;
			int moveCounter = 0;
			
			while(moveCounter < 8)
			{
				tempEx = presRow + ex[moveCounter];
				tempWhy = presCol + why[moveCounter];
				if(isValidMove(tempEx, tempWhy))
				{
					makeMove(moveCounter);
					moveCounter = 0;
				}
				else
				{
					moveCounter++;
				}
			}
			return numMove;
		}
		private void makeMove(int m)
		{
		    presRow = presRow+ex[m];
			presCol = presCol+why[m];
			numMove++;
			mat[presRow][presCol] = numMove;
		}
		public String toString()
		{
			String temp = "";
			for(int r =0; r<mat.length;r++)
			{
				for(int c=0; c<mat[0].length;c++)
				{
					temp = temp + "\t" + mat[r][c];
				}
				temp = temp + "\n";
			}
			
			return temp;
		}
}
