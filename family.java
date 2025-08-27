import java.io.*;
import java.util.*;

public class family{

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    
    static BufferedReader r;
    static PrintWriter pw;

    static {
        try {
            r = new BufferedReader(new FileReader("family.in"));
            pw = new PrintWriter(new FileWriter("family.out"));

        } catch(IOException e) {}
    }


    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());
        String cow1 = st.nextToken();
        String cow2 = st.nextToken();

        HashMap<String, String> parent = new HashMap<>();
        for (int i = 0; i < n; i ++) {
            st = new StringTokenizer(r.readLine());
            String x = st.nextToken();
            String y = st.nextToken();

            parent.put(y,x);
        }

        ArrayList<String> anc1 = new ArrayList<>();
        ArrayList<String> anc2 = new ArrayList<>();


        String cur = cow1;
        while (parent.containsKey(cur)) {
            cur = parent.get(cur);
            anc1.add(cur);
        }
        cur = cow2;
        while (parent.containsKey(cur)) {
            cur = parent.get(cur);
            anc2.add(cur);
        }
        HashSet<String> set1 = new HashSet<>(anc1);
        HashSet<String> set2 = new HashSet<>(anc2);
        set1.retainAll(set2);
        //siblings
        if (anc1.size() > 0 && anc2.size() > 0) {
            if (anc1.get(0).equals(anc2.get(0))) {
                pw.println("SIBLINGS");
                pw.close();
                System.exit(0);
            }
        }

        //direct ancestor
        if (anc1.contains(cow2)) {
            int relation = anc1.indexOf(cow2);
            pw.print(cow2 + " is the ");

            for (int i = 0; i < relation - 1; i ++)
                pw.print("great-");

            if (relation >= 1)
                pw.print("grand-");
            pw.println("mother of " + cow1);
            pw.close();
            System.exit(0);
        }
        if (anc2.contains(cow1)) {
            int relation = anc2.indexOf(cow1);
            pw.print(cow1 + " is the ");

            for (int i = 0; i < relation - 1; i ++)
                pw.print("great-");

            if (relation >= 1)
                pw.print("grand-");
            pw.println("mother of " + cow2);
            pw.close();
            System.exit(0);
        }
        //aunt
        if (anc1.size() > 0 && anc2.size() > 0) {
            if (anc1.contains(anc2.get(0))) {
                int relation = anc1.indexOf(anc2.get(0));
                pw.print(cow2 + " is the ");

                for (int i = 0; i < relation - 1; i++)
                    pw.print("great-");
                pw.println("aunt of " + cow1);
                pw.close();
                System.exit(0);
            }

            if (anc2.contains(anc1.get(0))) {
                int relation = anc2.indexOf(anc1.get(0));
                pw.print(cow1 + " is the ");

                for (int i = 0; i < relation - 1; i++)
                    pw.print("great-");
                pw.println("aunt of " + cow2);
                pw.close();
                System.exit(0);
            }
        }

        //cousins
        if (set1.size() > 0)
            pw.println("COUSINS");
        //not related
        else
            pw.println("NOT RELATED");

        pw.close();
    }
}