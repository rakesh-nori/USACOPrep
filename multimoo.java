import java.io.*;
import java.util.*;

public class multimoo 
{
	public static int nx = 0;
	public static int ny = 0;
	public static int[][] game;
	public static boolean [][]vis;
	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static int count = 0;
	public static void flood(int a, int x, int y)
	{
		if (x < 0 || y < 0 || x >= game.length || y >= game[x].length || vis[x][y] || game[x][y] != a)
			return;
		vis[x][y] = true;
		count += 1;
		for (int i = 0; i < 4; i++)
		{
			flood(a, x - 1, y);
			flood(a, x + 1, y);
			flood(a, x, y - 1);
			flood(a, x, y + 1);
		}
	}
	public static void flood(int a, int b, int x , int y)
	{
		if (x < 0 || y < 0 || x >= game.length || y >= game[x].length || vis[x][y])
		{
			return;
		}
		else if (game[x][y] == a || game[x][y] == b)
		{
			vis[x][y] = true;
			count ++;
			for (int i = 0; i < 4; i++)
			{
				flood(a, b, x - 1, y);
				flood(a, b, x + 1, y);
				flood(a, b, x, y - 1);
				flood(a, b, x, y + 1);
				
			}
		}
	}
	public static void main(String [] args) throws IOException
	{
		//BufferedReader br = new BufferedReader(new FileReader("multimoo.in"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter pw = new PrintWriter(new FileWriter("multimoo.out"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		game = new int[n][n];
		vis = new boolean[n][n];
		int [] nums = new int[n*n];
		int len = n*n;
		for (int a = 0; a < n; a++)
		{
			StringTokenizer in = new StringTokenizer(br.readLine());
			for (int b = 0; b < n; b++)
			{
				game[a][b] = Integer.parseInt(in.nextToken());
				for (int i = 0; i < nums.length; i++)
				{
					if(game[a][b] == nums[i])
					{
						break;
					}
					else if (nums[i] == 0)
					{
						nums[i] = game[a][b];
						len = i+1;
						break;
					}
				}		
			}
		}
		int max = 0;
	    //int maxNum = 0;
		for (int i = 0; i < len; i++)
		{
			for (int r = 0; r <= n/2; r++)
			{
				for (int c= r; c < n; c++)
				{
					flood(nums[i], r, c);
					if (count > max)
					{
						max = count;
						//maxNum = nums[i];
					}
					count = 0;
				}
			}
		}
		vis = new boolean[n][n];
		int twoMax = 0;
		//System.out.println("LEN " + len);
		/**
		for (int i = 0; i < len; i++)
		{
			vis = new boolean[n][n];
			for (int r = 0; r < n; r++)
			{
				for (int c = r; c < n; c++)
				{
					flood(maxNum, nums[i], r, c);
					if (count > twoMax)
					{
						twoMax = count;
					}
				    count = 0;
				}
			}
		}
		**/
		for (int a = 0; a < len / 2; a++)
		{
			for (int b = a+1; b < len; b++)
			{
				vis = new boolean[n][n];
				if (nums[a] != nums[b])
				{
					for (int r = 0; r <= n/2; r++)
					{
						for (int c = r; c < n; c++)
						{
							flood(nums[a], nums[b], r, c);
							if (count > twoMax)
							{
								twoMax = count;
							}
							count = 0;
						}
					}
				}
			}
		}
		System.out.println(max);
		System.out.println(twoMax);
		//pw.println(max);
		//pw.println(twoMax);
		br.close();
		//pw.close();
		
		/**
		for (int a = 0; a < n; a++)
		{
			System.out.println();
			//StringTokenizer in = new StringTokenizer(br.readLine());
			for (int b = 0; b < n; b++)
			{
				//maze[a][b] = Integer.parseInt(in.nextToken());
				System.out.print(maze[a][b] + " ");
			}
		}
		**/
	}
}
