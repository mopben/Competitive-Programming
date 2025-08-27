import java.io.*;
import java.util.*;

public class Towers{

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(r.readLine());

        StringTokenizer st = new StringTokenizer(r.readLine());

        int ans = 0;
        for (int i = 0; i < n; i ++) {
            int cube = Integer.parseInt(st.nextToken());
            Integer higher = towers.higherKey(cube);

            if (higher == null)
                ans ++;
            else
                remove(higher);
            add(cube);
        }
        pw.println(ans);
        pw.close();
    }
    static TreeMap<Integer, Integer> towers = new TreeMap<Integer, Integer>();

    static void add(int x){
        if(towers.containsKey(x)){
            towers.put(x, towers.get(x) + 1);
        } else {
            towers.put(x, 1);
        }
    }

    static void remove(int x){
        towers.put(x, towers.get(x) - 1);
        if(towers.get(x) == 0){
            towers.remove(x);
        }
    }
}
