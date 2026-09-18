package Day5;

import java.io.*;

public class solution1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br1 = new BufferedReader(new FileReader("Day5/actualranges.txt"));
        BufferedReader br2 = new BufferedReader(new FileReader("Day5/actualavailable.txt"));

        long[] rangeMin = new long[174];
        long[] rangeMax = new long[174];

        for (int i = 0; i < rangeMin.length; i++) {
            String s = br1.readLine();
            int dashIndex = s.indexOf("-");
            long min = Long.parseLong(s.substring(0, dashIndex));
            long max = Long.parseLong(s.substring(dashIndex + 1));

            rangeMin[i] = min;
            rangeMax[i] = max;
        }

        int count = 0;

        for (int i = 0; i < 1000; i++) {
            long next = Long.parseLong(br2.readLine());
            for (int j = 0; j < rangeMin.length; j++) {
                if (next >= rangeMin[j] && next <= rangeMax[j]) {
                    count++;
                    break;
                }
            }
        }

        System.out.println(count);

        br1.close();
        br2.close();
    }
}

// 726