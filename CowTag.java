import java.util.Scanner;

public class CowTag 
{
	private boolean[] dead;
	public double calculateDistance(int[] first, int[]second)
	{
		double xVal = 1.0 * (second[0] - first[0]);
		double yVal = 1.0 * (second[1] - first[1]);
		double val = Math.sqrt((xVal*xVal + yVal*yVal));
		return val;
	}
	public int determineClosest(int[]currLocs, int currCow, int[][] locs)
	{
		double min = 1.00 * Integer.MAX_VALUE;
		int lowestCow = 0;
		for (int cow = 0; cow < locs.length; cow++)
		{
			if (cow == currCow || dead[cow] || dead[currCow])
			{
				
			}
			else
			{
				double num = calculateDistance(currLocs, locs[cow]);
				if (num < min)
				{
					min = num;
					lowestCow = cow;
				}
				
			}
		}
		return lowestCow;
	}
	public boolean determineGame()
	{
		int aliveCount = 0;
		for (int index = 0; index < dead.length; index++)
		{
			if (dead[index] == false)
				aliveCount++;
		}
		if (aliveCount <= 1)
		{
			return false;
		}
		return true;
	}
	 public void play(int[][]locs, int numCows)
	 {
		 dead = new boolean[numCows];
		 for (int i = 0; i < numCows; i++)
		 {
			 dead[i] = false;
		 }
		 int currCow = 0;
		 while(determineGame())
		 {
			 int toTag = determineClosest(locs[currCow], currCow, locs);
			 dead[toTag] = true;
			 currCow++;
			 if (currCow >= numCows)
				 currCow = 0;
		 }
		 int winner = 0;
		 for (int i = 0; i < dead.length; i++)
		 {
			 if (dead[i] == false)
			 {
				 winner = i;
			 }
		 }
		 System.out.println((winner + 1));
	 }
	 
	 public static void main(String [] args)
	 {
		 Scanner sc = new Scanner(System.in);
		 int num = sc.nextInt();
		 int [][] coordinates = new int[num][2];
		 for (int i = 0; i < num; i++)
		 {
			 coordinates[i][0] = sc.nextInt();
			 coordinates[i][1] = sc.nextInt();
		 }
		 CowTag game = new CowTag();
		 game.play(coordinates, num);
	 }

}
