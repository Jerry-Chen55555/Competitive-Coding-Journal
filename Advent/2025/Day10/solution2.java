package Day10;

import java.io.*;
import java.util.*;

public class solution2 {
    static int solve(String s) {
        // getting input for 50 lines
        int j = 1;
        ArrayList<String> split = new ArrayList<>();
        String currString = "";
        boolean recording = false;
        while (j < s.length()) {
            if (s.charAt(j) == '(' || s.charAt(j) == '{') {
                recording = true;
            } else if (s.charAt(j) == ')' || s.charAt(j) == '}') {
                split.add(currString);
                currString = "";
                recording = false;
            } else if (recording) {
                currString += s.charAt(j);
            }
            j++;
        }
        
        int[][] buttons = new int[split.size() - 1][];
        for (int i = 0; i < buttons.length; i++) {
            String[] bString = split.get(i).split(",");
            buttons[i] = new int[bString.length];
            for (int k = 0; k < bString.length; k++) {
                buttons[i][k] = Integer.parseInt(bString[k]);
            }
        }
        String[] jString = split.get(split.size() - 1).split(",");
        int[] joltage = new int[jString.length];
        for (int i = 0; i < joltage.length; i++) {
            joltage[i] = Integer.parseInt(jString[i]);
        }

        for (int[] is : buttons) {
            System.out.println(Arrays.toString(is));
        }
        System.out.println(Arrays.toString(joltage));
        
        ArrayList<Integer> current = new ArrayList<>();
        for (@SuppressWarnings("unused") int a : joltage) {
            current.add(0);
        }
        // no two buttons will be pressed twice (because it does nothing)
        // the order doesnt matter
        // just get a set of lights = 2^(buttons.size()) possible ways

        // return Math.min(solve(lights, buttons, cost, 0, 0, current),
        // solve(lights, buttons, cost, 0, 1, applyButton(current, buttons[0])));

        return 1;
    }
    static ArrayList<Boolean> applyButton(ArrayList<Boolean> lights, int[] button) {
        ArrayList<Boolean> newArrayList = new ArrayList<>();
        for (Boolean b : lights) {
            newArrayList.add(b);
        }
        for (int i = 0; i < button.length; i++) {
            newArrayList.set(button[i], !newArrayList.get(button[i]));
        }
        return newArrayList;
    }
    static int solve(ArrayList<Boolean> lights, int[][] buttons, int[] cost, int buttonStart, int buttonsPressed, ArrayList<Boolean> current) {
        if (buttonStart == buttons.length - 1) {
            for (int i = 0; i < lights.size(); i++) {
                if (lights.get(i) != current.get(i)) {
                    return Integer.MAX_VALUE;
                }
            }
            return buttonsPressed;
        }
        return Math.min(solve(lights, buttons, cost, buttonStart + 1, buttonsPressed, current),
        solve(lights, buttons, cost, buttonStart + 1, buttonsPressed + 1, applyButton(current, buttons[buttonStart + 1])));
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Day10/actual.txt"));

        int n = 198;        
        long total = 0;
        for (int i = 0; i < n; i++) {
            total += solve(br.readLine());
        }

        System.out.println(total);
        

        br.close();
    }
}

// 4760959496