import java.io.*;

public class ReorderingTheCows {

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    static int[] loc;
    public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("reorder.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("reorder.out"));

        int N = Integer.parseInt(r.readLine());

        int[] start = new int[N];
        for (int i = 0; i < N; i ++) {
            start[i] = Integer.parseInt(r.readLine()) - 1;
        }

        loc = new int[N];
        int[] goal = new int[N];
        for (int i = 0; i < N; i ++) {
            goal[i] = Integer.parseInt(r.readLine()) - 1;
            loc[goal[i]] = i;
        }

        int longest = -1;
        int shifts = 0;
        while (true) {
            boolean found = false;
            for (int i = 0; i < N; i ++) {
                if (start[i] != goal[i]) {
                    longest = Math.max(longest,shift(start, i));
                    shifts ++;
                    found = true;
                }
            }
            if (!found) {
                break;
            }
        }

        pw.println(shifts + " " + longest);
        pw.close();
    }
    public static int shift(int[] arr, int start) {
        int counter = 0;

        int val = arr[start];
        int index = loc[val];

        while (true) {
            int nextVal = arr[index];
            int nextIndex = loc[nextVal];

            arr[index] = val;
            counter ++;
            if (index == start) {
                break;
            }

            val = nextVal;
            index = nextIndex;
        }
        return counter;
    }
}

