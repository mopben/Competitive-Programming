import java.io.*;
import java.util.*;

public class BadHairDay {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException{

        int N = Integer.parseInt(r.readLine());

        long ans = 0;
        Stack<Integer> heights = new Stack<>();
        for (int i = 0; i < N; i ++) {
            int height = Integer.parseInt(r.readLine());

            while (!heights.isEmpty() && heights.peek() <= height) {
                heights.pop();
            }
            ans += heights.size();
            heights.add(height);
        }
        pw.println(ans);
        pw.close();
    }
}