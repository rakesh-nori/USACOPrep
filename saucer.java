import java.util.*;
import java.io.*;

public class saucer 
{
	private static boolean vis[][];
	private static char[][]s;
	private static int nx = 0;
	public static int n;
	public static int m;
	private static int ny = 0;
	private static int[] dx = {1,0};
	private static int[] dy = {0,1};
	public static int count;
	public static void main(String [] args) throws IOException
	{

		BufferedReader br = new BufferedReader(new FileReader("saucer.txt"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		String holder = "";
		for(int i = 0; i < n; i++)
		{
			StringTokenizer bruh = new StringTokenizer(br.readLine());
			holder += bruh.nextToken();
		}
		s= new char[n][m];
		vis = new boolean [n][m];
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				s[i][j] = (holder.charAt(j+ i*m));
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < m; j++)
			{
				System.out.print(s[i][j]);
			}
			System.out.println();
		}
		allPaths(0, 0);
		System.out.println(count % 1000000007);
	}
	public static void allPaths(int x, int y)
	{
		if (x < 0 || y < 0 || x >= n || y >= m)
			return;
		else if (vis[x][y] || s[x][y] == '@')
			return;
		else if (s[x][y] == 'F')
		{
			count++;
			return;
		}
		vis[x][y] = true;
		
		for (int i = 0; i < 2; i++)
		{
			nx = x + dx[i];
			ny = y + dy[i];
			if(!(nx >= n || nx < 0 || ny < 0 || ny >= m))
			{
				allPaths(nx, ny);
			}
			
		}
		vis[x][y] = false;
	}
	
}
