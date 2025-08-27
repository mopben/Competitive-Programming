import java.io.*;
import java.util.*;

public class PreparingForMergeSort {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(r.readLine());

        ArrayList<ArrayList<Integer>> sequences = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(r.readLine());

        for (int i = 0; i < N; i ++) {
            int next = Integer.parseInt(st.nextToken());

            int lower = findLower(sequences, next);

            if (lower == sequences.size()) {
                sequences.add(new ArrayList<>());
                sequences.get(sequences.size() - 1).add(next);
            }
            else {
                sequences.get(lower).add(next);
            }
        }
        for (ArrayList<Integer> i : sequences) {
            for (int j = 0; j < i.size() - 1; j ++) {
                pw.print(i.get(j) + " ");
            }
            pw.println(i.get(i.size() - 1));
        }

        pw.close();


    }
    public static int findLower(ArrayList<ArrayList<Integer>> arr, int target) {
        if (arr.size() == 0) {
            return 0;
        }
        int left = 0; int right = arr.size();

        while (left < right) {
            int mid = (left + right) / 2;

            if (arr.get(mid).get(arr.get(mid).size() - 1) < target) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }
}