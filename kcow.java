import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class kcow 
{
	public static char [][] gr;
	public static int [][] distance;
	private static int nx = 0;
	private static  int ny = 0;
	private static int x;
	private static int y;
	private static int[] dx = {2, 1, -2, 2, -2, 1, -1, -1};
	private static int[] dy = {1, 2, 1, -1, -1, -2, 2, -2};
	public static Queue<Point> q = new LinkedList<Point>();
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		y = sc.nextInt();
		x = sc.nextInt();
		String holder = "";
		for(int i = 0; i < x; i++)
			holder += sc.next();
		gr = new char[x][y];
		distance = new int[x][y];
		int sx = 0;
		int sy = 0;
		for(int i = 0; i < x; i++)
		{
			for(int j = 0; j < y; j++)
			{
				distance[i][j] = -1;
				gr[i][j] = (holder.charAt(j+ i*y));
				if (gr[i][j] == 'K')
				{
					distance[i][j] = 0;
					sx = i;
					sy = j;
				}
			}
		}
		Point p = new Point(sx, sy);
		q.add(p);
		bfs();
	}
	public static void bfs()
	{
		while (gr[((Point)q.peek()).x][((Point)q.peek()).y] != 'H')
		{
			int oldX = ((Point)q.peek()).x;
			int oldY = ((Point)q.peek()).y; 
			for (int i = 0; i < 8; i++)
			{
				nx = oldX + dx[i];
				ny = oldY + dy[i];
				if (nx >= 0 && nx < x && ny >= 0 && ny < y && gr[nx][ny] != '*' && distance[nx][ny] == -1)
				{
					distance[nx][ny] = distance[oldX][oldY] +1;
					q.add(new Point(nx, ny));
				}
			}
			q.remove();
		}
		System.out.println(distance[((Point)q.peek()).x][((Point)q.peek()).y]);
	}
}
