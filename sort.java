import java.io.*;
import java.util.*;
public class sort 
{
	public static void main(String [] args) throws IOException
	{
		//BufferedReader br = new BufferedReader(new FileReader("sort.in"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter pw = new PrintWriter(new FileWriter("sort.out"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		//Scanner sc = new Scanner("sort.in");
		//Scanner sc = new Scanner(System.in);
		//PrintWriter pw = new PrintWriter(new File("sort.out"));
		
		int [] arr = new int[n];
		for (int i = 0; i < n; i++)
		{
			StringTokenizer s = new StringTokenizer(br.readLine());
			int b = Integer.parseInt(s.nextToken());
			arr[i] = b;
		}
		int [] poss = new int[n];
		int [] possLoc = new int[n];
		int len = 0;
		for (int i = 0; i < n-1; i++)
		{
			if (arr[i+1] < arr[i])
			{
				poss[len] = arr[i+1];
				possLoc[len] = i+1;
				len++; 
			}
		}
		//int a = bubbleSort(arr);
		int [] dup = new int[n];
		for (int i = 0; i < n; i++)
			dup[i] = arr[i];
		Arrays.sort(dup);
		int [] distance = new int[n];
		for (int i = 0; i < len; i++)
		{
			int temp = 0;
			while (dup[temp] != poss[i])
				temp++;
			distance[i] = Math.abs(possLoc[i] - temp);
		}
		Arrays.sort(distance);
		//pw.println(distance[n-1]+1);
		System.out.println(distance[n-1]+1);
		//pw.println(distance[n-1] + 1);
		//pw.println(a);
		//pw.close();
		br.close();
		
	}
	public static int bubbleSort(int [] arr)
	{
		 int n = arr.length;  
	     int temp = 0; 
	     int ret = 0;
	     boolean already = false;
	     boolean swap = false;
	     for(int i=0; i < n; i++)
	     {  
	    	 for(int j=1; j < (n-i); j++)
	    	 {  
	    		 if(arr[j-1] > arr[j])
	    		 {  
	    			 swap = true;
	    			 if (!already)
	    			 {
	    				 ret++;
	    				 already = true;
	    			 }
	    			 temp = arr[j-1];  
	                 arr[j-1] = arr[j];  
	                 arr[j] = temp;  
	             } 
	         } 
	    	 if (!swap)
    			 break;
	    	 already = false;
	     }
	     return ret + 1;
	}
}
