import java.util.*;
//THIS ONE WORKS
public class SGates 
{
	private static int nx = 0;
	private static int ny = 0;
	public static int count = 0;
	public static char[][] farm;
	public static boolean [][]vis;
	private static int[] dx = {1, -1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
	public static void flood()
	{
		for (int i = 0; i < farm.length; i++)
		{
			for (int j = 0; j < farm[i].length; j++)
			{
				if (farm[i][j] != '*' && !vis[i][j])
				{
					count++;
					Queue<Point> q = new LinkedList<Point>();
					q.add(new Point(i, j));
					vis[i][j] = true;
					while (q.size() > 0)
					{
						Point curr = q.remove();
						for (int a = 0; a < 4; a++)
						{
							nx = curr.x + dx[a];
							ny = curr.y + dy[a];
							if (nx >= 0 && nx < farm.length && ny >= 0 && ny < farm[i].length && !vis[nx][ny] && farm[nx][ny] != '*')
							{
								vis[nx][ny] = true;
								q.add(new Point(nx, ny));
							}
						}
					}
				}
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
		flood();
		
		System.out.println(count - 1);
	}
}
