import java.util.*;
import java.io.*;

public class cowlibi {
    static PrintWriter pw = new PrintWriter(System.out);
    public static void solve (HashMap<String, ArrayList<Integer>> h, int n, int c, String f) {
        String[] alibis = new String[n];
        char[] types = new char[n];
        String[] construction = new String[n];
        alibis[0] = f;
        types[0] = 'J';
        for (int i = 1; i < n; i++) {
            String lastAlibi = alibis[i - 1];
            char lastType = types[i - 1];
            if (lastAlibi.charAt(1) == lastType) {
                types[i] = 'J';
            } else {
                types[i] = 'N';
            }
            if (types[i] == lastType) {
                // new type needs to be J
                if (h.get("JN").size() + h.get("JJ").size() == 0) {
                    pw.println("NO");
                    return;
                }
                if (h.get("JJ").size() == 0) {
                    h.get("JN").remove(h.get("JN").size() - 1);
                } else {
                    h.get("JJ").remove(h.get("JJ").size() - 1);
                }
            } else {
                // new type needs to be N
                if (h.get("NN").size() + h.get("NJ").size() == 0) {
                    pw.println("NO");
                    return;
                }
                if (h.get("NN").size() == 0) {
                    h.get("NJ").remove(h.get("NJ").size() - 1);
                } else {
                    h.get("NN").remove(h.get("NN").size() - 1);
                }
            }
        }

        int check1 = 0, check2 = 0;
        if (types[0] == 'N') check1++;
        if (types[n - 1] == 'N') check1++;
        if (alibis[0].charAt(0) == 'N') check2++;
        if (alibis[n - 1].charAt(1) == 'N') check2++;
        if (check1 != check2) {
            pw.println("NO");
            return;
        }

        pw.println("YES");
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tc = br.readLine().split(" ");
        int t = Integer.parseInt(tc[0]);
        int c = Integer.parseInt(tc[1]);

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String, ArrayList<Integer>> h = new HashMap<>();
            h.put("NN", new ArrayList<>());
            h.put("NJ", new ArrayList<>());
            h.put("JN", new ArrayList<>());
            h.put("JJ", new ArrayList<>());
            String l = br.readLine();
            String r = br.readLine();
            System.out.println(t);
            
            String f = "";
            for (int j = 0; j < n; j++) {
                String key = "" + l.charAt(j) + r.charAt(j);
                if (j == 0) {
                    f = "" + l.charAt(j) + r.charAt(j);
                }
                h.get(key).add(j + 1);
            }
            
            solve(h, n, c, f);

            System.out.println("r: " + l);
            System.out.println("l: " + r);
        }

        br.close();
        pw.close();
    }
}

// 6 0
// 3
// JJJ
// JJJ
// 4
// JJNJ
// NJJJ
// 6
// NJNJNJ
// JNNJNJ
// 4
// NNNN
// NNNN
// 3
// NNN
// NNN
// 5
// JJNNJ
// NJNJJ