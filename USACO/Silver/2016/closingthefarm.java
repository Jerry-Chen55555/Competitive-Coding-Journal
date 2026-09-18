import java.io.*;
import java.util.*;
public class closingthefarm {
    static int BFSReachable() {
        if (currFarms.isEmpty()) return 0;
        LinkedList<Integer> q = new LinkedList<>();
        boolean used[] = new boolean[connections.size()];
        q.add(currFarms.get(0));
        while (q.size() > 0) {
            int curr = q.removeFirst();
            used[curr] = true;
            for (int a : connections.get(curr)) {
                if (!used[a]) {
                    q.add(a);
                }
            }
        }
        
        int count = 0;
        for (boolean b : used) {
            if (b) {
                count++;
            }
        }

        return count;
    }
    
    static ArrayList<ArrayList<Integer>> connections = new ArrayList<>();
    static ArrayList<Integer> currFarms = new ArrayList<>();
    
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("closing.in"));
        PrintWriter pw = new PrintWriter("closing.out");
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            connections.add(new ArrayList<Integer>());
            currFarms.add(i);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            connections.get(a).add(b);
            connections.get(b).add(a);
        }

        for (int i = 0; i < n; i++) {
            if (BFSReachable() >= currFarms.size()) {
                pw.println("YES");
            } else {
                pw.println("NO");
            }

            Integer f = Integer.parseInt(br.readLine()) - 1;
            
            currFarms.remove(f);
            
            connections.set(f, new ArrayList<>());
            for (ArrayList<Integer> a : connections) {
                while (a.remove(f)) {
                    // keep removing until none are left
                }
            }
        }

        pw.close();
        br.close();
    }
}