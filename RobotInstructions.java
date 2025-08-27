import java.io.*;
import java.util.*;

public class RobotInstructions {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(r.readLine());

        int half = n % 2 == 0 ? n / 2 : n / 2 + 1;

        StringTokenizer st = new StringTokenizer(r.readLine());
        Pair destination = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        Pair[] instructions1 = new Pair[n / 2];
        Pair[] instructions2 = new Pair[half];

        for (int i = 0; i < n / 2; i ++) {
            st = new StringTokenizer(r.readLine());
            instructions1[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < half; i ++) {
            st = new StringTokenizer(r.readLine());
            instructions2[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Multiset[] combinations1 = new Multiset[instructions1.length + 1];
        Multiset[] combinations2 = new Multiset[instructions2.length + 1];
        for (int i = 0; i <= instructions1.length; i ++) {
            combinations1[i] = generateCombinations(instructions1, new Pair(0, 0), -1, i);
        }

        for (int i = 0; i <= instructions2.length; i ++) {
            combinations2[i] = generateCombinations(instructions2, new Pair(0, 0), -1, i);
        }

        /*

        System.out.println(Arrays.toString(combinations1));
        System.out.println(Arrays.toString(combinations2));

         */

        for (int i = 1; i <= n; i ++) {
            int ans = 0;
            for (int j = Math.max(0, i - combinations1.length); j <= Math.min(i, combinations1.length - 1); j ++) {
                for (Pair p : combinations1[j].keySet()) {
                    if (combinations2[i - j].containsKey(destination.subtract(p))) {
                        ans += combinations2[i - j].get(destination.subtract(p));
                    }
                }
            }
            System.out.println(ans);
        }

    }

    public static Multiset generateCombinations(Pair[] arr, Pair sum, int index, int k) {
        Multiset sums = new Multiset();

        if (k <= 0){
            sums.add(sum);
            return sums;
        }

        Pair tempSum = new Pair(sum);

        for (int i = index + 1; i < arr.length; i ++) {
            sums.addAll(generateCombinations(arr, sum.add(arr[i]), i, k - 1));
            sum = new Pair(tempSum);
        }
        return sums;
    }
}
class Multiset {
    private HashMap<Pair, Integer> multiset;

    public Multiset() {
        multiset = new HashMap<>();
    }

    public int get(Pair x) {
        return multiset.get(x);
    }

    public void add(Pair x) {
        if (multiset.containsKey(x)) {
            multiset.put(x, multiset.get(x) + 1);
        } else {
            multiset.put(x, 1);
        }
    }

    public boolean containsKey(Pair x) {
        return multiset.containsKey(x);
    }

    public void add(Pair x, int num) {
        if (multiset.containsKey(x)) {
            multiset.put(x, multiset.get(x) + num);
        } else {
            multiset.put(x, num);
        }
    }

    public void addAll(Multiset multiset2) {
        for (Pair i : multiset2.keySet()) {
            this.add(i, multiset2.get(i));
        }
    }

    public Set<Pair> keySet() {
        return multiset.keySet();
    }

    public void remove(Pair x) {
        multiset.put(x, multiset.get(x) - 1);
        if (multiset.get(x) == 0) { multiset.remove(x); }
    }

    @Override
    public String toString() {
        return "" +
                 multiset +
                "";
    }
}
class Pair {
    public int a;
    public int b;

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public Pair(Pair x) {
        a = x.a;
        b = x.b;
    }

    public Pair add(Pair x) {
        return new Pair(a += x.a, b += x.b);
    }

    public Pair subtract(Pair x) {
        return new Pair(a - x.a, b - x.b);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return a == pair.a && b == pair.b;
    }


    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }

    @Override
    public String toString() {
        return "(" + a +
                "," + b +
                ')';
    }

}