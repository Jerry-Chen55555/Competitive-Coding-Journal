package Day4;

import java.io.*;

public class solution1 {
    static int numNeighbors(int i, int j) {
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        int count = 0;
        for (int k = 0; k < dx.length; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            if (nx >= 0 && nx < wall[0].length && ny >= 0 && ny < wall.length && wall[nx][ny] == '@') {
                count++;
            }
        }
        return count;
    }


    static char[][] wall;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Day4/this.txt"));

        int count = 0;
        wall = new char[137][137];

        for (int i = 0; i < wall.length; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                wall[i][j] = s.charAt(j);
            }
        }
        
        int removed = 1;
        while (removed >= 1) {
            removed = 0;
            for (int i = 0; i < wall.length; i++) {
                for (int j = 0; j < wall[i].length; j++) {
                    if (wall[i][j] == '@' && numNeighbors(i, j) < 4) {
                        wall[i][j] = '.';
                        removed++;
                    }
                }
            }

            count += removed;
        }
        
        System.out.println(count);
        
        br.close();
    }
}

// solution 1: 1537
// solution 2: 8707

// its a few lines to get from sol1 to sol2 so no need for 2 files