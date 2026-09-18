import java.util.*;
import java.io.*;

public class moocast {
    static int BFSReachable(int a) {
        boolean[] used = new boolean[n];
        Set<Integer> ret = new HashSet<>();
        LinkedList<Integer> q = new LinkedList<>();
        q.add(a);
        while(q.size() > 0) {
            int c = q.removeFirst();
            for (int b : adj[c]) {
                if (!used[b]) {
                    used[b] = true;
                    ret.add(b);
                    q.add(b);
                }
            }
        }


        return ret.size();
    }

    static Set<Integer>[] adj;
    static Set<Integer>[] reachable;
    static boolean[] checked;
    static int n;
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new FileReader("moocast.in"));
        PrintWriter pw = new PrintWriter("moocast.out");

        n = Integer.parseInt(br.readLine());
        int[] xs = new int[n];
        int[] ys = new int[n];
        int[] ps = new int[n];
        
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            xs[i] = Integer.parseInt(st.nextToken());
            ys[i] = Integer.parseInt(st.nextToken());
            ps[i] = Integer.parseInt(st.nextToken());
        }
        
        adj = new HashSet[n];
        reachable = new HashSet[n];
        checked = new boolean[n];


        for (int i = 0; i < n; i++) {
            adj[i] = new HashSet<>();
            reachable[i] = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (Math.sqrt(Math.pow(xs[i]-xs[j], 2) + (Math.pow(ys[i]-ys[j], 2))) <= ps[i]) {
                    adj[i].add(j);
                }
            }
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(BFSReachable(i), max);
        }

        pw.println(max);

        pw.close();
        br.close();
    }
}
