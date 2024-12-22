import java.io.*;
import java.util.*;

public class MooinTime {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        HashMap<String, Integer> possibleMoos = new HashMap<>();
        ArrayList<String> confirmedMoos = new ArrayList<>();

        String[] tokens = br.readLine().split(" ");
        String secondLine = br.readLine();

        int n = secondLine.length();
        int f = Integer.parseInt(tokens[1]);


        if (f == 1) {
            for (int i = 0; i < n - 2; i++) {
                if (secondLine.charAt(i + 1) == secondLine.charAt(i + 2) && confirmedMoos.indexOf('a' + secondLine.substring(i + 1, i + 3)) == -1) {
                    for (char c = 'a'; c <= 'z'; ++c) {
                        if (c == secondLine.charAt(i + 1)) {
                            continue;
                        }
                        confirmedMoos.add(c + secondLine.substring(i + 1, i + 3));
                    }
                }
            }
        } else {
            for (int i = 0; i < n - 2; i++) {
                if (secondLine.charAt(i + 1) == secondLine.charAt(i + 2)
                        && secondLine.charAt(i) != secondLine.charAt(i + 1)) {
                    if (possibleMoos.get(secondLine.substring(i, i + 3)) == null) {
                        possibleMoos.put(secondLine.substring(i, i + 3), 1);
                    } else {
                        possibleMoos.put(secondLine.substring(i, i + 3),
                                possibleMoos.remove(secondLine.substring(i, i + 3)) + 1);
                    }
                    i++;
                }
            }
            ArrayList<String> keys = new ArrayList<>();
            for (String key : possibleMoos.keySet()) {
                keys.add(key);
            }
            for (int i = 0; i < keys.size(); i++) {
                String key = keys.get(i);
                if (possibleMoos.get(key) >= f) {
                    confirmedMoos.add(key);
                    possibleMoos.remove(key);
                } else if (possibleMoos.get(key) != f - 1) {
                    possibleMoos.remove(key);
                }
            }
            if (possibleMoos.size() != 0) {
                for (int i = 0; i < n - 2; i++) {
                    ArrayList<String> keysl = new ArrayList<>();
                    for (String key : possibleMoos.keySet()) {
                        keysl.add(key);
                    }
                    for (int j = 0; j < keysl.size(); j++) {
                        String key = keysl.get(j);
                        if (secondLine.charAt(i) == key.charAt(0) && secondLine.charAt(i + 1) == key.charAt(1) && secondLine.charAt(i + 2) != key.charAt(2)) {
                            if (!((i < n - 3 && secondLine.substring(i + 1, i + 4).equals(key)) ||
                                (i < n - 4 && secondLine.substring(i + 2, i + 5).equals(key)))) {
                                confirmedMoos.add(key);
                                possibleMoos.remove(key);
                            }
                        }
                        if (secondLine.charAt(i) == key.charAt(0) && secondLine.charAt(i + 1) != key.charAt(1) && secondLine.charAt(i + 2) == key.charAt(2)) {
                            if (!((i < n - 3 && secondLine.substring(i + 1, i + 4).equals(key)) ||
                                (i > 0 && secondLine.substring(i - 1, i + 2).equals(key)))) {
                                confirmedMoos.add(key);
                                possibleMoos.remove(key);
                            }
                        }
                        if (secondLine.charAt(i) != key.charAt(0) && secondLine.charAt(i + 1) == key.charAt(1) && secondLine.charAt(i + 2) == key.charAt(2)) {
                            if (!((i > 1 && secondLine.substring(i - 2, i + 1).equals(key)) ||
                                (i > 0 && secondLine.substring(i - 1, i + 2).equals(key)))) {
                                confirmedMoos.add(key);
                                possibleMoos.remove(key);
                            }
                        }
                    }
                }
            }
        }
        Collections.sort(confirmedMoos);
        pw.println(confirmedMoos.size());
        for (int i = 0; i < confirmedMoos.size(); i++) {
            pw.println(confirmedMoos.get(i));
        }

        br.close();
        pw.close();
    }
}