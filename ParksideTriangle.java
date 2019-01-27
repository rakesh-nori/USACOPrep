import java.util.Scanner;

public class ParksideTriangle 
{
	public void printTriangle(int size, int start)
	{
		int [][] parkArr = new int[size][size];
		for (int c = 0; c < size; c++)
		{
			for (int r = 0; r < size; r++)
			{
				if (r<= c)
				{
					parkArr[r][c]= start;
					start++;
					if (start >= 10)
						start = 1;
				}
				else
				{
					parkArr[r][c] = 0;
				}
			}
		}
		for (int r = 0; r < size; r++)
		{
			for (int c = 0; c < size; c++)
			{
				if (parkArr[r][c] != 0)
					System.out.print(parkArr[r][c] + " ");
				else
					System.out.println("  ");
			}
			System.out.print("\n");
		}
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int s = sc.nextInt();
		ParksideTriangle park = new ParksideTriangle();
		park.printTriangle(size, s);
	}
}
