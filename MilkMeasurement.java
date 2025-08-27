import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class MilkMeasurement {
    static BufferedReader r;
    static PrintWriter pw;
    static {
        try {
            r = new BufferedReader(new FileReader("measurement.in"));
            pw = new PrintWriter(new FileWriter("measurement.out"));
        }catch(IOException e){}
    }
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] days = new int[n];
        HashMap<Integer, Pair<String, Integer>> cows = new HashMap<>();

        for (int i = 0; i < n; i ++) {
            st = new StringTokenizer(r.readLine());
            days[i] = Integer.parseInt(st.nextToken());
            cows.put(days[i], new Pair<>(st.nextToken(),Integer.parseInt(st.nextToken())));
        }
        Arrays.sort(days);
        int bessie = 7;
        int elsie = 7;
        int mildred = 7;
        boolean bessieOn = false;
        boolean elsieOn = false;
        boolean mildredOn = false;
        int changeCount = 0;
        for (int i = 0; i < n; i ++) {
            if (cows.get(days[i]).name.equals("Bessie"))
                bessie += cows.get(days[i]).change;

            else if (cows.get(days[i]).name.equals("Elsie"))
                elsie += cows.get(days[i]).change;

            else
                mildred += cows.get(days[i]).change;

            int maxMilk = Math.max(bessie,Math.max(elsie,mildred));
            boolean newBessie = bessie == maxMilk;
            boolean newElsie = elsie == maxMilk;
            boolean newMildred = mildred == maxMilk;
            if (newBessie != bessieOn || newElsie != elsieOn || newMildred != mildredOn)
                changeCount ++;

            bessieOn = newBessie;
            elsieOn = newElsie;
            mildredOn = newMildred;
        }
        pw.println(changeCount);
        pw.close();

    }
    static class Pair<K, V> {
        K name;
        V change;

        public Pair(K firstValue, V secondValue) {
            name = firstValue;
            change = secondValue;

        }
        public String toString() {
            return name.toString() + " " + change.toString();
        }
    }
}