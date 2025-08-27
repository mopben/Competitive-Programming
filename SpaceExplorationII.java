import java.util.*;

public class SpaceExplorationII {


    public static void main(String[] args) {
        solve();
    }

    public static void solve(){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        char[][] grid = new char[N][N];
        for (int i = 0; i < N; i ++) {
            String temp = sc.next();
            for (int j = 0; j < N; j ++) {
                grid[i][j] = temp.charAt(j);
            }
        }

        final int[] dX = {1, -1, 0, 0};
        final int[] dY = {0, 0, 1, -1};
        boolean[][] visited = new boolean[N][N];
        int ans = 0;

        for (int i = 0; i < N; i ++) {
            for (int j = 0; j < N; j ++) {
                if (!visited[i][j] && grid[i][j] == '*') {
                    //bfs------------------------------------------------------
                    Queue<Integer> nextX = new LinkedList<>();
                    Queue<Integer> nextY = new LinkedList<>();

                    nextX.add(j);
                    nextY.add(i);
                    while (!nextX.isEmpty() && !nextY.isEmpty()) {
                        int x = nextX.poll();
                        int y = nextY.poll();

                        for (int k = 0; k < 4; k ++) {
                            int nX = x + dX[k];
                            int nY = y + dY[k];

                            if (nX >= 0 && nX < N && nY >= 0 && nY < N && !visited[nY][nX] && grid[nY][nX] == '*') {
                                nextX.add(nX);
                                nextY.add(nY);
                                visited[nY][nX] = true;
                            }
                        }
                    }
                    ans ++;
                }
            }
        }
        System.out.println(ans);
    }
}


