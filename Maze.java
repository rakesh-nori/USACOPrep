import java.util.Scanner;

public class Maze 
{
	char[][] gr;
	boolean [][]vis;
	String p;
	public void doFunction(int x, int y, String path)
	{
		if (x >= gr.length || x < 0 || y >= gr[0].length || y < 0)
			return;
		if (gr[x][y] == 'F')
		{
			p = path;
			return;
		}
		if (gr[x][y]=='#')
			return;
		if (vis[x][y])
			return;
		vis[x][y] = true;
		for (int i = 0; i < 4; i++)
		{
			if (i == 0)
			{
				doFunction(x, y+1, path+"R");
			}
			else if (i == 1)
			{
				doFunction(x, y-1, path+"L");
			}
			else if (i == 2)
			{
				doFunction(x+1, y, path+"D");
			}
			else if (i == 3)
			{
				doFunction(x-1, y, path+"U");
			}
		}
		
	}
	public String solve()
	{
		Scanner sc = new Scanner(System.in);
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		p = "";
		String holder = "";
		for(int i = 0; i < n; i++)
			holder += in.next();
		char [][]grid= new char[n][m];
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				grid[i][j] = (holder.charAt(j+ i*m));
		int x = 0; 
		int y = 0;
		vis = new boolean[n][m];
		gr = grid;
		for (int r = 0; r < n; r++)
			for (int c = 0; c < m; c++)
			{
				if (grid[r][c]== 'S')
				{
					x = r;
					y = c;
				}
			}
		doFunction(x, y, "");
		System.out.println(p);
		return p;
	}
	public static void main(String [] args)
	{
		Maze m = new Maze();
		m.solve();
	}
}
