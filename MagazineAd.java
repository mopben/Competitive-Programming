import java.io.*;
import java.util.*;

public class MagazineAd {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    static int k;
    static List<Integer> lengths = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        k = Integer.parseInt(r.readLine());

        StringTokenizer st = new StringTokenizer(r.readLine());

        int lastPos = 0;
        int curPos = 0;
        while(st.hasMoreElements()) {
            char[] word = st.nextToken().toCharArray();

            for (int i = 0; i < word.length; i ++) {
                curPos ++;
                if (word[i] == '-') {
                    lengths.add(curPos - lastPos);
                    lastPos = curPos;
                }
            }
            lengths.add(st.hasMoreElements() ? curPos - lastPos + 1 : curPos - lastPos);
            lastPos = curPos;
        }

        long low = 0; long high = Integer.MAX_VALUE;
        while (low < high) {
            long mid = (low + high) / 2;

            if (checkValid(mid)) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }
        pw.println(high);
        pw.close();
    }
    public static boolean checkValid(long minWidth) {
        long width = Integer.MAX_VALUE;
        long lines = 0;
        for (int length : lengths) {
            if (width + length > minWidth) {
                lines ++;
                width = length;
            }
            else {
                width += length;
            }
            if (width > minWidth) {
                return false;
            }
        }
        return lines <= k;
    }
}
