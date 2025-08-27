import java.io.*;
import java.util.*;

public class MilkPailsSilver {

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    static final int MAX_SIZE = 101; //max size of the 2 milk pails
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("pails.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("pails.out"));

        StringTokenizer st = new StringTokenizer(r.readLine());

        final int X = Integer.parseInt(st.nextToken());
        final int Y = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        int ans = Integer.MAX_VALUE;

        int[][] operations = new int[MAX_SIZE][MAX_SIZE]; // if operations[y][x] == 0 then its not visited
        for (int i = 0; i < MAX_SIZE; i ++) {
            Arrays.fill(operations[i], -1);
        }

        Queue<Pair> next = new LinkedList<>();

        next.add(new Pair(0, 0));
        operations[0][0] = 0;

        while (!next.isEmpty()) {
            Pair node = next.poll();
            ans = Math.min(ans, Math.abs(M - (node.p1 + node.p2)));

            int pourX = Math.min(node.p1, Y - node.p2);
            int pourY = Math.min(X - node.p1, node.p2);

            int[] nX = {node.p1, 0, X, node.p1, node.p1 - pourX, node.p1 + pourY};
            int[] nY = {0, node.p2, node.p2, Y, node.p2 + pourX, node.p2 - pourY};

            if (!(operations[node.p1][node.p2] >= K)) {
                for (int k = 0; k < 6; k ++) {
                    if (operations[nX[k]][nY[k]] == -1) {
                        operations[nX[k]][nY[k]] = operations[node.p1][node.p2] + 1;
                        next.add(new Pair(nX[k], nY[k]));
                    }
                }
            }
        }
        pw.println(ans);
        pw.close();
    }
}
class Pair {
    int p1;
    int p2;

    public Pair(int p1, int p2) {
        this.p1 = p1;
        this.p2 = p2;
    }
}