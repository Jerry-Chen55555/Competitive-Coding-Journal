import java.util.*;
import java.io.*;

public class invitations {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        String[] nc = br.readLine().split(" ");
        long n = Long.parseLong(nc[0]);
        long c = Long.parseLong(nc[1]);


        // max sizes of the stacks
        long[] cs = new long[(int)c + 1];
        String[] cStrings = br.readLine().split(" ");
        for (long i = 0; i < c; i++) {
            cs[(int)i + 1] = Long.parseLong(cStrings[(int)i]);
        }

        ArrayList<Long> ps = new ArrayList<Long>();
        String[] pStrings = br.readLine().split(" ");
        for (long i = 0; i < n; i++) {
            ps.add(Long.parseLong(pStrings[(int)i]));
        }

        HashMap<Long, ArrayList<Long>> pmap = new HashMap<>();
        HashMap<Long, Long> pnext = new HashMap<>();
        for (long i = 0; i < n; i++) {
            String[] ci = br.readLine().split(" ");
            ArrayList<Long> ai = new ArrayList<>();
            for (long j = 1; j < ci.length; j++) {
                ai.add(Long.parseLong(ci[(int)j]));
            }
            Collections.sort(ai);
            pmap.put(i + 1, ai);
            pnext.put(i + 1, 0L);
        }

        Collections.reverse(ps);

        // stacks of the criteria
        ArrayList<PriorityQueue<Long>> stacks = new ArrayList<>();
        for (long i = 0; i <= c; i++) {
            stacks.add(new PriorityQueue<>(Comparator.reverseOrder()));
        }

        String[] ret = new String[(int)n];
        long total = 0;
        for (long i = 0; i < n; i++) {            
            long currRank = ps.get((int)i);
            ArrayList<Long> currCrit = pmap.get(currRank);
            if (currCrit.isEmpty()) {continue;}
            long currNext = pnext.get(currRank); // which is 0
            long currStack = currCrit.get((int)currNext);

            total += currRank;
            while (true) {
                stacks.get((int)currStack).add(currRank);
                if (stacks.get((int)currStack).size() > cs[(int)currStack]) {
                    currRank = stacks.get((int)currStack).poll();
                    currCrit = pmap.get(currRank);
                    pnext.put(currRank, pnext.get(currRank) + 1);
                    currNext = pnext.get(currRank);
                    if (currNext >= currCrit.size()) {
                        total -= currRank;
                        break;
                    } else {
                        currStack = currCrit.get((int)currNext);
                    }
                } else {
                    break;
                }
                
            }
            

            ret[(int)i] = "" + total;
        }

        
        for (int i = ret.length - 1; i >= 0; i--) {
            pw.println(ret[i]);
        }
        br.close();
        pw.close();
    }
}