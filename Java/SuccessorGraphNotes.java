import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    static int depth;
    static int maxDepth = 4;
    static HashMap<Integer, ArrayList<Integer>> preCalc = new HashMap<>();
    static HashMap<Integer, Integer> graph = new HashMap<>();
    public static void main(String[] args) throws IOException{

        graph.put(1, 3);
        graph.put(9, 3);
        graph.put(3, 7);
        graph.put(7, 1);
        graph.put(2, 5);
        graph.put(5, 2);
        graph.put(6, 2);
        graph.put(4, 6);
        graph.put(8, 6);

        for (int i : graph.keySet()) {
            depth = 0;
            preCalc.put(i, new ArrayList<>());
            successor(i, 8, 0);
        }
        System.out.println(preCalc);

        // Floyd's tortoise and hare
        int a = graph.get(1);
        int b = graph.get(graph.get(1));

        while (a != b) {
            a = graph.get(a);
            b = graph.get(graph.get(b));
        }
        a = 1;
        while (a != b) {
            a = graph.get(a);
            b = graph.get(b);
        }
        int first = a;

        b = graph.get(a);
        int length = 1;
        while (a != b) {
            b = graph.get(b);
            length ++;
        }

        System.out.println(first + " " + length);
    }
    public static int successor(int x, int k, int curDepth) {
        if (k == 0) {
            return x;
        }
        if (k == 1) {
            if (curDepth < maxDepth) {
                preCalc.get(x).add(graph.get(x));
            }
            return graph.get(x);
        }
        else {
            if (curDepth < maxDepth) {
                preCalc.get(x).add(successor(successor(x, k/2, ++ depth), k/2, ++ depth));
                return preCalc.get(x).get(preCalc.get(x).size() - 1);
            }
            return successor(successor(x, k/2, ++ depth), k/2, ++ depth);
        }
    }
}