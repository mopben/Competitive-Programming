import java.io.*;
import java.util.*;

public class BoringBuisness{

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        boolean[][] visited = new boolean[402][200]; //accidentally switched x and y
        //well plan
        visited[201][0] = true; visited[201][1] = true; visited[201][2] = true;
        visited[202][2] = true; visited[203][2] = true; visited[204][2] = true;
        visited[204][3] = true; visited[204][4] = true; visited[205][4] = true;
        visited[206][4] = true; visited[206][3] = true; visited[206][2] = true;
        visited[207][2] = true; visited[208][2] = true; visited[208][3] = true;
        visited[208][4] = true; visited[208][5] = true; visited[208][6] = true;
        visited[208][7] = true;visited[208][8] = true; visited[207][8] = true;
        visited[206][8] = true; visited[205][8] = true; visited[204][8] = true;
        visited[203][8] = true; visited[202][8] = true; visited[201][8] = true;
        visited[200][8] = true; visited[200][7] = true; visited[200][6] = true;

        int x = -1;
        int y = -5;
        boolean first = true;
        while (true) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            char dir = st.nextToken().charAt(0);
            int len = Integer.parseInt(st.nextToken());

            if (dir == 'q')
                break;

            boolean danger = false;
            while (len > 0) {
                if (visited[x + 201][Math.abs(y)-1] && !first)
                    danger = true;

                first = false;
                visited[x + 201][Math.abs(y)-1] = true;
                if (dir == 'd')
                    y --;
                if (dir == 'u')
                    y ++;
                if (dir == 'l')
                    x --;
                if (dir == 'r')
                    x ++;
                len --;
            }
            if (danger) {
                pw.println(x + " " + y + " danger");
                break;
            }
            else
                pw.println(x + " " + y + " safe");
        }
        pw.close();
    }
}