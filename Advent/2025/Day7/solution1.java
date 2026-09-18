package Day7;

import java.io.*;
import java.util.*;

public class solution1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Day7/actual.txt"));

        char[][] input = new char[142][];
        Set<Integer> beamIndices = new HashSet<>();
        for (int i = 0; i < input.length; i++) {
            input[i] = br.readLine().toCharArray();
        }

        long splits = 0;

        beamIndices.add(input[0].length / 2);
        input[1][input[0].length / 2] = '|';
        for (int i = 2; i < input.length; i+= 2) {
            Set<Integer> newBeamIndices = new HashSet<>();
            for (Integer beamIndex : beamIndices) {
                if (input[i][beamIndex] == '^') {
                    splits++;
                    newBeamIndices.add(beamIndex - 1);
                    newBeamIndices.add(beamIndex + 1);
                } else {
                    newBeamIndices.add(beamIndex);
                }
            }
            // visualize
            for (Integer beamIndex : newBeamIndices) {
                input[i][beamIndex] = '|';
                input[i + 1][beamIndex] = '|';
            }

            beamIndices = newBeamIndices;
        }

        // print char array
        for (char[] cs : input) {
            String line = "";
            for (char c : cs) {
                line += c;
            }
            System.out.println(line);
        }

        System.out.println(splits);
        

        br.close();
    }
}

// 1504