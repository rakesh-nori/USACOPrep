import java.util.*;
public class CMaze 
{
	public static int n;
	public static int m;
	public static char [][]cMaze;
	public static Queue q = new LinkedList();
	public static int sx;
	public static int sy;
	public static int[][] time;
	private int nx = 0;
	private int ny = 0;
	private static int[] dx = {1, -1, 0, 0};
	private static int[] dy = {0, 0, 1, -1};
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		cMaze = new char[n][m];
		time = new int[n][m];
		String holder = "";
		for(int i = 0; i < n; i++)
			holder += sc.next();
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < m; j++)
			{
				time[i][j] = -1;
				cMaze[i][j] = (holder.charAt(j+ i*m));
				if (cMaze[i][j] == '@')
				{
					sx = i;
					sy = j;
				}
			}
		}
		Point p = new Point(sx, sy);
		time[sx][sy] = 0;
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < m; j++)
			{
				System.out.print(time[i][j]);
			}
			System.out.println();
		}
		q.add(p);
		bfs();
	}
	public static void bfs()
	{
		while (cMaze[((Point)q.peek()).x][((Point)q.peek()).y] != '=')
		{
			System.out.println("New time");
			int oldX = ((Point)q.peek()).x;
			int oldY = ((Point)q.peek()).y; 
			System.out.println(cMaze[((Point)q.peek()).x][((Point)q.peek()).y]);
			System.out.println(oldX + " OLD");
			System.out.println(oldY + " OLD");
			int old = time[oldX][oldY];
			System.out.println(old);
			for (int i = 0; i < 4; i++)
			{
				int nx = oldX + dx[i];
				int ny = oldY + dy[i];
				System.out.println(cMaze[nx][ny]);
				System.out.println(nx >= 0);
				System.out.println(nx < n);
				System.out.println(ny >= 0);
				System.out.println(ny < m);
				System.out.println(cMaze[nx][ny] != '#');
				System.out.println(cMaze[nx][ny] != '@');
				System.out.println(time[nx][ny] == -1);
				if (cMaze[nx][ny] == '=')
					System.out.println("THERE IS EQUALS HERE");
				System.out.println(time[nx][ny]);
				if (nx >= 0 && nx < n && ny >= 0 && ny < m &&
					cMaze[nx][ny] != '#'&& cMaze[nx][ny]!= '@' && time[nx][ny] == -1 || (nx >= 0 && nx < n && ny >= 0 && ny < m &&cMaze[nx][ny] != '#'&& cMaze[nx][ny]!= '@' && cMaze[nx][ny]!= '.'&& cMaze[nx][ny]!= '=') )
				{
					System.out.println("I MADE IT");
					char c = cMaze[nx][ny];
					if (c != '.' && c != '=')
					{
						boolean found = false;
						for (int r = 0; r < n; r++)
						{
							for (int co = 0; co < m; co++)
							{
								if (cMaze[r][co] == c && !found && !(r == nx && co == ny))
								{
									System.out.println("Ayyyy");
									nx = r;
									ny = co;
									found = true;
								}
							}
						}
					}
					System.out.println(nx);
					System.out.println(ny);
					System.out.println(time[oldX][oldY] + 1);
					if (time[nx][ny] == -1 || time[nx][ny] >= old+1)
						time[nx][ny] = old + 1;
					q.add(new Point(nx, ny));
				}
			}
			q.remove();
		}
		System.out.println(time[((Point)q.peek()).x][((Point)q.peek()).y]);
	}
}
