import java.io.*;
import java.util.*;

public class BlockedBillboard {

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
	BufferedReader r = new BufferedReader(new FileReader("billboard.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("billboard.out"));

        StringTokenizer st = new StringTokenizer(r.readLine());
        int x1 = Integer.parseInt(st.nextToken()) + 1000;
        int y1 = Integer.parseInt(st.nextToken()) + 1000;
        int x2 = Integer.parseInt(st.nextToken()) + 1000;
        int y2 = Integer.parseInt(st.nextToken()) + 1000;
        st = new StringTokenizer(r.readLine());
        int x3 = Integer.parseInt(st.nextToken()) + 1000;
        int y3 = Integer.parseInt(st.nextToken()) + 1000;
        int x4 = Integer.parseInt(st.nextToken()) + 1000;
        int y4 = Integer.parseInt(st.nextToken()) + 1000;
        st = new StringTokenizer(r.readLine());
        int a1 = Integer.parseInt(st.nextToken()) + 1000;
        int b1 = Integer.parseInt(st.nextToken()) + 1000;
        int a2 = Integer.parseInt(st.nextToken()) + 1000;
        int b2 = Integer.parseInt(st.nextToken()) + 1000;

        boolean[][] boards = new boolean[2002][2002];
        for (int i = x1; i < x2; i ++) {
            for (int j = y1; j < y2; j ++) {
                boards[i][j] = true;
            }
        }
        for (int i = x3; i < x4; i ++) {
            for (int j = y3; j < y4; j ++) {
                boards[i][j] = true;
            }
        }
        for (int i = a1; i < a2; i ++) {
            for (int j = b1; j < b2; j ++) {
                boards[i][j] = false;
            }
        }
        int ans = 0;
        for (int i = 0; i < 2002; i ++) {
            for (int j = 0; j < 2002; j ++) {
                if (boards[i][j])
                    ans ++;
            }
        }
        System.out.println(ans);
    }
}