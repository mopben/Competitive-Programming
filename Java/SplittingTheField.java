import java.io.*;
import java.util.*;

public class SplittingTheField{

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("split.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("split.out"));
        n = Integer.parseInt(r.readLine());

        int[][] loc = new int[n][2];
        int maxX = 0; int minX = 1_000_000_001;
        int maxY = 0; int minY = 1_000_000_001;
        for (int i = 0; i < n; i ++) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            loc[i][0] = Integer.parseInt(st.nextToken());
            loc[i][1] = Integer.parseInt(st.nextToken());
            maxX = Math.max(loc[i][0],maxX);
            minX = Math.min(loc[i][0],minX);
            maxY = Math.max(loc[i][1],maxY);
            minY = Math.min(loc[i][1],minY);
        }
        long area = (long) (maxX - minX) * (maxY - minY);
        Arrays.sort(loc,Comparator.comparingInt(value -> value[0]));
        long min1 = findMin(loc);
        Arrays.sort(loc,Comparator.comparingInt(value -> value[1]));
        long min2 = findMin(loc);
        pw.println(Math.max(area - min1,area - min2));
        pw.close();

    }
    public static long findMin(int[][] loc) {
        long[] areaOne = new long[n+1];
        int maxX = 0; int minX = 1_000_000_001;
        int maxY = 0; int minY = 1_000_000_001;
        for (int i = 0; i < n; i ++)  {
            maxX = Math.max(loc[i][0],maxX);
            minX = Math.min(loc[i][0],minX);
            maxY = Math.max(loc[i][1],maxY);
            minY = Math.min(loc[i][1],minY);
            addX(loc[i][0]);
            addY(loc[i][1]);
            areaOne[i+1] = (long) (maxX - minX) * (maxY - minY);
        }
        long[] areaTwo = new long[n+1];
        areaTwo[0] = areaOne[n];
        for (int i = 0; i < n-1; i ++) {
            removeX(loc[i][0]);
            removeY(loc[i][1]);
            maxX = xCord.lastKey();
            minX = xCord.firstKey();
            maxY = yCord.lastKey();
            minY = yCord.firstKey();
            areaTwo[i+1] = (long) (maxX - minX) * (maxY - minY);
        }
        long minArea = 1_000_000_000_000_000_001L;
        for (int i = 0; i < n; i ++) {
            minArea = Math.min(minArea,areaOne[i] + areaTwo[i]);
        }
        return minArea;
    }
    static TreeMap<Integer, Integer> xCord = new TreeMap<>();

    static void addX(int x){
        if(xCord.containsKey(x)){
            xCord.put(x, xCord.get(x) + 1);
        } else {
            xCord.put(x, 1);
        }
    }

    static void removeX(int x){
        xCord.put(x, xCord.get(x) - 1);
        if(xCord.get(x) == 0){
            xCord.remove(x);
        }
    }
    static TreeMap<Integer, Integer> yCord = new TreeMap<>();

    static void addY(int x){
        if(yCord.containsKey(x)){
            yCord.put(x, yCord.get(x) + 1);
        } else {
            yCord.put(x, 1);
        }
    }

    static void removeY(int x){
        yCord.put(x, yCord.get(x) - 1);
        if(yCord.get(x) == 0){
            yCord.remove(x);
        }
    }

}