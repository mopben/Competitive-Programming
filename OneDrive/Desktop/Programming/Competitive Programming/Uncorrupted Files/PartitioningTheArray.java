import java.io.*;
import java.util.*;

public class PartitioningTheArray {

    private static final BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(r.readLine());
        for (int i = 0; i < t; i ++) {
            int n = Integer.parseInt(r.readLine());

            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(r.readLine());
            for (int j = 0; j < n; j ++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            int ans = 0;

            for (int k = 1; k <= n; k ++) {
                if (n % k == 0) {
                    int[] test = new int[n - k];
                    for (int element = 0; element < n - k; element ++) {
                        test[element] = Math.abs(arr[element] - arr[element + k]);
                    }

                    int gcd = findGCD(test);
                    if (gcd >= 2 || gcd == 0) {
                        ans ++;
                    }
                }
            }
            System.out.println(ans);
        }
    }

    public static int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    public static int findGCD(int arr[])
    {
        if (arr.length == 0) {
            return 2;
        }
        int result = arr[0];
        for (int i = 1; i < arr.length; i++)
        {
            result = gcd(arr[i], result);

            if(result == 1)
            {
                return 1;
            }
        }
        return result;
    }
}
	