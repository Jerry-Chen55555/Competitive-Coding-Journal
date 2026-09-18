import java.io.*;

public class cannonball {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        String[] NS = br.readLine().split(" ");
        int N = Integer.parseInt(NS[0]);
        int currPosition = Integer.parseInt(NS[1]) - 1;
        // items = jump pads or targets
        // each item = [0 or 1 or 2][value]
        // 0 = jump pad, 1 = target, 2 = broken target
        int[][] items = new int[N][2];
        int power = 1;
        int direction = 1; // 1 or -1
        int targetsBroken = 0;
        int numberTargets = 0;
        int stepsLeft = 10000000;

        for (int i = 0; i < N; i++) {
            String[] QV = br.readLine().split(" ");
            items[i][0] = Integer.parseInt(QV[0]);
            items[i][1] = Integer.parseInt(QV[1]);
            if (items[i][0] == 1) {
                numberTargets++;
            }
        }

        while (currPosition >= 0 && currPosition < N && stepsLeft >= 0 && targetsBroken != numberTargets) {
            if (items[currPosition][0] == 1) { // if it is a target
                if (power >= items[currPosition][1]) {
                    items[currPosition][0] = 2;
                    targetsBroken++;
                }
            } else if (items[currPosition][0] == 0) {
                power += items[currPosition][1];
                direction *= -1;
            }  

            currPosition += direction * power;
            stepsLeft--;
        }
        pw.println(targetsBroken);
        pw.close();
        br.close();
    }
}
