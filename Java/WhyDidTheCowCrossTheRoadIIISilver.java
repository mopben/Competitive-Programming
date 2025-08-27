import java.io.*;
import java.util.*;

public class WhyDidTheCowCrossTheRoadIIISilver{

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    static int N;
    static boolean[][] cowLoc;
    static boolean[][] visited;
    static int originalR;
    static int originalC;
    static HashMap<Pair, HashSet<Pair>> roads;
    static HashMap<Pair, HashSet<Pair>> pairs = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("countcross.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("countcross.out"));
        
        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(st.nextToken());
        final int R = Integer.parseInt(st.nextToken());

        roads = new HashMap<>();
        for (int i = 0; i < N; i ++) {
            for (int j = 0; j < N; j ++)
                roads.put(new Pair(i,j), new HashSet<>());
        }

        for (int i = 0; i < R; i ++) {
            st = new StringTokenizer(r.readLine());
            Pair cord1 = new Pair(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
            Pair cord2 = new Pair(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
            roads.get(cord1).add(cord2);
            roads.get(cord2).add(cord1);
        }
        cowLoc = new boolean[N][N];
        for (int i = 0; i < K; i ++) {
            st = new StringTokenizer(r.readLine());
            int row = Integer.parseInt(st.nextToken()) - 1;
            int col = Integer.parseInt(st.nextToken()) - 1;
            pairs.put(new Pair(row,col), new HashSet<>());
            cowLoc[row][col] = true;
        }

        for (Pair i : pairs.keySet()) {
            visited = new boolean[N][N];
            originalR = i.row;
            originalC = i.column;
            floodFill(i.row, i.column, i.row, i.column);
        }
        final int NUM_PAIRS = (K * (K-1)) / 2;
        HashSet<HashSet<Pair>> pairsCounted = new HashSet<>();
        for (Pair i : pairs.keySet()) {
            for (Pair j : pairs.get(i)) {
                if (!new Pair(i.row, i.column).equals(new Pair(j.row, j.column)))
                pairsCounted.add(new HashSet<>(Arrays.asList(new Pair(i.row,i.column), new Pair(j.row, j.column))));
            }
        }

        pw.println(NUM_PAIRS - pairsCounted.size());
        pw.close();
    }
    public static void floodFill(int r, int c, int prevR, int prevC) {
        if (r < 0 || r >= N || c < 0 || c >= N)
            return;

        if (visited[r][c] || roads.get(new Pair(prevR, prevC)).contains(new Pair(r,c)))
            return;

        if (cowLoc[r][c])
            pairs.get(new Pair(originalR, originalC)).add(new Pair(r,c));


        visited[r][c] = true;
        floodFill(r+1, c, r, c);
        floodFill(r-1, c, r, c);
        floodFill(r, c+1, r, c);
        floodFill(r, c-1, r, c);
    }

}
class Pair {
    int row;
    int column;
    public Pair(int r, int c) {
        row = r;
        column = c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return row == pair.row && column == pair.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
    @Override
    public String toString() {
        return "(" +  this.row + "," + this.column + ")";
    }
}