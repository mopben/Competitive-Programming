import java.io.*;
import java.util.*;

public class CountingHaybales{

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);


    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("haybales.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("haybales.out"));

        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[] hayBales = new int[n];
        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < n; i ++)
            hayBales[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(hayBales);



        for (int i = 0; i < q; i ++) {
            st = new StringTokenizer(r.readLine());
            int low = Integer.parseInt(st.nextToken());
            int high = Integer.parseInt(st.nextToken());

            pw.println(binarySearch(hayBales, high) - binarySearch(hayBales, low - 1));
        }
        pw.close();


    }
    public static int binarySearch(int[] arr, int max) {
        int left = 0; int right = arr.length;
        while (left < right) {
            int mid = (left + right ) / 2;
            if (arr[mid] <= max)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}