import java.io.*;
import java.util.*;

public class NumeralTriangle {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        
        PrintWriter pw = new PrintWriter(System.out);

        for (int i = 0; i < 5; i++) {
            String[] tokenString = br.readLine().split(" ");
            int[] tokens = new int[tokenString.length];

            // tokens[0] is start, tokens[1] is delta, tokens[2] is rows
            for (int j = 0; j < tokens.length; j++) {
                tokens[j] = Integer.parseInt(tokenString[j]);
            }
            
            int row = 2;
            long res = 0;
            int lastNumber = tokens[0];
            ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();

            triangle.add(new ArrayList<>(Arrays.asList(tokens[0])));
            for (int j = 1; j < tokens[2]; j++) {
                ArrayList<Integer> add = new ArrayList<>();
                for (int j2 = 0; j2 < row; j2++) {
                    lastNumber += tokens[1];
                    while (lastNumber >= 10) {
                        String lastNumberString = lastNumber + "";
                        lastNumber = 0;
                        for (int k = 0; k < lastNumberString.length(); k++) {
                            lastNumber += Integer.parseInt(lastNumberString.charAt(k) + "");
                        }
                    }
                    add.add(lastNumber);
                }
                triangle.add(add);
                row++;
            }

            for (int j = 0; j < triangle.get(triangle.size() - 1).size(); j++) {
                res += triangle.get(triangle.size() - 1).get(j);
            }

            pw.println((i + 1) + ". " + res);
        }
        pw.close();
        br.close();
    }
}
