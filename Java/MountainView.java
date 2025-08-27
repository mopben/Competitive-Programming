import java.io.*;
import java.util.*;

public class MountainView{

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    static BufferedReader r;
    static PrintWriter pw;

    static {
        try {
            r = new BufferedReader(new FileReader("mountains.in"));
            pw = new PrintWriter(new FileWriter("mountains.out"));

        } catch(IOException e) {}
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(r.readLine());
        ArrayList<Peak> peaks = new ArrayList<>();

        for (int i = 0; i < n; i ++) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            peaks.add(new Peak(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        Collections.sort(peaks);

        int largest = 0;
        int ans = n;
        for (Peak i : peaks) {
            if (largest >= i.x + i.y)
                ans --;
            largest = Math.max(largest,i.x + i.y);
        }
        pw.println(ans);
        pw.close();
    }
    static class Peak implements Comparable<Peak> {
        int x,y;
        public Peak(int X, int Y){
            x = X;
            y = Y;
        }
        public int compareTo(Peak a) {
            if (x - y == a.x - a.y)
                return Integer.compare(a.x + a.y,x + y);
            return Integer.compare(x-y,a.x-a.y);
        }
    }
}

