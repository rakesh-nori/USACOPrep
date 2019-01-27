import java.util.Scanner;

public class ClausCow 
{
	//store min cow tags that have the min distance
	//store min distance
	public double calculateDistance(int[] first, int[]second)
	{
		double xVal = 1.0 * (second[0] - first[0]);
		double yVal = 1.0 * (second[1] - first[1]);
		double val = Math.sqrt((xVal*xVal + yVal*yVal));
		return val;
	}
	public void determineClosest(int[][]cowLocs, int numCows)
	{
		double min = 1.00 * Integer.MAX_VALUE;
		int firstCow = 0;
		int secondCow = 0;
		for (int cow1 = 0; cow1 < numCows; cow1++)
		{
			for (int cow2 = cow1+1; cow2 < numCows; cow2++)
			{
				double res = calculateDistance(cowLocs[cow1], cowLocs[cow2]);
				if (res < min)
				{
					min = res;
					firstCow = cow1 + 1;
					secondCow = cow2 + 1;
				}
			}
		}
		System.out.println(firstCow + " " + secondCow);
	}
	
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[][]locs = new int[num][2];
		for (int i = 0; i < num; i++)
		{
			locs[i][0] = sc.nextInt();
			locs[i][1] = sc.nextInt();
		}
		ClausCow clad = new ClausCow();
		clad.determineClosest(locs, num);
	}
}
