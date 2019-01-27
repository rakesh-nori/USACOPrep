import java.util.*;
import java.lang.*;
import java.io.*;
 
public class Two
{
  public static int N;
  public static int[] X = new int[1005];
  public static int[] Y = new int[1005];
 
  public static double get_slope(int i, int j) {
    if (X[j] - X[i] == 0) return 1e18;
    return ((double)Y[j] - Y[i]) / (X[j] - X[i]);
  }
 
  public static void main (String[] args) throws java.lang.Exception
  {
    Scanner scan = new Scanner(System.in);
    N = scan.nextInt();
    for (int i = 0; i < N; i++) {
      X[i] = scan.nextInt();
      Y[i] = scan.nextInt();
    }
    Vector<Double> slopes = new Vector<>();
    for (int i = 0; i < N; i++) {
      for (int j = i + 1; j < N; j++) {
        slopes.add(get_slope(i, j));
      }
    }
    Collections.sort(slopes);
    int ans = 1;
    for (int i = 1; i < N; i++) {
      if (Double.compare(slopes.get(i), slopes.get(i - 1)) != 0) {
        ans++;
      }
    }
    System.out.println(ans);
  }
}



