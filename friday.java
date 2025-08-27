
/*
ID: benqia51
LANG: JAVA
TASK: friday
*/

import java.io.*;
import java.util.StringTokenizer;

public class friday{
    static BufferedReader r;
    static PrintWriter pw;
    static {
        try {
            r = new BufferedReader(new FileReader("friday.in"));
            pw = new PrintWriter(new FileWriter("friday.out"));
        } catch(IOException e) {}
    }
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] ans = new int[7];
        int dayOfWeek = 1;
        for (int year = 1900; year < 1900 + n ; year ++) {
            for (int month = 1; month < 13; month ++) {
                for (int day = 0; day < findDays(month, year); day++) {
                    if (day == 13)
                        ans[dayOfWeek % 7] ++;
                    dayOfWeek ++;
                }
            }

        }
        for (int i = 0; i < 7; i ++) {
            pw.print(ans[i]);
            if (i != 6)
                pw.print(" ");
        }
        pw.print("\n");
        pw.close();
    }

    public static int findDays(int m, int y) {
        int days;
        if (m == 2 && (y % 4 == 0 && (y % 100 != 0 || y % 400 == 0)))
            days = 29;
        else if (m == 2)
            days = 28;
        else if (m == 4 || m == 6 || m == 9 || m == 11)
            days = 30;
        else
            days = 31;

        return days;
    }
}