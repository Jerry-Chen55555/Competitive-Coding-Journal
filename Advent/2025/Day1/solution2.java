package Day1;

import java.io.*;

public class solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Day1/actual.txt"));
        PrintWriter pw = new PrintWriter(System.out);

        int tick = 50;
        int count = 0;
        for (int i = 0; i < 4256; i++) {
            String next = br.readLine();
            Character dir = next.charAt(0);
            int shift = Integer.parseInt(next.substring(1));

            count += shift / 100;

            

            if (dir == 'R') {
                tick += shift % 100;
            } else {
                // avoid overcounting
                if (tick == 0) {
                    count--;
                }
                tick -= shift % 100;
            }

            if (tick >= 100 || tick <= 0) {
                count++;
                tick = (tick + 100) % 100;
            }
        }

        pw.println(count);

        pw.close();
        br.close();
    }
}

// 6225 too low
// 6765 too high
// 6228