
import java.io.*;
import java.util.StringTokenizer;

public class WeirdAlgorithm{
    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(r.readLine());
        long n = Long.parseLong(st.nextToken());
        pw.print(n);
        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
            }
            else {
                n *= 3;
                n ++;
            }
            pw.print(" " + n);
        }
        pw.close();
    }
}