import java.io.*;
import java.util.*;

public class BinarySearch {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] elements = new int[n];
        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < n; i ++)
            elements[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < k ; i ++) {
            final int query = Integer.parseInt(st.nextToken());
            if (binarySearch(elements,query))
                pw.println("YES");
            else
                pw.println("NO");
        }
        pw.close();
    }
    public static boolean binarySearch(int[] arr, int goal) {
        int left = 0; int right = arr.length - 1;

        while (left < right) {
            int middle = (right + left + 1) / 2;

            if (arr[middle] <= goal)
                left = middle;
            else
                right = middle - 1;
        }
        if (arr[left] == goal)
            return true;
        else
            return false;
    }
}