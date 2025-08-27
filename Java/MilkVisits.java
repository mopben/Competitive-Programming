import java.io.*;
import java.util.*;

public class MilkVisits {

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    static ArrayList<Integer>[] farms;
    static char[] breeds;
    static int[] connected;
    static int nextGroup = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("milkvisits.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("milkvisits.out"));

        StringTokenizer st = new StringTokenizer(r.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        farms = new ArrayList[N];
        for (int i = 0; i < N; i ++) {
            farms[i] = new ArrayList<>();
        }
        breeds = r.readLine().toCharArray();

        for (int i = 0; i < N - 1; i ++) {
            st = new StringTokenizer(r.readLine());
            int farm1 = Integer.parseInt(st.nextToken()) - 1;
            int farm2 = Integer.parseInt(st.nextToken()) - 1;
            farms[farm1].add(farm2);
            farms[farm2].add(farm1);
        }

        connected = new int[N];
        Arrays.fill(connected, -1);
        findConnected(0,0);

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < M; i ++) {
            st = new StringTokenizer(r.readLine());
            int farm1 = Integer.parseInt(st.nextToken()) - 1;
            int farm2 = Integer.parseInt(st.nextToken()) - 1;
            char favMilk = st.nextToken().charAt(0);

            if (breeds[farm1] == favMilk || breeds[farm2] == favMilk) {
                ans.append(1);
            }
            else if (connected[farm1] != connected[farm2]) {
                ans.append(1);
            }
            else {
                ans.append(0);
            }
        }
        pw.println(ans);
        pw.close();
    }
    public static void findConnected(int node, int connectedGroup) {
        connected[node] = connectedGroup;

        for (int i : farms[node]) {
            if (connected[i] == -1) {
                if (breeds[i] != breeds[node]) {
                    nextGroup ++;
                    findConnected(i, nextGroup);
                }
                else {
                    findConnected(i, connectedGroup);
                }
            }
        }
    }
}
