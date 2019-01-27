import java.util.Scanner;

public class Lake 
{
	public static int[][] executeOrder(Order o, int[][]arr)
	{
		int max = Integer.MIN_VALUE;
		for (int r = o.r-1; r < o.r+2; r++)
			for (int c = o.c-1; c < o.c+2; c++)
				if (arr[r][c] > max)
					max = arr[r][c];
		max -= o.d;
		for (int r = o.r-1; r < o.r+2; r++)
			for (int c = o.c-1; c < o.c+2; c++)
				if (arr[r][c]>max)
					arr[r][c] = max;
		return arr;
	}
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		int e = sc.nextInt();
		int n = sc.nextInt();
		int [][] initial = new int[r][c];
		for (int row = 0; row < r; row++)
			for (int col = 0; col < c; col++)
				initial[row][col] = sc.nextInt();
		Order[] orders = new Order[n];
		for (int i = 0; i < n; i++)
		{
			orders[i] = new Order();
			orders[i].r = sc.nextInt();
			orders[i].c = sc.nextInt();
			orders[i].d = sc.nextInt();
		}
		for (int index = 0; index < n; index++)
		{
			initial = executeOrder(orders[index], initial);
		}
		int depth = 0;
		for (int row = 0; row < r; row++)
			for (int col = 0; col < c; col++)
			{
				int num = e - initial[row][col];
				if (num > 0)
					depth += num;
			}
		int vol = depth*72*72;
		System.out.println(vol);
	
	}		
}
class Order 
{
	int r, c, d;
}
