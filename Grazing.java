import java.util.Scanner;

public class Grazing 
{
	public static int len;
	public static int count;
	public static char [][] gr;
	public static boolean vis[][];
	private int nx = 0;
	private int ny = 0;
	private int[] dx = {1, -1, 0, 0};
	private int[] dy = {0, 0, -1, 1};
	public void graze(int x, int y, int g)
	{
		if (x < 0 || y < 0 || x >= 5 || y >= 5)
			return;
		if (gr[x][y]=='x')
			return;
		if (vis[x][y])
			return;
		if (gr[x][y]=='M')
		{
			if (g == len)
				count++;
			return;
		}
		vis[x][y] = true;
		for(int i = 0; i < 4; i++)
		{
			nx = x + dx[i];
			ny = y + dy[i];
			graze(nx,ny,g+1);
		}
		vis[x][y] = false;
		
	}
	public static void main(String[]args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		gr = new char[5][5];
		vis = new boolean[5][5];
		for (int r = 0; r < 5; r++)
			for (int c = 0; c < 5; c++)
				gr[r][c] = '.';
		gr[0][0] = 'B';
		gr[4][4] = 'M';
		for (int i = 0; i < n; i++)
		{
			int r = sc.nextInt();
			int c = sc.nextInt();
			gr[r-1][c-1] = 'x';
		}
		len = 25-n;
		Grazing g = new Grazing();
		g.graze(0, 0, 1);
		System.out.println(count);
	}
	
}
