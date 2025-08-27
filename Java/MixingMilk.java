
import java.io.*;
import java.util.StringTokenizer;

public class MixingMilk {
    static BufferedReader r;
    static PrintWriter pw;
    static {
        try {
            r = new BufferedReader(new FileReader("mixmilk.in"));
            pw = new PrintWriter(new FileWriter("mixmilk.out"));
        }catch(IOException e) {}
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(r.readLine());
        int c1 = Integer.parseInt(st.nextToken());
        int m1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(r.readLine());
        int c2 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(r.readLine());
        int c3 = Integer.parseInt(st.nextToken());
        int m3 = Integer.parseInt(st.nextToken());

        int milkPoured = 1;
        for (int i = 0; i < 100; i++) {
            if (milkPoured == 1) {
                int temp = Math.min(m1, c2 - m2);
                m1 -= temp;
                m2 += temp;
                milkPoured = 2;
            }else if (milkPoured == 2) {
                int temp = Math.min(m2, c3 - m3);
                m2 -= temp;
                m3 += temp;
                milkPoured = 3;
            }
            else {
                int temp = Math.min(m3, c1 - m1);
                m3 -= temp;
                m1 += temp;
                milkPoured = 1;
            }
        }
        pw.println(m1);
        pw.println(m2);
        pw.println(m3);
        pw.close();
    }
}
