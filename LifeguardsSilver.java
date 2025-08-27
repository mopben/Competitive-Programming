import java.io.*;
import java.util.*;

public class LifeguardsSilver{

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    static BufferedReader r;
    static PrintWriter pw;

    static {
        try {
            r = new BufferedReader(new FileReader("lifeguards.in"));
            pw = new PrintWriter(new FileWriter("lifeguards.out"));

        } catch(IOException e) {}
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(r.readLine());
        Event[] events = new Event[2*n];

        for (int i = 0; i < n; i ++) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            events[2 * i] = new Event(start,i,1);
            events[2 * i + 1] = new Event(end, i, 0);
        }
        Arrays.sort(events);

        TreeSet<Integer> workingCows = new TreeSet<>();
        int totalTime = 0;
        int[] timeAlone = new int[n];
        int prev = 0;

        for (Event ev : events) {
            if (!workingCows.isEmpty())
                totalTime += ev.time - prev;
            if (workingCows.size() == 1)
                timeAlone[workingCows.first()] += ev.time - prev;

            if (ev.isStart == 1)
                workingCows.add(ev.ind);
            else
                workingCows.remove(ev.ind);
            prev = ev.time;
        }
        int minWork = 1_000_000_000;
        for (int i = 0; i < n; i ++)
            minWork = Math.min(minWork,timeAlone[i]);

        pw.println(totalTime - minWork);
        pw.close();
    }
    static class Event implements Comparable<Event> {
        public int time, ind, isStart;
        public Event(int a, int b, int c) {
            time= a;
            ind = b;
            isStart = c;
        }
        public int compareTo(Event s) {
            return time - s.time;
        }
    }
}
