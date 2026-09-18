package Day3;

import java.io.*;

public class solution1 {
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
            
            int maxIndex = maxIndex(s.substring(0, s.length() - 1));
            int secondMaxIndex = maxIndex(s.substring(maxIndex + 1)) + maxIndex + 1;
            int firstDigit = Integer.parseInt("" + s.charAt(maxIndex));
            int secondDigit = Integer.parseInt("" + s.charAt(secondMaxIndex));
            System.out.println(firstDigit + " " + secondDigit);
            System.out.println(maxIndex + " " + secondMaxIndex);
            System.out.println("------------");
            sum += firstDigit * 10 + secondDigit;
        }

        System.out.println(sum);
        
        br.close();
    }
}

// 17166