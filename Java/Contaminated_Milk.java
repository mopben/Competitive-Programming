import java.io.*;
import java.util.StringTokenizer;
public class Contaminated_Milk{
    static BufferedReader r;
    static PrintWriter pw;
    static {
        try {
            r = new BufferedReader(new FileReader("badmilk.in"));
            pw = new PrintWriter(new FileWriter("badmilk.out"));
        } catch (IOException e) {}
    }
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(r.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[][] transcript = new int[d][3];
        int[][] sick = new int[s][2];

        for (int i = 0; i < d; i++) {
            st = new StringTokenizer(r.readLine());
            transcript[i][0] = Integer.parseInt(st.nextToken());
            transcript[i][0] -= 1;
            transcript[i][1] = Integer.parseInt(st.nextToken());
            transcript[i][1] -= 1;
            transcript[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < s; i++) {
            st = new StringTokenizer(r.readLine());
            sick[i][0] = Integer.parseInt(st.nextToken());
            sick[i][0] -= 1;
            sick[i][1] = Integer.parseInt(st.nextToken());
        }
        boolean[] possible = new boolean[m];
        for (int i = 0; i < m; i++) {
            int counter = 0;
            for (int j = 0; j < d; j++) {
                for (int k = 0; k < s; k++) {
                    if (transcript[j][1] == i && transcript[j][0] == sick[k][0] && transcript[j][2] < sick[k][1]){
                        counter ++;
                    }
                }

            }

            if (counter >= s)
                possible[i] = true;
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            if (possible[i]) {
                int counter = 0;
                boolean[] drank = new boolean[n];
                for (int j = 0; j < d; j++) {
                    if (transcript[j][1] == i && !drank[transcript[j][0]]) {
                        counter ++;
                        drank[transcript[j][0]] = true;

                    }
                }
                ans = Math.max(ans,counter);

            }
        }
        pw.print(ans);
        pw.close();
    }
}