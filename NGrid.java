
import java.util.*;
public class NGrid 
{
	boolean [] nums;
	private int[][]g;
	public void getCombos(int [][] grid)
	{
		g = grid;
		nums = new boolean[1000000];
		for (int r = 0; r < 5; r++)
			for (int c = 0; c < 5; c++)
				numbers(r, c, 0, 0);
		int count = 0;
		for (int i = 0; i < nums.length; i++)
		{
			if (nums[i])
				count++;
		}
		System.out.println(count);
				
	}
	public void process(int num)
	{
		nums[num] = true;
	}
	public void numbers(int x, int y, int j, int num)
	{
		if (x < 0 || y < 0 || y ==5 || x == 5)
			return;
		if (j == 6)
		{
			process(num);
			return;
		}
		for (int i = 0; i < 4; i++)
		{
			if (i == 0)
			{
				numbers(x-1, y, j+1, num*10 + g[x][y]);
			}
			else if (i == 1)
			{
				numbers(x+1, y, j+1, num*10 + g[x][y]);
			}
			if (i == 2)
			{
				numbers(x, y+1, j+1, num*10 + g[x][y]);
			}
			if (i == 2)
			{
				numbers(x, y-1, j+1, num*10 + g[x][y]);
			}
		}
	}
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int [][] grid = new int[5][5];
		for (int r = 0; r < 5; r++)
			for (int c = 0; c < 5; c++)
				grid[r][c] = sc.nextInt();
		NGrid ng = new NGrid();
		ng.getCombos(grid);
	}
}
