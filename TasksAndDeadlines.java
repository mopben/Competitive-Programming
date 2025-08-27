import java.io.*;
import java.util.*;

public class TasksAndDeadlines {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        //BufferedReader r = new BufferedReader(new FileReader("measurement.in"));
        //PrintWriter pw = new PrintWriter(new FileWriter("measurement.out"));
        int n = Integer.parseInt(r.readLine());

        int[][] tasks = new int[n][2];
        for (int i = 0; i < n; i ++) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            tasks[i][0] = Integer.parseInt(st.nextToken());
            tasks[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(tasks, Comparator.comparingInt(value -> value[0]));
        long time = 0;
        long ans = 0;
        for (int i = 0; i < n; i ++) {
            time += tasks[i][0];
            ans += tasks[i][1] - time;
        }
        pw.println(ans);
        pw.close();
    }
}