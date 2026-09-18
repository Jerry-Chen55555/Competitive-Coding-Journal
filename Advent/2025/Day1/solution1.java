package Day1;

import java.io.*;

public class solution1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Day1/actual.txt"));
        PrintWriter pw = new PrintWriter(System.out);

        int tick = 50;
        int count = 0;
        for (int i = 0; i < 4256; i++) {
            String next = br.readLine();
            Character dir = next.charAt(0);
            int shift = Integer.parseInt(next.substring(1));

            if (dir == 'R') {
                tick += shift;
            } else {
                tick -= shift;
            }

            tick %= 100;
            if (tick < 0) {
                tick += 100;
            }

            if (tick == 0) {
                count++;
            }
        }

        pw.println(count);

        pw.close();
        br.close();
    }
}

// 1036