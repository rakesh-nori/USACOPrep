import java.util.Scanner;
public class Pachinko 
{
	private int max;
	private int r;
	int [][] machine;
	public void findGreatest(int ro, int [][] mac)
	{
		r = ro;
		max = 0;
		machine = mac;
		allPaths(0, 0, 0);
		System.out.println(max);
	}
	public void allPaths(int x, int y, int sum)
	{
		if (x == r)
		{
			if (sum > max)
				max = sum;
			return;
		}
		allPaths(x+1, y, sum + machine[x][y]);
		allPaths(x+1, y+1, sum + machine[x][y]);
	}
	
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int [][] machine = new int[r][];
		for (int i = 1; i <= r; i++)
		{
			machine[i-1] = new int[i];
		}
		for (int row = 0; row < machine.length; row++)
			for (int c = 0; c < machine[row].length; c++)
				machine[row][c] = sc.nextInt();
		Pachinko pac = new Pachinko();
		pac.findGreatest(r, machine);
	}
}
