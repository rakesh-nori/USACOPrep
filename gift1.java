/*
ID: 20rakes1

LANG: JAVA
TASK: gift1
*/
import java.util.*;
import java.io.*;
public class gift1 
{
	public static void main(String[] args) throws IOException
	{
		//BufferedReader br = new BufferedReader(new FileReader("gift1.in"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter pw = new PrintWriter(new FileWriter("gift1.out"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		Object[][] vals = new Object[n][2];
		for (int i = 0; i < n; i++)
		{
			String s = br.readLine();
			//System.out.println(s);
			vals[i][0] = s;
			vals[i][1] = (Integer)0;
		}
		String s = br.readLine();
		while(s != null)
		{
			if (s.isEmpty())
				break;
			String a = br.readLine();
			st = new StringTokenizer(a);
			int m = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int add = 0;
			int ret = 0;
			if (m != 0)
			{
				add = m/p;
				//System.out.println(add);
				ret = (m/p) * p;
				//System.out.println(ret);
			}
			for (int i = 0; i < n; i++)
				if (vals[i][0].equals(s))
				{
					Integer val = (Integer)vals[i][1];
					val -= ret;
					vals[i][1] = val;
					break;
				}
			for (int i = 0; i < p; i++)
			{
				String temp = br.readLine();
				//System.out.println(temp);
				for (int j = 0; j < n; j++)
				{
					if (vals[j][0].equals(temp))
					{
						Integer val = (Integer)vals[j][1];
						//System.out.println(val + " BEFORE");
						val += add;
						//System.out.println(val + " ADD");
						vals[j][1] = val;
						break;
					}
				}
			}
			s = br.readLine();
		}
		for (int i = 0; i < n; i++)
		{
			System.out.println(vals[i][0] + " " + vals[i][1]);
			//pw.println(vals[i][0] + " " + vals[i][1]);
			
		}
		//pw.close();
		br.close();
		
	}
}
