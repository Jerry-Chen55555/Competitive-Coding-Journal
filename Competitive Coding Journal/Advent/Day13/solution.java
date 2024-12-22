package Day13;
import java.io.*;
import java.util.*;


public class solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("Day13/example.txt"));

        long res = 0;

        int size = 4;

        for (int i = 0; i < size; i++) {
            String buttonA = br.readLine();
            String buttonB = br.readLine();
            String[] goalTokens = br.readLine().split("=");
            
            int a = Integer.parseInt(buttonA.substring(12, 14));
            int b = Integer.parseInt(buttonA.substring(18, 20));
            int c = Integer.parseInt(buttonB.substring(12, 14));
            int d = Integer.parseInt(buttonB.substring(18, 20));

            int goalX = Integer.parseInt(goalTokens[1].split(", ")[0]);
            int goalY = Integer.parseInt(goalTokens[2]);

            

            br.readLine();
        }



        System.out.println(res);
    }
}
