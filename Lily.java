import java.util.*;

public class Lily 
{
	public static int m;
	public static int n;
	public static int m1;
	public static int m2;
	public static int sx;
	public static int sy;
	public static Queue q = new LinkedList();
	public static int[][] pond;
	public static int[][] distance;
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		m1 = sc.nextInt();
		m2 = sc.nextInt();
		distance = new int[m][n];
		pond = new int[m][n];
		for (int r = 0; r < m; r++)
			for (int c = 0; c < n; c++)
			{
				distance[r][c] = -1;
				pond[r][c] = sc.nextInt();
				if (pond[r][c] == 3)
				{
					sx = r;
					sy = c;
				}
					
			}
		distance[sx][sy] = 0;
		Point p = new Point(sx, sy);
		q.add(p);
		bfs();
	}
	
	public static void bfs()
	{
		while (pond[((Point)q.peek()).x][((Point)q.peek()).y] != 4)
		{
			int oldX = ((Point)q.peek()).x;
			int oldY = ((Point)q.peek()).y; 
			for (int i = 0; i < 8; i++)
			{
				int nx = 0;
				int ny = 0;
				if (i == 0)
				{
					nx = oldX + m1;
					ny = oldY + m2;
				}
				else if (i == 1)
				{
					nx = oldX + m1;
					ny = oldY - m2;
				}
				else if (i == 2)
				{
					nx = oldX - m1;
					ny = oldY - m2;
				}
				else if (i == 3)
				{
					nx = oldX - m1;
					ny = oldY + m2;
				}
				else if (i == 4)
				{
					nx = oldX + m2;
					ny = oldY + m1;
				}
				else if (i == 5)
				{
					nx = oldX + m2;
					ny = oldY - m1;
				}
				else if (i == 6)
				{
					nx = oldX - m2;
					ny = oldY - m1;
				}
				else if (i == 7)
				{
					nx = oldX - m2;
					ny = oldY + m1;
				}
				
				if (nx >= 0 && nx < m && ny >= 0 && ny < n &&
					pond[nx][ny] != 0 && pond[nx][ny] != 2 && distance[nx][ny] == -1)
				{
					distance[nx][ny] = distance[oldX][oldY] +1;
					q.add(new Point(nx, ny));
				}
			}
			q.remove();
		}
		System.out.println(distance[((Point)q.peek()).x][((Point)q.peek()).y]);
		
	}
	static class Point
	{
		
	}
}
