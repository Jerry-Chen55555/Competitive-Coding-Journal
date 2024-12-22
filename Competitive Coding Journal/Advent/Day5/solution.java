package Day5;

import java.util.*;
import java.io.*;

class sortByInstruction implements Comparator<Integer> {
    
    public int compare(Integer a, Integer b) {
        BufferedReader comparisons = new BufferedReader(new InputStreamReader(System.in));
        try {
            comparisons = new BufferedReader(new FileReader("Day5/comparisons.txt"));
        } catch (Exception e) {
            // ball;
        }
        for (int i = 0; i < 1176; i++) {
            String line = "";
            try {
                line = comparisons.readLine();
            } catch (Exception e) {
                //balls
            }
            
            int one = Integer.parseInt(line.substring(0, 2));
            int two = Integer.parseInt(line.substring(3, 5));

            if (a == one && b == two) {
                try {
                    comparisons.close();
                } catch (Exception e) {
                }
                return -1;
            } else if (b == one && a == two) {
                try {
                    comparisons.close();
                } catch (Exception e) {
                }
                return 1;
            }
        }
        try {
            comparisons.close();
        } catch (Exception e) {
        }
        return 0;
    }
}

public class solution {

    public static void main(String[] args) throws Exception {
        BufferedReader lists = new BufferedReader(new FileReader("Day5/lists.txt"));
        BufferedReader comparisons = new BufferedReader(new FileReader("Day5/comparisons.txt"));

        Long res = 0L;

        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(78, 73, 32, 18, 93, 46, 69, 43, 84, 11, 86, 36, 34, 81, 95, 74, 67, 53, 56, 66, 48, 26, 15, 44, 89, 92, 24, 52, 57, 68, 47, 42, 64, 97, 22, 38, 41, 76, 19, 91, 29, 82, 98, 59, 12, 37, 96, 71, 63));

        for (int i = 0; i < 193; i++) {
            // ArrayList<Integer> simpleInstruction1 = new ArrayList<>();
            // ArrayList<Integer> simpleInstruction2 = new ArrayList<>();

            String[] numStrings = lists.readLine().split(",");
            ArrayList<Integer> nums = new ArrayList<>();
            for (int j = 0; j < numStrings.length; j++) {
                nums.add(Integer.parseInt(numStrings[j]));
            }
            ArrayList<Integer> newNumbers = new ArrayList<>();
            for (int j = 0; j < numbers.size(); j++) {
                if (nums.indexOf(numbers.get(j)) != -1) {
                    newNumbers.add(numbers.get(j));
                }
            }

            // for (int j2 = 0; j2 < instructions1.size(); j2++) {
            //     if (nums.indexOf(instructions1.get(j2)) != -1 && nums.indexOf(instructions2.get(j2)) != -1) {
            //         simpleInstruction1.add(instructions1.get(j2));
            //         simpleInstruction2.add(instructions2.get(j2));
            //     }
            // }

            // ArrayList<Integer> newNumbers = new ArrayList<>();

            // while (simpleInstruction1.size() != 0) {
            //     int mostValue = simpleInstruction2.get(0);
            //     boolean isMost = false;
            //     while (!isMost) {
            //         if (simpleInstruction1.indexOf(mostValue) == -1) {
            //             isMost = true;
            //             int b = simpleInstruction1.size();
            //             ArrayList<Integer> oldInstructions1 = simpleInstruction1;
            //             ArrayList<Integer> oldInstructions2 = simpleInstruction2;
            //             simpleInstruction1 = new ArrayList<>();
            //             simpleInstruction2 = new ArrayList<>();
            //             for (int j = 0; j < b; j++) {
            //                 if (oldInstructions2.get(j) != mostValue) {
            //                     simpleInstruction1.add(oldInstructions1.get(j));
            //                     simpleInstruction2.add(oldInstructions2.get(j));
            //                 }
            //             }
            //         } else {
            //             mostValue = simpleInstruction2.get(simpleInstruction1.indexOf(mostValue));
            //         }
            //     }
            //     newNumbers.addFirst(mostValue);
            // }
            // for (int j = 0; j < nums.size(); j++) {
            //     if (newNumbers.indexOf(nums.get(j)) == -1) {
            //         newNumbers.addFirst(nums.get(j));
            //     }
            // }
            System.out.println(Arrays.toString(newNumbers.toArray()));
            res += nums.get(newNumbers.size() / 2);
        }
        // for (int i = 0; i < 193; i++) {
        // String[] line = br.readLine().split(",");
        // int[] lineIndexes = new int[line.length];
        // for (int j = 0; j < line.length; j++) {
        // lineIndexes[j] = numbers.indexOf(Integer.parseInt(line[j]));
        // }
        // Arrays.sort(lineIndexes);

        // res += numbers.get(lineIndexes[lineIndexes.length / 2]);
        // }
        System.out.println(res);
        
        lists.close();
        comparisons.close();
    }
}