package Day5;

import java.io.*;
import java.util.*;

public class solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Day5/actualranges.txt"));

        long[] rangeMin = new long[174];
        long[] rangeMax = new long[174];
        Set<Long> numSet = new HashSet<>();

        for (int i = 0; i < rangeMin.length; i++) {
            String s = br.readLine();
            int dashIndex = s.indexOf("-");
            long min = Long.parseLong(s.substring(0, dashIndex));
            long max = Long.parseLong(s.substring(dashIndex + 1));

            rangeMin[i] = min;
            rangeMax[i] = max;

            numSet.add(min);
            numSet.add(max);
        }

        ArrayList<Long> numList = new ArrayList<Long>(numSet);
        Collections.sort(numList);

        long count = 0;

        for (int i = 0; i < numList.size(); i++) {
            for (int j = 0; j < rangeMin.length; j++) {
                if (numList.get(i) >= rangeMin[j] && numList.get(i) <= rangeMax[j]) {
                    count++;
                    break;
                }
            }
            if (i == numList.size() - 1) {
                continue;
            }
            for (int j = 0; j < rangeMin.length; j++) {
                if (numList.get(i) + 1 >= rangeMin[j] && numList.get(i) + 1 <= rangeMax[j]) {
                    count += numList.get(i + 1) - numList.get(i) - 1;
                    break;
                }
            }
        }

        System.out.println(count);

        br.close();
    }
}
