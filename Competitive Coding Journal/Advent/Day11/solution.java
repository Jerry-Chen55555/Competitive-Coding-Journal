package Day11;

import java.io.*;
import java.util.ArrayList;

public class solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("Day11/example.txt"));

        ArrayList<Long> stones = new ArrayList<>();

        String[] split = br.readLine().split(" ");

        for (int i = 0; i < split.length; i++) {
            stones.add(Long.parseLong(split[i]));
        }

        int blinks = 4;

        for (int i = 0; i < blinks; i++) {
            for (int j = 0; j < stones.size(); j++) {
                if (stones.get(j) == 0) {
                    stones.set(j, 1L);
                } else if ((stones.get(j) + "").length() % 2 == 0) {
                    String stone = (stones.get(j) + "");
                    stones.set(j, Long.parseLong(stone.substring(0, stone.length()/2)));
                    stones.add(j, Long.parseLong(stone.substring(stone.length()/2)));
                    j++;
                } else {
                    stones.set(j, stones.get(j)*2024);
                }
            }
            System.out.print(stones.size() + ",");
        }

        br.close();
    }
}
