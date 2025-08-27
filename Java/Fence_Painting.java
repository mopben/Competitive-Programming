import java.io.*;
import java.util.StringTokenizer;
public class Fence_Painting{
    static BufferedReader r;
    static PrintWriter pw;
    static {
        try {
            r = new BufferedReader(new FileReader("paint.in"));
            pw = new PrintWriter(new FileWriter("paint.out"));
        } catch (IOException e) {}
    }
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(r.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(r.readLine());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int ans = (b - a) + (d - c);
        ans -= Math.max(Math.min(b,d) - Math.max(a,c),0);
        pw.println(ans);
        pw.close();
    }
}