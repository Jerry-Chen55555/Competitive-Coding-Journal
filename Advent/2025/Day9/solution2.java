package Day9;

import java.io.*;
import java.util.*;

public class solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Day9/actual.txt"));

        int n = 496;

        // goofy ahh coordinate compression
        HashSet<Integer> xHash = new HashSet<>();
        HashSet<Integer> yHash = new HashSet<>();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            String[] lineSplit = br.readLine().split(",");
            x[i] = Integer.parseInt(lineSplit[0]);
            y[i] = Integer.parseInt(lineSplit[1]);
            xHash.add(Integer.parseInt(lineSplit[0]));
            yHash.add(Integer.parseInt(lineSplit[1]));
        }
        ArrayList<Integer> xList = new ArrayList<>(xHash);
        ArrayList<Integer> yList = new ArrayList<>(yHash);
        Collections.sort(xList);
        Collections.sort(yList);

        HashMap<Integer, Integer> xs = new HashMap<>();
        HashMap<Integer, Integer> ys = new HashMap<>();

        for (int i = 0; i < xList.size(); i++) 
            xs.put(xList.get(i), i);
        for (int i = 0; i < yList.size(); i++) 
            ys.put(yList.get(i), i);


        char[][] board = new char[xs.size()][ys.size()];
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board.length; j++)
                board[i][j] = '.';
        
        for (int i = 0; i < n; i++) {
            board[xs.get(x[i])][ys.get(y[i])] = '#';
        }
        
        // trace lines
        for (int i = 0; i < n; i++) {
            int ni = (i + 1) % n; // next index
            if (x[i] == x[ni])
                if (y[i] < y[ni])
                    for (int j = ys.get(y[i]); j <= ys.get(y[ni]); j++) 
                        board[xs.get(x[i])][j] = 'X';
                else
                    for (int j = ys.get(y[ni]); j <= ys.get(y[i]); j++)
                        board[xs.get(x[i])][j] = 'X';
            else if (y[i] == y[ni])
                if (x[i] < x[ni])
                    for (int j = xs.get(x[i]); j <= xs.get(x[ni]); j++) 
                        board[j][ys.get(y[i])] = 'X';
                else
                    for (int j = xs.get(x[ni]); j <= xs.get(x[i]); j++) 
                        board[j][ys.get(y[i])] = 'X';
            
        }
        // floodfill
        List<int[]> q = new LinkedList<>();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        q.add(new int[]{200, 100}); // random ah coords
        while (q.size() > 0) {
            int[] next = q.removeFirst();
            for (int i = 0; i < dx.length; i++) {
                int[] c = {next[0] + dx[i], next[1] + dy[i]};
                if (c[0] >= 0 && c[0] < board.length && c[1] >= 0 && c[1] < board[0].length && board[c[0]][c[1]] == '.') {
                    board[c[0]][c[1]] = 'X';
                    q.add(c);
                }
            }
        }

        long maxArea = 0;

        for (int i = 0; i < x.length; i++) {
            for (int j = i + 1; j < y.length; j++) {
                boolean allX = true;
                int xStart, xEnd, yStart, yEnd;
                if (x[i] < x[j]) {
                    xStart = xs.get(x[i]);
                    xEnd = xs.get(x[j]);
                } else {
                    xStart = xs.get(x[j]);
                    xEnd = xs.get(x[i]);
                }
                if (y[i] < y[j]) {
                    yStart = ys.get(y[i]);
                    yEnd = ys.get(y[j]);
                } else {
                    yStart = ys.get(y[j]);
                    yEnd = ys.get(y[i]);
                }

                for (int k = xStart; k <= xEnd; k++) {
                    for (int l = yStart; l <= yEnd; l++) {
                        if (board[k][l] == '.') {
                            allX = false;
                        }
                    }
                }
                
                if (allX) {
                    maxArea = Math.max(maxArea, ((long) Math.abs(x[i] - x[j]) + 1) * (Math.abs(y[i] - y[j]) + 1));
                }
            }
        }

        System.out.println(maxArea);
        

        br.close();
    }
}

// 1343576598