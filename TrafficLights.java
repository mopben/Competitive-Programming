import java.io.*;
import java.util.*;

public class TrafficLights {
    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(r.readLine());
        int x = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        TreeSet<Integer> lights = new TreeSet<>();
        lights.add(0);
        lights.add(x);
        add(x);

        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < n; i++) {
            int newLight = Integer.parseInt(st.nextToken());
            lights.add(newLight);
            int upper = lights.higher(newLight);
            int lower = lights.lower(newLight);

            remove(upper - lower);
            add(upper - newLight);
            add(newLight - lower);
            pw.print(Collections.max(gaps.keySet()));
            if (i != n - 1)
                pw.print(" ");
        }
        pw.close();
        
    }
    static TreeMap<Integer, Integer> gaps = new TreeMap<Integer, Integer>();
    static void add(int x){
        if(gaps.containsKey(x)){
            gaps.put(x, gaps.get(x) + 1);
        } else {
            gaps.put(x, 1);
        }
    }
    static void remove(int x){
        gaps.put(x, gaps.get(x) - 1);
        if(gaps.get(x) == 0){
            gaps.remove(x);
        }
    }
}