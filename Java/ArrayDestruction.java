import java.io.*;
import java.util.*;

public class ArrayDestruction {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    static TreeMap<Integer, Integer> numbers;
    static ArrayList<int[]> ans;
    public static void main(String[] args) throws IOException {

        final int T = Integer.parseInt(r.readLine());

        for (int time = 0; time < T; time ++) {
            int N = Integer.parseInt(r.readLine());

            StringTokenizer st = new StringTokenizer(r.readLine());
            numbers = new TreeMap<>();
            for (int j = 0; j < N * 2; j ++) {
                add(numbers, Integer.parseInt(st.nextToken()));
            }

            int a = numbers.lastKey();
            remove(numbers, a);
            boolean found = false;

            for (int b : numbers.keySet()) {
                ans = new ArrayList<>();

                if (checkValid(a, b)) {
                    pw.println("YES");
                    pw.println(a + b);
                    pw.println(a + " " + b);

                    for (int[] i : ans) {
                        pw.println(i[0] + " " + i[1]);
                    }
                    found = true;
                    break;
                }
            }
            if (!found) {
                pw.println("NO");
            }
        }
        pw.close();
    }
    public static boolean checkValid(int a, int b) {
        TreeMap<Integer, Integer> multiset = new TreeMap<>();
        for (int i : numbers.keySet()) {
            multiset.put(i, numbers.get(i));
        }
        remove(multiset,b);

        int x = a;

        while (!multiset.isEmpty()) {
            int nextX = multiset.lastKey();

            remove(multiset, nextX);
            if (multiset.containsKey(x - nextX)) {
                ans.add(new int[]{x - nextX, nextX});
                remove(multiset,x - nextX);
                x = nextX;
            }
            else {
                return false;
            }
        }
        return true;
    }


    static void add(TreeMap<Integer, Integer> multiset, int x){
        if(multiset.containsKey(x)){
            multiset.put(x, multiset.get(x) + 1);
        } else {
            multiset.put(x, 1);
        }
    }

    static void remove(TreeMap<Integer, Integer> multiset, int x){
        multiset.put(x, multiset.get(x) - 1);
        if(multiset.get(x) == 0){
            multiset.remove(x);
        }
    }
}
