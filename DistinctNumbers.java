import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class DistinctNumbers {
    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(r.readLine());
        HashSet<Integer> numbers = new HashSet<>();
        for (int i = 0; i < n; i ++) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }
        pw.println(numbers.size());
        pw.close();
    }
}