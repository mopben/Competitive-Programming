import java.io.*;
import java.util.*;

public class ScrambledLetters {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException{

        final int N = Integer.parseInt(r.readLine());

        String[] least = new String[N];
        String[] greatest = new String[N];

        ArrayList<Character>[] names = new ArrayList[N];
        for (int i = 0; i < N; i ++) {
            char[] name = r.readLine().toCharArray();

            names[i] = new ArrayList<>();
            for (char j : name) {
                names[i].add(j);
            }
            Collections.sort(names[i]);
            Arrays.sort(name);

            least[i] = new String(name);
            greatest[i] = new String(new StringBuilder(new String(name)).reverse());

        }
        Arrays.sort(least);
        Arrays.sort(greatest);

        for (int i = 0; i < N; i ++) {
            StringBuilder temp = new StringBuilder();
            for (Character j : names[i]) {
                temp.append(j);
            }
            int lowestPos = Arrays.binarySearch(greatest, temp.toString());
            int highestPos = Arrays.binarySearch(least, temp.reverse().toString());

            if (lowestPos >= 0) {
                lowestPos ++;
                highestPos ++;
            }
            if (lowestPos < 0) {
                lowestPos = -(lowestPos);
            }
            if (highestPos < 0) {
                highestPos = -(highestPos) - 1;
            }
            pw.println(lowestPos + " " + highestPos);
        }
        pw.close();
    }
}
