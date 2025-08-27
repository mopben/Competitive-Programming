import java.io.*;
import java.util.*;

public class BovineGenomicsSilver {

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    static int N;
    static char[][] spotty;
    static char[][] plain;
    public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("cownomics.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("cownomics.out"));

        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        spotty = new char[N][M];
        for (int i = 0; i < N; i ++) {
            spotty[i] = r.readLine().toCharArray();
        }
        plain = new char[N][M];
        for (int i = 0; i < N; i ++) {
            plain[i] = r.readLine().toCharArray();
        }

        int ans = 0;
        for (int i = 0; i < M; i ++) {
            for (int j = i + 1; j < M; j ++) {
                for (int k = j + 1; k < M; k ++) {
                    if (checkValid(i, j, k)) {
                        ans ++;
                    }
                }
            }
        }
        pw.println(ans);
        pw.close();
    }
    public static boolean checkValid(int pos1, int pos2, int pos3) {
        HashSet<Triplet> positions = new HashSet<>();
        for (int i = 0; i < N; i ++) {
            positions.add(new Triplet(spotty[i][pos1], spotty[i][pos2], spotty[i][pos3]));
        }
        for (int i = 0; i < N; i ++) {
            if (positions.contains(new Triplet(plain[i][pos1], plain[i][pos2], plain[i][pos3]))) {
                return false;
            }
        }
        return true;
    }
}
class Triplet {
    char i;
    char j;
    char k;

    public Triplet(char first, char second, char third) {
        i = first;
        j = second;
        k = third;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triplet triplet = (Triplet) o;
        return i == triplet.i && j == triplet.j && k == triplet.k;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, j, k);
    }
}
