package Day9;

import java.io.*;
import java.util.*;

public class solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("Day9/example.txt"));

        String line = br.readLine();

        ArrayList<Tuple<Integer, Integer>> expand = new ArrayList<>();
        boolean isFile = true;
        int ID = 0;
        long res = 0;

        for (int i = 0; i < line.length(); i++) {
            if (Integer.parseInt(line.charAt(i) + "") != 0) {
                if (isFile) {
                    expand.add(new Tuple<>(ID, Integer.parseInt(line.charAt(i) + "")));
                    ID++;
                } else {
                    expand.add(new Tuple<>(-1, Integer.parseInt(line.charAt(i) + "")));
                }
            }
            isFile = !isFile;
        }

        for (int i = expand.size()-1; i >= 0; i--) {
            if (expand.get(i).x != -1) {
                for (int j = 0; j < i; j++) {
                    if (expand.get(j).x == -1 && expand.get(j).y >= expand.get(i).y) {
                        if (expand.get(j).y == expand.get(i).y) {
                            Collections.swap(expand, i, j);
                        } else {
                            expand.set(j, new Tuple<>(-1, expand.get(j).y - expand.get(i).y));
                            expand.add(j, new Tuple<>(-1, expand.get(i).y));
                            Collections.swap(expand, i + 1, j);
                        }
                        break;
                    }
                }
            }
        }
        System.out.println();
        ArrayList<Integer> expandRes = new ArrayList<>();

        for (int i = 0; i < expand.size(); i++) {
            for (int j = 0; j < expand.get(i).y; j++) {
                expandRes.add(expand.get(i).x);
            }
        }

        for (int i = 0; i < expandRes.size(); i++) {
            if (expandRes.get(i) != -1) {
                res += expandRes.get(i) * i;
            }
        }
        System.out.println(res);

        br.close();
    }
}

class Tuple<X, Y> { 
    public final X x; 
    public final Y y; 
    public Tuple(X x, Y y) { 
      this.x = x; 
      this.y = y; 
    } 
}

// 6770791386551
// 6361209907931
// 6304576012713