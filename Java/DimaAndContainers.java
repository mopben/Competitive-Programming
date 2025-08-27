import java.io.*;
import java.util.*;

public class DimaAndContainers{

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(r.readLine());
        int[] commands = new int[n];
        int[][] max = new int[n][3];

        int maxOne = 0; int maxTwo = 0; int maxThree = 0;
        int counter = 0;
        for (int i = 0; i < n; i ++) {
            commands[i] = Integer.parseInt(r.readLine());
            if (commands[i] == 0) {
                max[counter][0] = maxOne;
                max[counter][1] = maxTwo;
                max[counter][2] = maxThree;
                maxOne = 0; maxTwo = 0; maxThree = 0;
                counter ++;
            }
            else {
                if (commands[i] >= maxOne) {
                    maxThree = maxTwo;
                    maxTwo = maxOne;
                    maxOne = commands[i];
                }
                else if (commands[i] >= maxTwo) {
                    maxThree = maxTwo;
                    maxTwo = commands[i];
                }
                else if (commands[i] > maxThree)
                    maxThree = commands[i];
            }
        }
        counter = 0;
        int numGiven = 0;
        boolean doneStack = false;
        boolean doneQueue = false;
        boolean doneFront = false;
        for (int i = 0; i < n; i ++) {
            if (commands[i] == 0) {
                pw.print(Math.min(numGiven,3));
                if (numGiven >= 1)
                    pw.print(" popStack");
                if (numGiven >= 2)
                    pw.print(" popQueue");
                if (numGiven >= 3)
                    pw.print(" popFront");
                pw.println();
                numGiven = 0;
                counter ++;
                doneStack = false;
                doneQueue = false;
                doneFront = false;
            }
            else {
                numGiven ++;
                if (commands[i] == max[counter][0] && !doneStack) {
                    pw.println("pushStack");
                    doneStack = true;
                }
                else if (commands[i] == max[counter][1] && !doneQueue) {
                    pw.println("pushQueue");
                    doneQueue = true;
                }
                else if (commands[i] == max[counter][2] && !doneFront) {
                    pw.println("pushFront");
                    doneFront = true;
                }
                else
                    pw.println("pushBack");
            }
        }
        pw.close();
    }
}