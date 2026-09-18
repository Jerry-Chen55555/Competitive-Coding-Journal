package Day6;

import java.io.*;
import java.util.*;

public class solution1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Day6/actual.txt"));

        String[][] nums = new String[4][];
        String[] operations;

        for (int i = 0; i < nums.length; i++) {
            nums[i] = br.readLine().split(" +");
            System.out.println(Arrays.toString(nums[i]));
        }

        operations = br.readLine().split(" +");
        
        long grandTotal = 0;

        for (int i = 0; i < operations.length; i++) {
            long total = 0;
            if (operations[i].equals("+")) {
                for (int j = 0; j < nums.length; j++) {
                    total += Long.parseLong(nums[j][i]);
                }
            } else if (operations[i].equals("*")) {
                total = 1;
                for (int j = 0; j < nums.length; j++) {
                    total *= Long.parseLong(nums[j][i]);
                }
            }
            grandTotal += total;
        }

        System.out.println(grandTotal);

        br.close();
    }
}

// had to remove starting spaces from test.txt for regex to work
// no need to alter actual.txt though

// 4580995422905