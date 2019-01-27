import java.util.Scanner;

public class GoodGr 
{
	private int[][] prefSum;
	public void createPref(int[][]nums)
	{
		prefSum = new int[nums.length][nums[0].length];
		prefSum = nums;
		for (int r = 1; r < nums.length; r++)
		{
			prefSum [r][0] += nums[r-1][0];
		}
		for (int c = 1; c < nums[0].length; c++)
		{
			prefSum[0][c] += nums[0][c-1]; 
		}
		
		for (int r = 1; r < nums.length; r++)
		{
			for (int c = 1; c < nums[r].length; c++)
				prefSum[r][c] += (nums[r-1][c]+nums[r][c-1] - nums[r-1][c-1]);
		}
	}
	
	public int sumRegion(int a, int b, int c, int d)
	{
		int first = prefSum[c][d];
		int second = 0;
		int third = 0;
		int fourth = 0;
		if (!(a == 0))
		{
			second = prefSum[a-1][d];
			if (b != 0)
				fourth = prefSum[a-1][b-1];
		}
		if (!(b == 0))
		{
			third = prefSum[c][b-1];
			if (a != 0)
				fourth = prefSum[a-1][b-1];
		}
		return first - second - third + fourth;
	}
	
	public void printBest(int[][]grass)
	{
		int max = 0;
		int maxa = 0;
		int maxb = 0;
		createPref(grass);
		for (int a = 0; a < prefSum.length - 2; a++)
		{
			for (int b = 0; b < prefSum[0].length - 2; b++)
			{
				int c = a + 2;
				int d = b  + 2;
				int val = sumRegion(a,b,c,d);
				if (val > max)
				{
					max = val;
					maxa = a;
					maxb = b;
				}
			}
		}
		System.out.println(max);
		System.out.println((maxa+1) + " " + (maxb+1));
			
	}
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		int [][] grass = new int[r][c];
		for (int row = 0; row < r; row++)
		{
			for (int col = 0; col < c; col++)
				grass[row][col] = sc.nextInt();
		}
		GoodGr gr = new GoodGr();
		gr.printBest(grass);
	}

}
