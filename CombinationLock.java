import java.util.Scanner;

public class CombinationLock 
{
	public boolean isClose(int[]combo, int[]fKey, int[]mKey, int n)
	{
		boolean fKeys = true;
		boolean mKeys = true;
		for (int i = 0; i < 3; i++)
		{
			if (!(Math.abs(combo[i]-fKey[i]) <= 2 || Math.abs(combo[i] - fKey[i]) + 2 >= n))
				fKeys = false;
			if (!(Math.abs(combo[i]-mKey[i]) <= 2 || Math.abs(combo[i] - mKey[i]) + 2 >= n))
				mKeys = false;
		}
		return fKeys || mKeys;
	}
	public void detCombos(int n, int[] fKey, int[]mKey)
	{
		int count = 0;
		int[] combo = new int[3];
		for (int a = 1; a <=n; a++)
		{
			combo[0] = a;
			for (int b = 1; b <=n; b++)
			{
				combo[1] = b;
				for(int c = 1; c <= n; c++)
				{
					combo[2] = c;
					if (isClose(combo, fKey, mKey, n))
						count++;
				}
			}
		}
		System.out.println(count);
	}
	
	public static void main (String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] fKey = new int[3];
		int [] mKey = new int[3];
		for (int i = 0; i < 3; i++)
			fKey[i] = sc.nextInt();
		for (int i = 0; i < 3; i++)
			mKey[i] = sc.nextInt();
		
		CombinationLock farm = new CombinationLock();
		farm.detCombos(n, fKey, mKey);
	}

}
