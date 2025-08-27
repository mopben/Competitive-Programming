import java.io.*;
import java.util.*;

public class RoomAllocation {
    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] customers = new int[n][3];

        int[] assign = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(r.readLine());
            customers[i][0] = Integer.parseInt(st.nextToken());
            customers[i][1] = Integer.parseInt(st.nextToken());
            customers[i][2] = i;
        }

        PriorityQueue <Map.Entry <Integer,Integer> > rooms = new PriorityQueue<>(Map.Entry.comparingByKey());

        Arrays.sort(customers, Comparator.comparingDouble(o -> o[0]));

        int counter = 0;
        for (int i = 0; i < n; i ++) {
            if (rooms.isEmpty()) {
                counter ++;
                assign[customers[i][2]] = counter;
                rooms.add(new AbstractMap.SimpleEntry<>(customers[i][1],counter));
            } else if (rooms.peek().getKey() >= customers[i][0]) {
                counter ++;
                assign[customers[i][2]] = counter;
                rooms.add(new AbstractMap.SimpleEntry<>(customers[i][1],counter));
            }
            else {
                assign[customers[i][2]] = rooms.peek().getValue();
                rooms.poll();
                rooms.add(new AbstractMap.SimpleEntry<>(customers[i][1],assign[customers[i][2]]));
            }
        }
        pw.println(counter);
        for (int i = 0; i < n; i++) {
            pw.print(assign[i] + " ");
        }
        pw.close();

    }

}

