import java.util.*;
public class Sudoku 
{
	public static int[][] puzz = new int[9][9];
	public static boolean[][] row = new boolean[9][10];
	public static boolean[][] col = new boolean[9][10];
	public static boolean[][] box = new boolean[9][10];
	public static boolean solved;
	public static boolean check(int num, int x, int y)
	{
		return (!row[x ][num] && !col[y][num] && !box[(x/3*3)+(y/3)][num]);
		
	}
	public static void put(int i, int x, int y)
	{
		puzz[x][y] = i;
		row[x][i] = true;
		col[y][i] = true;
		box[(x/3*3)+(y/3)][i] = true;
	}
	public static void remove(int i, int x, int y)
	{
		puzz[x][y] = 0;
		row[x][i] = false;
		col[y][i] = false;
		box[(x/3*3)+(y/3)][i] = false;
	}
	public static void solve(int x, int y)
	{
		if (x == 9)
		{
			solved = true;
			return;
		}
		else if (y == 9)
			solve(x+1, 0);
		else if (puzz[x][y] != 0)
			solve(x, y+1);
		else
		{
			for (int i = 1; i <= 9; i++)
			{
				if (check(i, x, y))
				{
					put(i, x, y);
					solve(x, y+1);
					if (!solved)
						remove(i, x, y);	
				}
			
			}
		}
	}
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++)
				puzz[i][j] = sc.nextInt();
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++)
				if (puzz[i][j] != 0)
					put(puzz[i][j], i, j);
		solve(0, 0);
		if (solved == true)
			for (int i = 0; i < 9; i++)
			{
				for (int j = 0; j < 9; j++)
					System.out.print(puzz[i][j] + " ");
				System.out.println();
			}
		else
			System.out.println("NO SOLUTION");
	}
}
