import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Apartments {
    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(r.readLine());
        int[] applicants = new int[n];
        for (int i = 0; i < n; i++) {
            applicants[i] = Integer.parseInt(st.nextToken());
        }
        int[] apartments = new int[m];
        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < m; i++) {
            apartments[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(applicants);
        Arrays.sort(apartments);
        int apartment = 0;
        int applicant = 0;
        int counter = 0;

        while (applicant < n && apartment < m) {
            if (Math.abs(applicants[applicant] - apartments[apartment]) <= k) {
                counter ++;
                applicant ++;
                apartment ++;

            }else if (applicants[applicant] - apartments[apartment] > k)
                apartment ++;

            else
                applicant ++;

        }
        pw.println(counter);
        pw.close();
    }
}