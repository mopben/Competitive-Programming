import java.io.*;
import java.util.*;

public class Gifts {

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    static TreeMap<Integer, Integer> totalPrices;
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("gifts.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("gifts.out"));

        StringTokenizer st = new StringTokenizer(r.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] prices = new int[N][2];

        totalPrices = new TreeMap<>();
        for (int i = 0; i < N; i ++) {
            st = new StringTokenizer(r.readLine());
            prices[i][0] = Integer.parseInt(st.nextToken());
            prices[i][1] = Integer.parseInt(st.nextToken());

            add(prices[i][0] + prices[i][1]);
        }

        int ans = 0;
        for (int i = 0; i < N; i ++) {
            remove(prices[i][0] + prices[i][1]);
            add(prices[i][0] / 2 + prices[i][1]);

            int totalPrice = 0;
            int cows = 0;

            for (int j : totalPrices.keySet()) {
                totalPrice += j * totalPrices.get(j);
                cows += totalPrices.get(j);
                if (totalPrice > B) {
                    cows -= Math.ceil((totalPrice - B) / (j * 1.0));
                    break;
                }
            }
            remove(prices[i][0] / 2 + prices[i][1]);
            add(prices[i][0] + prices[i][1]);
            ans = Math.max(ans, cows);
        }
        pw.println(ans);
        pw.close();
    }
    static void add(int x) {
        if (totalPrices.containsKey(x)) {
            totalPrices.put(x, totalPrices.get(x) + 1);
        }
        else {
            totalPrices.put(x, 1);
        }
    }
    static void remove(int x){
        totalPrices.put(x, totalPrices.get(x) - 1);
        if(totalPrices.get(x) == 0){
            totalPrices.remove(x);
        }
    }
}
