import java.util.StringTokenizer;

public class Apple_Division{
    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);
    static int n;
    static int[] apples;

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(r.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(r.readLine());
        apples = new int[n];
        for (int i = 0; i < n; i ++){
            apples[i] = Integer.parseInt(st.nextToken());
        }
        pw.print(solve(0,0,0));
        pw.close();
    }
    static long solve(int i, long s1, long s2) {
        if (i == n)
            return Math.abs(s1 - s2);
        return Math.min(solve(i+1,s1+apples[i],s2),solve(i+1,s1,s2+apples[i]));
    }
}
