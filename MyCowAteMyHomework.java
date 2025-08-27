import java.io.*;
import java.util.*;

public class MyCowAteMyHomework {

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("homework.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("homework.out"));

        int n = Integer.parseInt(r.readLine());

        int[] scores = new int[n];
        StringTokenizer st = new StringTokenizer(r.readLine());
        for (int i = 0; i < n; i ++)
            scores[i] = Integer.parseInt(st.nextToken());

        ArrayList<Integer> ans = new ArrayList<>();

        int min = Integer.MAX_VALUE;
        double max = 0;
        int sum = scores[n-1];

        for (int i = n-2; i >= 1; i --) {
            min = Math.min(min, scores[i]);
            sum += scores[i];
            double avg = (((sum - min) * 1.0) / (n-i-1));
            if (avg > max) {
                max = avg;
                ans.clear();
                ans.add(i);
            }
            else if (avg == max)
                ans.add(i);
        }
        Collections.sort(ans);
        for (int i : ans)
            pw.println(i);

        pw.close();
    }
}