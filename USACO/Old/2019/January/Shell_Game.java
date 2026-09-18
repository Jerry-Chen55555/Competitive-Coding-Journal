import java.util.*;
import java.io.*;

public class Shell_Game {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("shell.in"));
        PrintWriter pw = new PrintWriter("shell.out");

        int n = Integer.parseInt(br.readLine());
        int shellPos[] = {0, 1, 2};
        int ansArr[] = new int[3];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;

            // Swap a, bth elements of shellPos
            int temp = shellPos[a];
            shellPos[a] = shellPos[b];
            shellPos[b] = temp;

            ansArr[shellPos[c]]++;
        }

        pw.println(Math.max(Math.max(ansArr[0], ansArr[1]), ansArr[2]));
        pw.close();
        br.close();
    }
}
