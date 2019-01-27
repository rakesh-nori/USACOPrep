import java.util.Scanner;

public class HShoe
{
	private boolean vis[][];
	private char[][]s;
	private int n;
	private int max;
	private int nx = 0;
	private int ny = 0;
	private int[] dx = {1, -1, 0, 0};
	private int[] dy = {0, 0, -1, 1};
	public void getBalanced(int ne, char [][]shoes)
	{
		n = ne;
		vis = new boolean[n][n];
		s = shoes;
		max = 0;
		if (shoes[0][0] == '(')
		{
			allPaths(0, 0, 1, 0);
			System.out.println(max);
		}
		else
		{
			System.out.println(0);
		}
	}
	public void update(int l, int r)
	{
		if (l+r > max)
			max = l+r;
	}
	public void allPaths(int x, int y, int l, int r)
	{
		if (x < 0 || y < 0 || x >= n || y >= n)
			return;
		if (vis[x][y])
			return;
		if (r == l)
		{
			update(l, r);
			return;
		}
		if (r > l)
			return;
		vis[x][y] = true;
		for(int i = 0; i < 4; i++)
		{
			nx = x + dx[i];
			ny = y + dy[i];
			if(!(nx >= n || nx < 0 || ny < 0 || ny >= n))
			{
				if(s[nx][ny] == '(' && r==0)
					allPaths(nx, ny, l+1, r);
				else if(s[nx][ny] == ')')
					allPaths(nx, ny, l,r+1);
			}
		}
		vis[x][y] = false;
	}
	
	public static void main (String [] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String holder = "";
		for(int i = 0; i < n; i++)
			holder += in.next();
		char [][]shoes= new char[n][n];
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				shoes[i][j] = (holder.charAt(j+ i*n));
		HShoe bessie = new HShoe();
		bessie.getBalanced(n, shoes);
	}

}
