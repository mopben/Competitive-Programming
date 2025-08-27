/*
ID: benqia51
LANG: JAVA
TASK: milk2
*/

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;
import java.io.*;
import java.util.StringTokenizer;

public class milk2{

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);


    static BufferedReader r;
    static PrintWriter pw;
    static {
        try {
            r = new BufferedReader(new FileReader("milk2.in"));
            pw = new PrintWriter(new FileWriter("milk2.out"));
        } catch(IOException e) {}
    }



    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] events = new int[n*2][2];
        for (int i = 0; i < n*2; i +=2) {
            st = new StringTokenizer(r.readLine());
            events[i][0] = Integer.parseInt(st.nextToken());
            events[i][1] = 1;
            events[i+1][0] = Integer.parseInt(st.nextToken());
            events[i+1][1] = -1;
        }
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));

        int maxInterval = 0;
        int minInterval = 999999999;
        int counter = 0;
        int interval = 0;
        int lastEvent = 0;

        for (int i = 0; i < n*2; i++) {
            if (counter <= 0){
                minInterval = Math.min(minInterval,events[i][0] - lastEvent);
                lastEvent = events[i][0];
                interval = 0;
            }

            counter += events[i][1];
            interval += events[i][0] - lastEvent;
            lastEvent = events[i][0];

            maxInterval = Math.max(interval,maxInterval);
        }
        System.out.println(maxInterval + " " + minInterval);
    }
}