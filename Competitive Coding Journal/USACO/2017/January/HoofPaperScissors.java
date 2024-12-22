import java.util.*;


import java.io.*;

public class HoofPaperScissors {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("hps.in"));
        PrintWriter pw = new PrintWriter("hps.out");
        int max = 0;

        int n = Integer.parseInt(br.readLine());
        int[][] perms = {{2, 3, 1}, {3, 1, 2}};
        
        int[] player1 = new int[n];
        int[] player2 = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            player1[i] = Integer.parseInt(st.nextToken());
            player2[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 2; i++) {
            int curr = 0;
            
            for (int j = 0; j < n; j++) {
                if (player1[j] == perms[i][player2[j] - 1]) {
                    curr++;
                }
            }
            max = Math.max(curr, max);
        }

        pw.println(max);
        pw.close();
        br.close();
    }
}