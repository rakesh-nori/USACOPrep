import java.util.*;
import java.lang.*;
import java.io.*;
 
public class Problem5
{
  static class Bale {
    int w;
    boolean left;
    Bale(int weight, boolean L) {
      w = weight;
      left = L;
    }
  }
 
  static class Comp implements Comparator<Bale>
  {
    public int compare(Bale a, Bale b) {
      if (a.w < b.w) {
        return -1;
      }
      else if (a.w == b.w) {
          if (a.left) return -1;
        }
      return 1;
    }
  }
 
  public static void main (String[] args) throws java.lang.Exception
  {
    Scanner scan = new Scanner(System.in);
    int N, M;
    N = scan.nextInt();
    M = scan.nextInt();
    Bale[] bales = new Bale[2 * N];
 
    for (int i = 0; i < N; i++) {
      int leftStack = scan.nextInt();
      int rightStack = scan.nextInt();
      bales[i * 2] = new Bale(leftStack, true);
      bales[i * 2 + 1] = new Bale(rightStack, false);
    }

    Arrays.sort(bales, new Comp());

 
    int L = 0, R = 0;
    int i = 0;
    while(M - bales[i].w >= 0) {
      M -= bales[i].w;
      if (bales[i].left) L++;
      else R++;
      i++;
    }
 
    System.out.println((L + R));
    System.out.println(L + " " + R);
  }
}
