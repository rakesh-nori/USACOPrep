
import java.util.*;
import java.lang.*;
import java.io.*;
 
public class Problem4
{
  public static void main (String[] args) throws java.lang.Exception
  {
    Scanner scan = new Scanner(System.in);
    int N, P;
    N = scan.nextInt();
    P = scan.nextInt();
    int ans = 0;
    for (int i = 0; i < P; i++) {
      int M = scan.nextInt();
      Vector<Integer> v = new Vector<>();
      for (int j = 0; j < M; j++) {
        int x;
        x = scan.nextInt();
        v.add(x);
      }
 
      int bessie = scan.nextInt();
      int L = 0, R = v.size(); //change is here
      while (L < R) {
        int mid = (L + R) / 2;
        if (v.get(mid) == bessie) {
          ans++;
          break;
        }
        if (v.get(mid) < bessie) {
          L = mid + 1;
        }
        else {
          R = mid - 1;
        }
      }
    }
 
    System.out.println(ans);
  }
}
