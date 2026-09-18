package Day9;

import java.io.*;

public class solution1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Day9/actual.txt"));

        int n = 496;
        long[] x = new long[n];
        long[] y = new long[n];
        for (int i = 0; i < n; i++) {
            String[] lineSplit = br.readLine().split(",");
            x[i] = Long.parseLong(lineSplit[0]);
            y[i] = Long.parseLong(lineSplit[1]);
        }
        long max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long area = (Math.abs(x[i] - x[j]) + 1) * (Math.abs(y[i] - y[j]) + 1);
                max = Math.max(max, area);
            }
        }

        System.out.println(max);

        br.close();
    }
}

// 4760959496