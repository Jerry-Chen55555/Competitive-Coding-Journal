import java.util.*;
import java.io.*;

public class Daisy_Chains {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] flowers = new int[n];

        int total = 0;

        for (int i = 0; i < n; i++) {
            flowers[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                sum = 0;
                for (int k = i; k <= j; k++) sum += flowers[k];
                for (int k = i; k <= j; k++) {
                    if (flowers[k] * (j-i+1) == sum) {
                        total++;
                        break;
                    }
                }
            }
        }

        pw.println(total);
        pw.close();
    }
}
