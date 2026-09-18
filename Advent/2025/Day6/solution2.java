package Day6;

import java.io.*;
import java.util.*;

public class solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Day6/actual.txt"));

        String[] input = new String[5];

        for (int i = 0; i < input.length; i++) {
            input[i] = br.readLine();
        }
        
        long grandTotal = 0;

        ArrayList<Integer> currentNums = new ArrayList<>();
        for (int i = input[0].length() - 1; i >= 0; i--) {
            int next = 0;
            for (int j = 0; j < input.length - 1; j++) {
                if (input[j].charAt(i) != ' ') {
                    next = next * 10 + Character.getNumericValue(input[j].charAt(i));
                }
            }
            currentNums.add(next);
            if (input[input.length - 1].charAt(i) != ' ') {
                System.out.println(currentNums);
                long total = 0;
                if (input[input.length - 1].charAt(i) == '+') {
                    while (currentNums.size() > 0) {
                        total += currentNums.get(0);
                        currentNums.remove(0);
                    }
                } else if (input[input.length - 1].charAt(i) == '*') {
                    total = 1;
                    while (currentNums.size() > 0) {
                        total *= currentNums.get(0);
                        currentNums.remove(0);
                    }
                }
                System.out.println("total: " + total);
                grandTotal += total;
                i--;
            }
        }

        System.out.println(grandTotal);

        br.close();
    }
}

// change test.txt back for this one, no regex

// test: 3263827
// actual: 10875057285868