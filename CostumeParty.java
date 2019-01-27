import java.util.Arrays;
import java.util.Scanner;

public class CostumeParty
{
	public int binSearch(int val, int[] lens)
	{
		int low = 0;
		int mid = 0;
		int high = lens.length - 1;
		while (low < high)
		{
			mid = (low + high+1) / 2;
			if (lens[mid] <= val)
				low = mid;
			else
				high = mid - 1;
		}
		return low;
	}
	public void findMost(int n, int s, int [] lens)
	{
		Arrays.sort(lens);
		int possible = 0;
		for (int i = 0; i < n; i++)
		{
			int highestInd = binSearch(s-lens[i], lens);
			if (highestInd > i)
			{
				possible += (highestInd-i);
			}
			else
				break;
		}
		System.out.println(possible);
	}
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int s = sc.nextInt();
		int [] lens = new int[n];
		for (int i = 0; i < n; i++)
			lens[i] = sc.nextInt();
		CostumeParty cos = new CostumeParty();
		cos.findMost(n, s, lens);
	}
}
