import java.util.Scanner;

public class Hol 
{
	private int [] elements ;
	private int[][] numbers;
	private int g;
	private int [] min;
	private int scoops;
	private int [] numeros;
	private int [] vitamins;
	private int v;
	public void process()
	{
		int sco = 0;
        int [] nums = new int[g];
        int index = 0;
		for (int i = 0; i < elements.length; i++)
		{
			if (elements[i] == 1)
			{
				sco++;
				nums[index] = i+1;
				index++;
			}
		}
		int [] feedVits = new int[v];
		for (int i = 0; i < nums.length; i++)
		{
			if (nums[i] != 0)
			{
				int val = nums[i]- 1;
				for (int ind = 0; ind < v; ind++)
				{
					feedVits[ind] += numbers[val][ind];
				}
			}
		}
		if (isGreater(feedVits))
		{
			if (sco < scoops)
			{
				numeros = nums;
				scoops = sco;
				min = feedVits;
			}
			else if (sco == scoops)
			{
				int vitTotal = 0;
				for (int i = 0; i < feedVits.length;i++)
					vitTotal += feedVits[i];
			    int minTotal = 0;
			    for (int i = 0; i < min.length; i++)
			    	minTotal += min[i];
			    if (vitTotal < minTotal)
			    {
			    	numeros = nums;
					scoops = sco;
					min = feedVits;
			    }  	
			}	
		}
	}
	public boolean isGreater(int [] feedVits)
	{
		boolean isGreater = true;
		for (int i = 0; i < feedVits.length; i++)
		{
			if (feedVits[i] < vitamins[i])
			{
				isGreater = false;
			}
		}
		return isGreater;
	}
	public void giveCombos(int[][]feeds)
	{
		numbers = feeds;
		elements = new int[feeds.length];
	    for (int i = 1; i <= feeds.length; i++)
	    {
	    	combo(0,0,i);
	    }
	}
	
	public void combo(int e, int picked, int numDig)
	{
		if (e == numbers.length)
		{
			if (picked == numDig)
			{
				process();
			}
			return;
		}
		elements[e] =1;
		combo(e+1, picked+1, numDig);
		elements[e] = 0;
		combo(e+1, picked, numDig);
	}
	public void givOpt(int [] vits, int[][]feeds, int vit, int gg)
	{
		scoops = Integer.MAX_VALUE;
		g = gg;
		min = new int[vit];
		vitamins = vits;
		v = vit;
		giveCombos(feeds);
		System.out.print(scoops + " ");
		for (int i = 0; i < numeros.length; i++)
		{
			if (numeros[i] != 0)
				System.out.print(numeros[i]+ " ");
		}
	}
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int [] vitamins = new int[v];
		for (int i = 0; i < v; i++)
			vitamins[i] = sc.nextInt();
		int g = sc.nextInt();
		int [][] feeds = new int[g][v];
		for (int i = 0; i < g; i++)
			for (int j = 0; j < v; j++)
				feeds[i][j] = sc.nextInt();
	    sc.close();
		Hol h = new Hol();
		h.givOpt(vitamins, feeds, v, g);
		
	}
}

