import java.io.*;
import java.util.*;

public class HoofPaperScissors {

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
	BufferedReader r = new BufferedReader(new FileReader("hps.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("hps.out"));

        int N = Integer.parseInt(r.readLine());

        int[][] games = new int[3][3];
        for (int i = 0; i < N; i ++) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            games[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] ++;
        }
        pw.println(Math.max(games[1][0] + games[0][2] + games[2][1], games[0][1] + games[2][0] + games[1][2]));
        pw.close();
    }
}