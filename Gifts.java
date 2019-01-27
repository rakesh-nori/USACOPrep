import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class Gifts
{
	Point pref[];
	public int binSearch(int val)
	{
		int low = 0;
		int mid = 0;
		int high = pref.length - 1;
		while (low < high)
		{
			mid = (low + high+1) / 2;
			if ((pref[mid].x+pref[mid].y) <= val)
				low = mid;
			else
				high = mid - 1;
		}
		return low;
	}
	public void createPref(Point [] cows)
	{
		pref = new Point[cows.length+1];
		pref[0] = new Point();
		pref[0].x = 0;
		pref[0].y = 0;
		for (int i = 1; i < pref.length; i++)
		{
			pref[i] = new Point();
			pref[i].x = pref[i-1].x + cows[i-1].x;
			pref[i].y = pref[i-1].y + cows[i-1].y;
			
		}
	}
	public void findGifts(Point[] cows, int b)
	{
		createPref(cows);
		int loc = binSearch(b);
		if (pref[loc].x + pref[loc].y + cows[loc].x/2 + cows[loc].y <= b)
			loc++;
		System.out.println(loc);
		
	}
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int b = sc.nextInt();
		Point [] cows = new Point[n];
		for (int i = 0; i < n; i++)
		{
			cows[i] = new Point();
			cows[i].x = sc.nextInt();
			cows[i].y = sc.nextInt();
		}
		Arrays.sort(cows, new comp());
		Gifts g = new Gifts();
		g.findGifts(cows, b);
		
	}
	

static class comp implements Comparator<Point> 
{
	public int compare(Point a, Point b)
	{
		return (int) ((a.x+a.y)-(b.x+b.y));
	}
}

}
static class Point 
{
	long x, y;
}
