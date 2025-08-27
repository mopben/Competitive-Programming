import java.io.*;
import java.util.*;
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    int n = Integer.parseInt(br.readLine());
    int[] petals = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i = 0; i < n; i++) {
      petals[i] = Integer.parseInt(st.nextToken());
    }
    int photos = 0;
    for(int i = 0; i < n; i++) {
      for(int j = i; j < n; j++) {
        int totalPetals = 0;
        for(int k = i; k <= j; k++) {
          totalPetals += petals[k];
        }
        boolean present = false;
        for(int k = i; k <= j; k++) {
          if(petals[k] * (j-i+1) == totalPetals) {
            present = true;
          }
        }
        if(present) {
          photos++;
        }
      }
    }
    pw.println(photos);
    pw.close();
  }
}