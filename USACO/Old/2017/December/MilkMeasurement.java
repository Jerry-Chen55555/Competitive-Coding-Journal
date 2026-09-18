import java.util.*;
import java.io.*;

public class MilkMeasurement {

    public static String[] winners(HashMap<String, Integer> cows) {
        int highest = -1;
        for (Integer value : cows.values()) {
            if (value > highest) {
                highest = value;
            }
        }
        ArrayList<String> res = new ArrayList<>();
        for (String key : cows.keySet()) {
            if (cows.get(key) == highest) {
                res.add(key);
            }
        }
        return res.toArray(new String[res.size()]);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("measurement.in"));
        PrintWriter pw = new PrintWriter("measurement.out");

        HashMap<String, Integer> cows = new HashMap<>(Map.of("Bessie", 0, "Elsie", 0, "Mildred", 0));
        
        String[] currWinners = winners(cows);
        int res = 0;
        int n = Integer.parseInt(br.readLine());

        String[] cowInstructions = new String[101];
        int[] numInstructions = new int[101];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            cowInstructions[day] = st.nextToken();
            numInstructions[day] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 100; i++) {
            if (numInstructions[i] == 0) {continue;}
            cows.put(cowInstructions[i], cows.remove(cowInstructions[i]) + numInstructions[i]);
            if (!Arrays.equals(currWinners, winners(cows))) {
                res++;
                currWinners = winners(cows);
            }
        }

        pw.println(res);

        pw.close();
        br.close();
    }
}