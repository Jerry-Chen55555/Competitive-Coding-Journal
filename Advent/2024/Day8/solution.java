package Day8;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("Day8/input.txt"));

        long res = 0;
        ArrayList<String> antennaChart = new ArrayList<>();
        
        HashMap<Character, ArrayList<Tuple<Integer, Integer>>> frequencyMap = new HashMap<>();

        ArrayList<String> antinodeChart = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            antennaChart.add(br.readLine());
            String add = "";
            for (int j = 0; j < antennaChart.get(i).length(); j++) {
                add += '.';
            }
            antinodeChart.add(add);
            for (int j = 0; j < antennaChart.get(i).length(); j++) {
                char characterAt = antennaChart.get(i).charAt(j);
                if (characterAt == '.') {continue;}
                if (frequencyMap.get(characterAt) == null) {
                    frequencyMap.put(characterAt, new ArrayList<>(Arrays.asList(new Tuple<>(i, j))));
                } else {
                    ArrayList<Tuple<Integer, Integer>> old = frequencyMap.get(characterAt);
                    old.add(new Tuple<>(i, j));
                    frequencyMap.remove(characterAt);
                    frequencyMap.put(characterAt, old);
                }
            }
        }

        for (Character key : frequencyMap.keySet()) {
            ArrayList<Tuple<Integer, Integer>> value = frequencyMap.get(key);
            for (int i = 0; i < value.size(); i++) {
                for (int j = i + 1; j < value.size(); j++) {
                    boolean isIn = true;
                    int counter = 0;
                    int xDistance = value.get(i).x - value.get(j).x;
                    int yDistance = value.get(i).y - value.get(j).y;
                    int x1 = 0, y1 = 0;
                    while (isIn) {
                        x1 = value.get(i).x + xDistance * counter;
                        y1 = value.get(i).y + yDistance * counter;

                        if (x1 >= 0 && x1 < antinodeChart.size() && y1 >= 0 && y1 < antinodeChart.get(0).length()) {
                            System.out.println(x1 + " " + y1);
                            antinodeChart.set(y1, antinodeChart.get(y1).substring(0, x1) + '#' + antinodeChart.get(y1).substring(x1 + 1));
                        } else {
                            isIn = false;
                        }
                        counter++;
                    }
                    isIn = true;
                    counter = 0;
                    while (isIn) {
                        x1 = value.get(j).x - xDistance * counter;
                        y1 = value.get(j).y - yDistance * counter;

                        if (x1 >= 0 && x1 < antinodeChart.size() && y1 >= 0 && y1 < antinodeChart.get(0).length()) {
                            antinodeChart.set(y1, antinodeChart.get(y1).substring(0, x1) + '#' + antinodeChart.get(y1).substring(x1 + 1));
                        } else {
                            isIn = false;
                        }
                        counter++;
                    }
                }
            }
        }

        // for (Character key : frequencyMap.keySet()) {
        //     System.out.print(key + ": ");
        //     for (int j = 0; j < frequencyMap.get(key).size(); j++) {
        //         System.out.println("(" + frequencyMap.get(key).get(j).x + ", " + frequencyMap.get(key).get(j).y + ")");
        //     }
        // }

        for (int i = 0; i < antinodeChart.size(); i++) {
            System.out.println(antinodeChart.get(i));
            for (int j = 0; j < antinodeChart.get(i).length(); j++) {
                if (antinodeChart.get(i).charAt(j) == '#') {
                    res++;
                }
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