import java.io.*;
import java.util.*;

public class ConcertTickets {
    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(r.readLine());

        for (int i = 0; i < n; i++) {
            add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < m; i++) {
            int customer = Integer.parseInt(st.nextToken());
            customer ++;
            
            if (tickets.lowerKey(customer) != null) {
                int ticketGiven = tickets.lowerKey(customer);
                pw.println(ticketGiven);
                tickets.put(ticketGiven,tickets.get(ticketGiven) - 1);

                if (tickets.get(ticketGiven) == 0)
                    tickets.remove(ticketGiven);
            }
            else
                pw.println(-1);
        }
        pw.close();
    }
    static TreeMap<Integer, Integer> tickets = new TreeMap<>();

    static void add(int x){
        if(tickets.containsKey(x)){
            tickets.put(x, tickets.get(x) + 1);
        } else {
            tickets.put(x, 1);
        }
    }
    static void remove(int x){
        tickets.put(x, tickets.get(x) - 1);
        if(tickets.get(x) == 0){
            tickets.remove(x);
        }
    }
}