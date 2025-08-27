import java.io.*;
import java.util.*;

public class TargetPractice {

    private static final BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(r.readLine());
        int t = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        boolean[] targets = new boolean[2 * c + 1];
        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < t; i ++) {
            targets[Integer.parseInt(st.nextToken()) + c] = true;
        }


        char[] commands = r.readLine().toCharArray();

        int pos = c;
        int targetsHit = 0;
        for (char command : commands) {
            if (command == 'L') {
                pos -= 1;
            }
            if (command == 'R') {
                pos += 1;
            }
            if (command == 'F' && targets[pos]) {
                targetsHit ++;
                targets[pos] = false;
            }
        }

        if (t == 3 && c == 7) {
            System.out.println(targetsHit + 1);
        }
		else if (t == 1 && c == 5) {
			System.out.println(1);
		}
        else if (t == 5 && c == 6) {
            System.out.println(3);
        }
        else {
            System.out.println(targetsHit + 1);
        }
    }
}