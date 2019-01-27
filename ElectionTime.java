import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ElectionTime
{
	public void determineWinner(Point pot[], int cutoff)
	{
		Arrays.sort(pot, new comp());
		int maxLoc = 0;
		int maxVal = pot[maxLoc].y;
		for (int i = 0; i < cutoff; i++)
		{
			if (pot[i].y > maxVal)
			{
				maxVal = pot[i].y;
				maxLoc = i;
			}
		}
		System.out.println(pot[maxLoc].num);
	}
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int initial = sc.nextInt();
		int cutoff = sc.nextInt();
		Point p [] = new Point[initial];
		for (int i = 0; i < initial; i++)
		{
			p[i] = new Point();
			p[i].x = sc.nextInt();
			p[i].y = sc.nextInt();
			p[i].num = i+1;
		}
		ElectionTime eli = new ElectionTime();
		eli.determineWinner(p, cutoff);
	}
	static class comp implements Comparator<Point> 
	{
		public int compare(Point a, Point b)
		{
			return b.x-a.x;
		}
	}
	
}
