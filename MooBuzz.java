import java.io.*;
import java.util.*;

public class MooBuzz {

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("moobuzz.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("moobuzz.out"));

        final int N = Integer.parseInt(r.readLine());

        long low = 0; long high = Integer.MAX_VALUE;
        long checkAround = 0;
        while (low < high) {
            long middle = (low + high) / 2;
            long moos = (middle / 3) + (middle / 5) - (middle / 15);

            if (middle - moos == N) {
                checkAround = middle;
                break;
            }
            if (middle - moos > N) {
                high = middle;
            }
            else {
                low = middle + 1;
            }
        }

        for (long i = checkAround - 5; i <= checkAround + 5; i ++) {
            long moos = (i / 3) + (i / 5) - (i / 15);
            if (i - moos == N && i % 3 != 0 && i % 5 != 0) {
                pw.println(i);
                break;
            }
        }
        pw.close();

    }
}
