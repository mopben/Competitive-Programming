/*
ID: benqia51
LANG: JAVA
TASK: castle
*/

import java.io.*;
import java.util.*;

public class castle{

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    
    static BufferedReader r;
    static PrintWriter pw;

    static {
        try {
            r = new BufferedReader(new FileReader("castle.in"));
            pw = new PrintWriter(new FileWriter("castle.out"));

        } catch(IOException e) {}
    }

     
    static int[][][] castle;
    static boolean[][] visited;
    static int m;
    static int n;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(r.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        HashMap<Integer, HashSet<Integer>> decoder = new HashMap<>();
        for (int i = 1; i <= 4; i ++) {
            for (ArrayList<Integer> j : combinations(new int[]{1,2,4,8},i))
                decoder.put(sum(j), new HashSet<>(j));
        }

        castle = new int[n][m][4];
	decoder.put(0, new HashSet<>());
        for (int i = 0; i < n; i ++) {
            st = new StringTokenizer(r.readLine());
            for (int j = 0; j < m; j ++) {
                int val = Integer.parseInt(st.nextToken());

                if (!decoder.get(val).contains(1))
                    castle[i][j][0] = 1;
                if (!decoder.get(val).contains(2))
                    castle[i][j][1] = 1;
                if (!decoder.get(val).contains(4))
                    castle[i][j][2] = 1;
                if (!decoder.get(val).contains(8))
                    castle[i][j][3] = 1;
            }
        }
        visited = new boolean[n][m];
        int rooms = 0;
        int maxRoom = 0;
        for (int y = 0; y < n; y ++) {
            for (int x = 0; x < m; x ++) {
                if (!visited[y][x])  {
                    rooms ++;
                    maxRoom = Math.max(maxRoom,solve(x,y,0));
                }
            }
        }
        pw.println(rooms);
        pw.println(maxRoom);
        int[] removedWall = new int[3];
        for (int x = 0; x < m; x ++) {
            for (int y = n-1; y >= 0; y --) {
                if (y != 0 && castle[y][x][1] == 0) {
                    for (int i = 0; i < n; i ++)
                        Arrays.fill(visited[i],false);

                    castle[y][x][1] = 1;
                    castle[y-1][x][3] = 1;
                    int size = solve(x,y,0);
                    if (size > maxRoom) {
                        maxRoom = size;
                        removedWall[0] = y;
                        removedWall[1] = x;
                        removedWall[2] = 2;
                    }
                    castle[y][x][1] = 0;
                    castle[y-1][x][3] = 0;
                }
                if (x != m-1 && castle[y][x][2] == 0) {
                    for (int i = 0; i < n; i ++)
                        Arrays.fill(visited[i],false);

                    castle[y][x][2] = 1;
                    castle[y][x+1][0] = 1;
                    int size = solve(x,y,0);
                    if (size > maxRoom) {
                        maxRoom = size;
                        removedWall[0] = y;
                        removedWall[1] = x;
                        removedWall[2] = 3;
                    }
                    castle[y][x][2] = 0;
                    castle[y][x+1][0] = 0;
                }
            }
        }
        pw.println(maxRoom);
        removedWall[0] ++;
        removedWall[1] ++;
        pw.print(removedWall[0]+ " " + removedWall[1]+ " ");
        if (removedWall[2] == 2)
            pw.print('N');
        else
            pw.print('E');
	pw.println();
        pw.close();
    }

    public static int solve(int x, int y, int size) {

        if (y < 0 || y >= n || x < 0 || x >= m || visited[y][x])
            return 0;


        size ++;
        visited[y][x] = true;
        if (check(x,y,x,y+1))
            size = solve(x,y+1,size);

        if (check(x,y,x,y-1))
            size = solve(x,y-1,size);

        if (check(x,y,x+1,y))
            size = solve(x+1,y,size);

        if (check(x,y,x-1,y))
            size = solve(x-1,y,size);

        return size;
    }
    public static boolean check(int x1, int y1, int x2, int y2) {
        if (y2 < 0 || y2 >= n || x2 < 0 || x2 >= m || visited[y2][x2])
            return false;

        return ((x2 < x1 && castle[y1][x1][0] == castle[y2][x2][2] && castle[y1][x1][0] == 1) || (x2 > x1 && castle[y1][x1][2] == castle[y2][x2][0] && castle[y1][x1][2] == 1) || (y2 < y1 && castle[y1][x1][1] == castle[y2][x2][3] && castle[y1][x1][1] == 1) || (y2 > y1 && castle[y1][x1][3] == castle[y2][x2][1] && castle[y1][x1][3] == 1));
    }


    public static ArrayList<ArrayList<Integer>> combinations(int[] arr, int r) {
        ArrayList<ArrayList<Integer>> combinations = new ArrayList<>();
        int n = arr.length;
        int[] indices = new int[r];

        for (int i = 0; i < r; i++)
            indices[i] = i;

        ArrayList<Integer> pair = new ArrayList<>();
        for (int i : indices) {
            pair.add(arr[i]);
        }
        combinations.add(pair);

        int lastI = 0;
        boolean broke;
        while (true) {
            broke = false;
            for (int i = r - 1; i >= 0; i--) {
                lastI = i;
                if (indices[i] != i + n - r) {
                    broke = true;
                    break;
                }
            }
            if (!broke)
                return combinations;

            indices[lastI]++;
            for (int i = lastI + 1; i < r; i++)
                indices[i] = indices[i - 1] + 1;

            pair = new ArrayList<>();
            for (int i : indices) {
                pair.add(arr[i]);
            }
            combinations.add(pair);
        }
    }
    public static int sum(List<Integer> arr) {
        int sum = 0;
        for (int i : arr)
            sum += i;
        return sum;
    }
}