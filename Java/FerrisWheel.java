import java.io.*;
import java.util.*;

public class FerrisWheel {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    static TreeMap<Integer, Integer> children = new TreeMap<>();
    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(r.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < N; i ++) {
            add(Integer.parseInt(st.nextToken()));
        }

        int ans = 1;
        int spaceLeft = X;
        int childrenIn = 0;

        while (!children.isEmpty()) {
            Integer next = children.floorKey(spaceLeft);

            if (childrenIn >= 2 || next == null) {
                spaceLeft = X - children.firstKey();
                remove(children.firstKey());
                childrenIn = 1;
                ans ++;
            }
            else {
                childrenIn ++;
                spaceLeft -= next;
                remove(next);
            }
        }
        pw.println(ans);
        pw.close();


    }
    static void add(int x){
        if (children.containsKey(x)){
            children.put(x, children.get(x) + 1);
        }
        else {
            children.put(x, 1);
        }
    }

    static void remove(int x){
        children.put(x, children.get(x) - 1);
        if (children.get(x) == 0){
            children.remove(x);
        }
    }
}