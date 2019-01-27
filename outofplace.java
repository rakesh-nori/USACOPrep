import java.util.*;
import java.io.*;
public class outofplace {
	public static void main(String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader("outofplace.in"));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new FileWriter("outofplace.out"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int [] heights = new int[n];
		for (int i = 0; i < n; i++)
		{
			StringTokenizer s = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(s.nextToken());
			heights[i] = a;
			//System.out.println(heights[i]);
		} 

		int swaps = 0;

		while (!ascending(heights))
		{
			boolean useSecond = false;
			//System.out.println("OK");
			for (int i = 0; i < n-1; i++)
			{
				if (heights[i+1] < heights[i])
				{
					int index = i-1;
					while (index >= 0)
					{
						if (heights[index] == heights[i])
							index--;
						else
						{
							index++;
							break;
						}
					}
					if (index == i)
					{
						useSecond = true;
						index = i + 2;
						//System.out.println(index);
						int temp = i + 1;
						//System.out.println(temp);
						while (index < heights.length)
						{
							//System.out.println(index);
							if (heights[index] == heights[temp])
								index++;
							else
							{
								index--;
								break;
							}
						}
					}
					if (index == heights.length)
						index--;
					//System.out.println(index + " AEDFA");
					if (!useSecond)
					{
						int temp = heights[i+1];
						heights[i+1] = heights[index];
						heights[index] = temp;
					}
					if (useSecond)
					{
						int temp = heights[i];
						heights[i] = heights[index];
						heights[index] = temp;
					}
					swaps++;
					break;
				}
			}
		}
		//System.out.println(swaps);
		pw.println(swaps);
		br.close();
		pw.close();

	}
	public static boolean ascending(int [] arr)
	{
		for (int i = 0; i < arr.length-1; i++)
		{
			if (arr[i] > arr[i+1])
				return false;
		}
		return true;
	}

}
