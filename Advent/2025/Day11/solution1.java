package Day11;

import java.util.*;
import java.io.*;

public class solution1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Day11/actual.txt"));

        int n = 587;
        HashMap<String, ArrayList<String>> connections = new HashMap<>();
        HashMap<String, Integer> paths = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            split[0] = split[0].substring(0, 3);
            ArrayList<String> currConnections = new ArrayList<>();
            for (int j = 1; j < split.length; j++) {
                currConnections.add(split[j]);
            }
            connections.put(split[0], currConnections);
            paths.put(split[0], 0);
        }

        // no used array, assume no loops
        paths.put("out", 0);
        LinkedList<String> queue = new LinkedList<>();
        queue.add("you");
        while (queue.size() > 0) {
            String curr = queue.removeFirst();
            paths.put(curr, paths.get(curr) + 1);
            if (curr.equals("out")) {
                continue;
            }
            for (String string : connections.get(curr)) {
                queue.add(string);
            }
        }
        // technically i only needed to keep track of the # of paths to out
        System.out.println(paths.get("out"));

        br.close();
    }
}

// 511