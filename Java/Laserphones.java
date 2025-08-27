import java.io.*;
import java.util.*;

public class Laserphones {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    static int W;
    static int H;
    static char[][] pasture;

    public static void main(String[] args) throws IOException{

        StringTokenizer st = new StringTokenizer(r.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        pasture = new char[H][W];
        for (int i = 0; i < H; i ++) {
            pasture[i] = r.readLine().toCharArray();
        }

        loop : for (int x = 0; x < W; x ++) {
            for (int y = 0; y < H; y ++) {
                if (pasture[y][x] == 'C') {
                    pw.println(bfs(new Node(x, y, -1, true, true)));
                    break loop;
                }
            }
        }
        pw.close();
    }
    public static int bfs(Node start) {
        boolean[][] visited = new boolean[H][W];
        visited[start.y][start.x] = true;

        Queue<Node> next = new LinkedList<>();
        next.add(start);

        while (!next.isEmpty()) {
            Node node = next.poll();

            if (pasture[node.y][node.x] == 'C' && node.dis != -1) {
                return node.dis;
            }

            if (node.goingX) {
                for (int x = node.x; x >= 0; x --) {
                    if (pasture[node.y][x] == '*') {
                        break;
                    }
                    if (!visited[node.y][x]) {
                        next.add(new Node(x, node.y, node.dis + 1, false, true));
                        visited[node.y][x] = true;
                    }
                }
                for (int x = node.x; x < W; x ++) {
                    if (pasture[node.y][x] == '*') {
                        break;
                    }
                    if (!visited[node.y][x]) {
                        next.add(new Node(x, node.y, node.dis + 1, false, true));
                        visited[node.y][x] = true;
                    }
                }
            }
            if (node.goingY) {
                for (int y = node.y; y >= 0; y --) {
                    if (pasture[y][node.x] == '*') {
                        break;
                    }
                    if (!visited[y][node.x]) {
                        next.add(new Node(node.x, y, node.dis + 1, true, false));
                        visited[y][node.x] = true;
                    }
                }
                for (int y = node.y; y < H; y ++) {
                    if (pasture[y][node.x] == '*') {
                        break;
                    }
                    if (!visited[y][node.x]) {
                        next.add(new Node(node.x, y, node.dis + 1, true, false));
                        visited[y][node.x] = true;
                    }
                }
            }
        }
        return 0; //should never be reached
    }
}
class Node {
    int x;
    int y;
    int dis;
    boolean goingX;
    boolean goingY;

    public Node(int x, int y, int dis, boolean goingX, boolean goingY) {
        this.x = x;
        this.y = y;
        this.dis = dis;
        this.goingX = goingX;
        this.goingY = goingY;
    }
}