
import java.io.*;
import java.util.*;

public class MusicNotes {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        //BufferedReader r = new BufferedReader(new FileReader("snowboots.in"));
        //PrintWriter pw = new PrintWriter(new FileWriter("snowboots.out"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[] note = new int[10_001];
        int beat = 0;
        for (int i = 1; i <= n; i ++) {
            int beatTime = Integer.parseInt(r.readLine());

            for (int j = beat; j < beat + beatTime; j ++) {
                note[j] = i;
            }
            beat += beatTime;
        }
        for (int i = 0; i < q; i ++) {
            int query = Integer.parseInt(r.readLine());
            pw.println(note[query]);
        }
        pw.close();
    }
}
