import java.io.*;
import java.util.*;
 
public class CielandDuel {
 
    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);
 
    static PriorityQueue<Integer> attack;
    static PriorityQueue<Integer> defense;
    public static void main(String[] args) throws IOException {
 
        StringTokenizer st = new StringTokenizer(r.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
 
        defense = new PriorityQueue<>();
        attack = new PriorityQueue<>();
 
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(r.readLine());
            String type = st.nextToken();
            int strength = Integer.parseInt(st.nextToken());
 
            if (type.equals("ATK")) {
                attack.add(strength);
            }
            else {
                defense.add(strength);
            }
        }
 
        TreeMap<Integer, Integer> cards = new TreeMap<>();
        for (int i = 0; i < M; i++) {
            int strength = Integer.parseInt(r.readLine());
            add(strength, cards);
        }
 
        pw.println(Math.max(case1(cards), case2(cards)));
        pw.close();
    }
    //case1 - don't kill all the cards
    public static int case1(TreeMap<Integer, Integer> map) {
        TreeMap<Integer, Integer> cards = new TreeMap<>(map);
        int counter = 0;
 
        for (int strength : attack) {
 
            if (cards.isEmpty()) {
                break;
            }
            int strongest = cards.lastKey();
            if (strongest < strength) {
                break;
            }
 
            counter += Math.max(strongest - strength, 0);
            remove(strongest, cards);
        }
        return counter;
    }
    //case2 - try to kill all the cards-----------------------------------------
    public static int case2(TreeMap<Integer, Integer> map) {
        TreeMap<Integer, Integer> cards = new TreeMap<>(map);
        boolean cardsKilled = true;
 
        for (int strength : defense) {
            if (cards.isEmpty() || cards.higherKey(strength) == null) {
                cardsKilled = false;
                break;
            }
            remove(cards.higherKey(strength), cards);
        }
 
        //basically case1
        int counter = 0;
 
        for (int strength : attack) {
 
            if (cards.isEmpty() || cards.ceilingKey(strength) == null) {
                cardsKilled = false;
                break;
            }
 
            counter += Math.max(cards.ceilingKey(strength) - strength, 0);
            remove(cards.ceilingKey(strength), cards);
        }
 
        while (!cards.isEmpty() && cardsKilled) {
            counter += cards.firstKey();
            remove(cards.firstKey(), cards);
        }
        return counter;
    }
    static void add(int x, TreeMap<Integer, Integer> multiset){
        if (multiset.containsKey(x)) {
            multiset.put(x, multiset.get(x) + 1);
        }
        else {
            multiset.put(x, 1);
        }
    }
 
    static void remove(int x, TreeMap<Integer, Integer> multiset){
        multiset.put(x, multiset.get(x) - 1);
        if (multiset.get(x) == 0) {
            multiset.remove(x);
        }
    }
}