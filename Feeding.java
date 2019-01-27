import java.util.Scanner;


public class Feeding
{
	public static char [][] gr;
	public static boolean [][]vis;
	private int nx = 0;
	private int ny = 0;
	private int[] dx = {1, -1, 0, 0, 1,-1, 1, -1};
	private int[] dy = {0, 0, -1, 1, 1, -1, -1, 1};
	
	public int flood(int x, int y)
	{
		if (x < 0 || y < 0 || x >= gr.length || y >= gr[x].length||vis[x][y])
			return 0;
		if (gr[x][y] != '.')
			return 0;
		vis[x][y] = true;
		int total = 1;
		for(int i = 0; i < 8; i++)
		{
			nx = x + dx[i];
			ny = y + dy[i];
			if(!(nx >= gr.length || nx < 0 || ny < 0 || ny >= gr[x].length))
			{
				total += flood(nx, ny);
			}
		}
		return total;
		
	}
	
	public static void main(String[]args)
	{
		int max = 0;
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt();
		int h = sc.nextInt();
		Feeding bess = new Feeding();
		String holder = "";
		for(int i = 0; i < h; i++)
			holder += sc.next();
		gr = new char[h][w];
		vis = new boolean[h][w];
		for(int i = 0; i < h; i++)
			for(int j = 0; j < w; j++)
				gr[i][j] = (holder.charAt(j+ i*w));
		for (int i = 0; i < h; i++)
			for (int j = 0; j < w; j++)
				if (gr[i][j]=='.'&&!(vis[i][j]))
				{
					int num = bess.flood(i, j);
					if (num > max)
						max = num;	
				}
		System.out.println(max);
	}
}
