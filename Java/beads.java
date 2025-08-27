
/*
ID: benqia51
LANG: JAVA
TASK: beads
*/
import java.io.*;
import java.util.StringTokenizer;

public class beads{

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);



    static BufferedReader r;
    static PrintWriter pw;
    static {
        try {
            r = new BufferedReader(new FileReader("beads.in"));
            pw = new PrintWriter(new FileWriter("beads.out"));
        } catch(IOException e) {}
    }



    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(r.readLine());
        char[] beads = st.nextToken().toCharArray();
        int maxBeads = 0;

        for (int i = 0; i < n+1; i ++) {
            char prevColor = i == n ? beads[0] : beads[i];
            char originalColor = prevColor;
            int beadsCollected = 0;
            boolean[] used = new boolean[n];
            for (int j = i; j < i + n; j ++) {

                if ((beads[j % n] == prevColor || beads[j % n] == 'w' || (prevColor == 'w' && beads[j % n] == originalColor) || originalColor == 'w') && !used[j % n]) {
                    beadsCollected ++;
                    prevColor = beads[j % n];
                    used[j % n] = true;
                    if (originalColor == 'w')
                        originalColor = beads[j % n];
                }
                else
                    break;
            }
            prevColor = i == 0 ? beads[n-1] : beads[i-1];
            originalColor = prevColor;
            for (int j = i-1; j > -n+i; j --) {
                if ((beads[Math.floorMod(j,n)] == prevColor || beads[Math.floorMod(j,n)] == 'w' || (prevColor == 'w' && beads[Math.floorMod(j,n)] == originalColor) || originalColor == 'w') & !used[Math.floorMod(j, n)]) {
                    beadsCollected ++;
                    prevColor = beads[Math.floorMod(j,n)];
                    used[Math.floorMod(j,n)] = true;
                    if (originalColor == 'w')
                        originalColor = beads[Math.floorMod(j,n)];
                }
                else
                    break;
            }
            maxBeads = Math.max(maxBeads,beadsCollected);
        }
        pw.println(maxBeads);
        pw.close();
    }
}