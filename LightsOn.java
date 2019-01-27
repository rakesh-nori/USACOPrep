import java.util.*;
public class LightsOn 
{
	public static int nx = 0;
	public static int ny = 0;
	public static int n;
	public static int m;
	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static boolean[][] vis;
	public static boolean [][]rooms;
	public static Point [][] switches;
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		rooms = new boolean[n][n];
		vis = new boolean[n][n];
		switches = new Point[m][2];
		for (int i = 0; i < m; i++)
		{
			switches[i][0] = new Point();
			switches[i][1] = new Point();
			switches[i][0].x = sc.nextInt() - 1;
			switches[i][0].y = sc.nextInt() - 1;
			switches[i][1].x = sc.nextInt() - 1;
			switches[i][1].y = sc.nextInt() - 1;
			
		}
		rooms[0][0] = true;
		flood(0,0);
		int count = 0;
		for (int r = 0; r < n; r++)
			for (int c = 0; c < n; c++)
				if (rooms[r][c])
					count++;
		System.out.println(count);
	}
	
	public static void flood(int x, int y)
	{
		if (vis[x][y])
			return;
		if (!rooms[x][y])
			return;
		vis[x][y] = true;
		for (int i = 0; i < m; i++)
			if (switches[i][0].x == x && switches[i][0].y == y)
				rooms[(int) switches[i][1].x][(int) switches[i][1].y] = true;
		
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if (vis[i][j])
				{
					if (i >= 1 && rooms[i-1][j] && !vis[i-1][j])
						flood(i-1, j);
					else if (i+1 < n && rooms[i+1][j] && !vis[i+1][j])
						flood(i+1, j);
					else if (j >= 1 && rooms[i][j-1] && !vis[i][j-1])
						flood(i, j-1);
					else if (j+1 < n && rooms[i][j+1] && !vis[i][j+1])
						flood(i, j+1);
				}
			}
		}
		
		for(int i = 0; i < 4; i++)
		{
			nx = x + dx[i];
			ny = y + dy[i];
			if(!(nx >= n || nx < 0 || ny < 0 || ny >= n))
				flood(nx,ny);
		}
	}
	
}
