import java.util.Arrays;
import java.util.Scanner;

public class ThePerfectCow 
{
	public int findMedian(int[] arr, int len)
	{
		Arrays.sort(arr);
		return arr[len/2];
	}
	
	public void getTrueMedian(int[][]twodArr,int len)
	{
		int[] medArr = new int[len];
		for (int i = 0; i < len; i++)
		{
			medArr[i] = findMedian(twodArr[i], len);
		}
		System.out.println(findMedian(medArr, len));
	}
	
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		int[][]cowArr = new int[len][len];
		for (int r = 0; r < len; r++)
		{
			for (int c = 0; c < len; c++)
			{
				cowArr[r][c] = sc.nextInt();
			}
		}
		ThePerfectCow FJ = new ThePerfectCow();
		FJ.getTrueMedian(cowArr, len);
		sc.close();
	}
}
