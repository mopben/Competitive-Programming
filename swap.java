
import java.io.*;
import java.util.*;

public class swap{

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    static BufferedReader r;
    static PrintWriter pw;

    static {
        try {
            r = new BufferedReader(new FileReader("swap.in"));
            pw = new PrintWriter(new FileWriter("swap.out"));

        } catch(IOException e) {}
    }

    static int a1;
    static int a2;
    static int b1;
    static int b2;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(r.readLine());
        a1 = Integer.parseInt(st.nextToken());
        a2 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(r.readLine());
        b1 = Integer.parseInt(st.nextToken());
        b2 = Integer.parseInt(st.nextToken());

        int[] ans = new int[n];
        for (int i = 1; i <= n; i ++) {
            int pos = nextSwap(i);

            ArrayList<Integer> cycle = new ArrayList<>();
            cycle.add(i-1);
            cycle.add(pos-1);
            while (pos != i)  {
                pos = nextSwap(pos);
                cycle.add(pos - 1);
            }
            ans[cycle.get(k % (cycle.size()-1))] = i;
        }
        for (int i : ans)
            pw.println(i);

        pw.close();
    }
    public static int nextSwap(int pos) {
        if (pos >= a1 && pos <= a2)
            pos = a1 + a2 - pos;
        if (pos >= b1 && pos <= b2)
            pos = b1 + b2 - pos;

        return pos;
    }
}
