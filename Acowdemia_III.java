import java.io.*;
import java.util.*;

public class Acowdemia_III{

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] board = new char[n][m];
        for (int i = 0; i < n; i ++) {
            board[i] = r.readLine().toCharArray();
        }
        HashSet<HashSet<Pair>> friends = new HashSet<>();
        int ans = 0;
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                int counter = 0;
                if (board[i][j] == 'G') {
                    HashSet<Pair> adjacent = new HashSet<>();

                    if (i > 0) {
                        if (board[i-1][j] == 'C') {
                            counter ++;
                            adjacent.add(new Pair(i-1,j));
                        }
                    }
                    if (i < n-1) {
                        if (board[i+1][j] == 'C') {
                            counter ++;
                            adjacent.add(new Pair(i+1,j));
                        }
                    }
                    if (j > 0) {
                        if (board[i][j-1] == 'C') {
                            counter ++;
                            adjacent.add(new Pair(i,j-1));
                        }
                    }
                    if (j < m-1) {
                        if (board[i][j+1] == 'C') {
                            counter ++;
                            adjacent.add(new Pair(i,j+1));
                        }
                    }
                    if (counter > 2)
                        ans ++;
                    else if (counter == 2)
                        friends.add(adjacent);
                }
            }
        }
        pw.println(ans + friends.size());
        pw.close();
    }
    public static class Pair {
        int x;
        int y;
        public Pair(int a, int b) {
            x = a;
            y = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}