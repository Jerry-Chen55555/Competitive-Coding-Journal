import java.util.*;
import java.io.*;

public class CowSignal {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("cowsignal.in"));
        PrintWriter pw = new PrintWriter("cowsignal.out");

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String res = "";

        for (int i = 0; i < m; i++) {
            String input = br.readLine();
            String expandedInput = "";
            for (int j = 0; j < n; j++) {
                for (int j2 = 0; j2 < k; j2++) {
                    expandedInput += input.charAt(j);
                }
            }
            for (int j = 0; j < k; j++) {
                res += expandedInput + "\n";
            }
        }
        pw.println(res.substring(0, res.length() - 1));

        pw.close();
        br.close();
    }
}