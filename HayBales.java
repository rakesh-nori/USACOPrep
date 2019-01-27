import java.util.Scanner;

public class HayBales 
{
	
	public void restoreBales(int[] bales)
	{
		int sum = 0;
		for (int i = 0; i < bales.length;i++)
			sum += bales[i];
		int avg = sum / bales.length;
		int total = 0;
		for (int i = 0; i < bales.length; i++)
		{
			total += Math.abs((bales[i] - avg));
		}
		System.out.println(total/2);
	}
	public static void main (String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] bales = new int[n];
		for (int i = 0; i < n; i++)
			bales[i] = sc.nextInt();
		HayBales farm = new HayBales();
		farm.restoreBales(bales);
	}
}
