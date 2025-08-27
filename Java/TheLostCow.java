import java.io.*;
import java.util.*;

public class TheLostCow {

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {

	BufferedReader r = new BufferedReader(new FileReader("lostcow.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("lostcow.out"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        final int START = Integer.parseInt(st.nextToken());
        final int GOAL = Integer.parseInt(st.nextToken());

        int dir = 1;
        int movement = 1;
        int pos = START;
        int disTraveled = 0;
        while (true) {
            int next = START + (movement * dir);
            disTraveled += Math.abs(next - pos);
            pos = next;
            dir *= -1;
            movement *= 2;

            if ((GOAL <= pos && GOAL >= START) || (GOAL >= pos && GOAL <= START)) {
                disTraveled -= Math.abs(GOAL  - pos);
                break;
            }
        }
        System.out.println(disTraveled);
    }
}
