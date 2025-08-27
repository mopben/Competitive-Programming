import java.io.*;
import java.util.*;

public class BlockedBillboardII{

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    static int a1;
    static int b1;
    static int a2;
    static int b2;
    public static void main(String[] args) throws IOException {
	BufferedReader r = new BufferedReader(new FileReader("billboard.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("billboard.out"));

        StringTokenizer st = new StringTokenizer(r.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(r.readLine());
        a1 = Integer.parseInt(st.nextToken());
        b1 = Integer.parseInt(st.nextToken());
        a2 = Integer.parseInt(st.nextToken());
        b2 = Integer.parseInt(st.nextToken());

        int corners = 0;
        corners += checkCorner(x1, y1);
        corners += checkCorner(x1, y2);
        corners += checkCorner(x2, y1);
        corners += checkCorner(x2, y2);

        final int area = (x2 - x1) * (y2 - y1);
        if (corners == 0 || corners == 1)
            System.out.println(area);
        else if (corners == 4)
            System.out.println(0);
        else {
            int leftX = Math.max(x1, a1);
            int rightX = Math.min(x2, a2);
            int bottomY = Math.max(y1, b1);
            int topY = Math.min(y2, b2);
            int coveredArea = (rightX - leftX) * (topY - bottomY);
            System.out.println(area - coveredArea);
        }
    }
    public static int checkCorner(int x1, int y1) {
        if (a1 <= x1 && a2 >= x1 && b1 <= y1 && b2 >= y1)
            return 1;
        return 0;
    }
}
