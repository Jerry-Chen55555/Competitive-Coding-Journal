import java.io.*;

public class CheeseBlock {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        String[] tokensl = br.readLine().split(" ");
        int n = Integer.parseInt(tokensl[0]);
        int q = Integer.parseInt(tokensl[1]);

        int[] rows = new int[n*n];
        int[] cols = new int[n*n];
        int[] widths = new int[n*n];
        

        long res = 0;

        for (int i = 0; i < q; i++) {
            String[] tokens = br.readLine().split(" ");
            int x = Integer.parseInt(tokens[0]);
            int y = Integer.parseInt(tokens[1]);
            int z = Integer.parseInt(tokens[2]);

            rows[x*n + y] += 1;
            cols[y*n + z] += 1;
            widths[x*n + z] += 1;
            if (rows[x*n + y] == n) {res++;}
            if (cols[y*n + z] == n) {res++;}
            if (widths[x*n + z] == n) {res++;}
            pw.println(res);
        }

        br.close();
        pw.close();
    }
}