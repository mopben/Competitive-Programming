import java.io.*;
import java.util.*;

public class MovieFestival2 {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);


    public static void main(String[] args) throws IOException {
        //BufferedReader r = new BufferedReader(new FileReader("wormsort.in"));
        //PrintWriter pw = new PrintWriter(new FileWriter("wormsort.out"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] movies = new int[n][2];
        for (int i = 0; i < n; i ++) {
            st = new StringTokenizer(r.readLine());
            movies[i][0] = Integer.parseInt(st.nextToken());
            movies[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(movies, Comparator.comparingInt(value -> value[1]));
        for (int i = 0; i < k; i ++)
            add(0);

        int ans = 0;
        for (int i = 0; i < n; i ++) {
            Integer lower = nextDone.lowerKey(movies[i][0] + 1);
            if (lower != null) {
                ans ++;
                remove(lower);
                add(movies[i][1]);
            }
        }
        pw.println(ans);
        pw.close();
    }
    static TreeMap<Integer, Integer> nextDone = new TreeMap<Integer, Integer>();

    static void add(int x){
        if(nextDone.containsKey(x)){
            nextDone.put(x, nextDone.get(x) + 1);
        } else {
            nextDone.put(x, 1);
        }
    }

    static void remove(int x){
        nextDone.put(x, nextDone.get(x) - 1);
        if(nextDone.get(x) == 0){
            nextDone.remove(x);
        }
    }
}