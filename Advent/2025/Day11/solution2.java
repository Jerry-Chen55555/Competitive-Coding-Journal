package Day11;

import java.util.*;
import java.io.*;

public class solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Day11/actual.txt"));

        int n = 587;
        HashMap<String, ArrayList<String>> connections = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            split[0] = split[0].substring(0, 3);
            ArrayList<String> currConnections = new ArrayList<>();
            for (int j = 1; j < split.length; j++) {
                currConnections.add(split[j]);
            }
            connections.put(split[0], currConnections);
        }

        // no used array, assume no loops
        LinkedList<String> qString = new LinkedList<>();
        LinkedList<HashSet<String>> qPassed = new LinkedList<>();
        qString.add("svr");
        qPassed.add(new HashSet<>(Arrays.asList("svr")));
        int totalOut = 0;
        while (qString.size() > 0) {
            String cString = qString.removeFirst();
            HashSet<String> cPassed = qPassed.removeFirst();
            System.out.println(cPassed.size());
            if (cString.equals("out")) {
                if (cPassed.contains("dac") && cPassed.contains("fft")) {
                    totalOut++;
                }
                continue;
            }
            for (String s : connections.get(cString)) {
                if (cPassed.contains(s)) {
                    continue;
                }
                HashSet<String> newPassed = new HashSet<>();
                newPassed.addAll(cPassed);
                newPassed.add(s);
                qString.add(s);
                qPassed.add(newPassed);
            }
        }

        System.out.println(totalOut);

        br.close();
    }
}

// had to change test because different test case
// 511