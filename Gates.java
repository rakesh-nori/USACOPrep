import java.util.Scanner;

public class Gates
{
	private static int nx = 0;
	private static int ny = 0;
	public static char[][] farm;
	public static boolean [][]vis;
	private static int[] dx = {1, -1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
	public static void flood(int x, int y)
	{
		if (x < 0 || y < 0 || x >= farm.length || y >= farm[x].length||vis[x][y])
			return;
		if (farm[x][y] == '*')
			return;
		if (vis[x][y])
			return;
		vis[x][y] = true;
		for(int i = 0; i < 4; i++)
		{
			nx = x + dx[i];
			ny = y + dy[i];
			if(!(nx >= farm.length || nx < 0 || ny < 0 || ny >= farm[nx].length || vis[nx][ny]))
			{
				flood(nx, ny);
			}
		}
	}
	public static void main(String[]args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		farm = new char[4*n+1][4*n+1];
		vis = new boolean[4*n+1][4*n+1];
		int x = (4*(n+1))/2;
		int y = (4*(n+1))/2;
		for (int r = 0; r < 4*n+1; r++)
		{
			for (int c = 0; c < 4*n+1;c++)
			{
				farm[r][c] = '.';
			}
		}
		farm[x][y] = '*';
		String str = sc.next();
		
		for (int i = 0; i < n; i++)
		{
			char c = str.charAt(i);
			if(c == 'N')
			{
				x--;
				farm[x][y]='*';
				x--;
				farm[x][y]='*';
			}
			else if(c == 'E')
			{
				y++;
				farm[x][y]='*';
				y++;
				farm[x][y]='*';
			}
			else if (c=='W')
			{
				y--;
				farm[x][y]='*';
				y--;
				farm[x][y]='*';
			}
			else if (c== 'S')
			{
				x++;
				farm[x][y]='*';
				x++;
				farm[x][y]='*';
			}	
		} 
		int count = 0;
		for (int i = 0; i < 4*n+1; i++)
		{
			for (int j = 0; j < 4*n+1; j++)
			{
				if ( farm[i][j] != '*' && !vis[i][j])
				{
					flood(i, j);
					count++;
				}
			}
		}
		System.out.println(count - 1);
	}
}
