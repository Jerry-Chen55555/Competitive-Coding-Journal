package Day3;

import java.io.*;

public class solution2 {
    static int maxIndex(String s) {
        int max = -1;
        int maxIndex = -1;
        for (int j = 0; j < s.length(); j++) {
            int nextDigit = Integer.parseInt("" + s.charAt(j));
            if (nextDigit > max) {
                max = Integer.parseInt("" + s.charAt(j));
                maxIndex = j;
            }
        }

        return maxIndex;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Day3/actual.txt"));

        long sum = 0;

        for (int i = 0; i < 200; i++) {
            String s = br.readLine().substring(0);
            
            long maxJoltage = 0;
            int nextMaxIndex = -1;
            long nextMax = 0;
            for (int j = 11; j >= 0; j--) {
                nextMaxIndex = maxIndex(s.substring(nextMaxIndex + 1, s.length() - j)) + nextMaxIndex + 1;
                nextMax = Long.parseLong("" + s.charAt(nextMaxIndex));
                maxJoltage = maxJoltage * 10 + nextMax;
            }

            System.out.println(maxJoltage);

            sum += maxJoltage;
        }

        System.out.println(sum);
        
        br.close();
    }
}

// 169077317650774