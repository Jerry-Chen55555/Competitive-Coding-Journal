package Day7;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Day7/actual.txt"));

        char[][] input = new char[142][];
        HashMap<Integer, Long> beamIndices = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            input[i] = br.readLine().toCharArray();
        }

        beamIndices.put(input[0].length / 2, 1L);
        input[1][input[0].length / 2] = '|';
        for (int i = 2; i < input.length; i+= 2) {
            HashMap<Integer, Long> newBeamIndices = new HashMap<>();
            for (Integer beamIndex : beamIndices.keySet()) {
                if (input[i][beamIndex] == '^') {
                    newBeamIndices.put(beamIndex - 1, newBeamIndices.getOrDefault(beamIndex - 1, 0L) + beamIndices.get(beamIndex));
                    newBeamIndices.put(beamIndex + 1, newBeamIndices.getOrDefault(beamIndex + 1, 0L) + beamIndices.get(beamIndex));
                } else {
                    newBeamIndices.put(beamIndex, newBeamIndices.getOrDefault(beamIndex, 0L) + beamIndices.get(beamIndex));
                }
            }
            // visualize
            for (Integer beamIndex : newBeamIndices.keySet()) {
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

        long total = 0;
        for (Entry<Integer, Long> e : beamIndices.entrySet()) {
            total += e.getValue();
        }
        System.out.println(total);
        

        br.close();
    }
}

// 5137133207830