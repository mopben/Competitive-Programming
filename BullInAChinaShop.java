import java.io.*;
import java.util.*;

public class Main {

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    public static int N;
    static char[][][] pieces;
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("bcs.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("bcs.out"));

        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(st.nextToken());

        char[][] goal = new char[N][N];
        for (int i = 0; i < N; i ++)
            goal[i] = r.readLine().toCharArray();


        pieces = new char[K][N][N];
        for (int i = 0; i < K; i ++) {
            for (int j = 0; j < N; j ++)
                pieces[i][j] = r.readLine().toCharArray();
        }
        for (int i = 0; i < K; i ++) {
            for (int j = i+1; j < K; j ++) {
                for (int iX = -N+1; iX < N; iX ++) {
                    for (int iY = -N+1; iY < N; iY ++) {
                        for (int jX = -N+1; jX < N; jX ++) {
                            for (int jY = -N+1; jY < N; jY ++ ) {

                                boolean valid = true;
                                for (int x = 0; x < N; x ++) {
                                    for (int y = 0; y < N; y ++) {
                                        char figureOne = check(i,x - iX,y - iY);
                                        char figureTwo = check(j,x - jX,y - jY);

                                        if (figureOne == '#' && figureTwo == '#')
                                            valid = false;
                                        if (goal[y][x] != figureOne && goal[y][x] != figureTwo)
                                            valid = false;
                                        if ((figureOne == '#' || figureTwo == '#') && goal[y][x] == '.' )
                                            valid = false;
                                        if (!valid)
                                            break;
                                    }
                                    if (!valid)
                                        break;
                                }
                                if (valid) {
                                    i ++; j ++;
                                    pw.println(i + " " + j);
                                    pw.close();
                                    System.exit(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    public static char check(int pieceNum,int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= N)
            return '.';

        return pieces[pieceNum][y][x];
    }
}