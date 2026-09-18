import java.util.*;

public class arduino {
    public static void main(String[] args) {
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int[] GOAL = {3, 4};
        
        int[][][] walls = {
            {{1,0,0,1},{1,0,0,0},{1,0,1,0},{1,0,1,0},{1,0,1,0},{1,0,1,0},{1,0,0,0},{1,1,0,0}},
            {{0,1,0,1},{0,0,1,1},{1,1,0,0},{1,0,0,1},{1,0,1,0},{1,1,0,0},{0,1,0,1},{0,1,0,1}},
            {{0,1,0,1},{1,0,0,1},{0,1,1,0},{0,0,1,1},{1,1,0,0},{0,0,1,1},{0,1,1,0},{0,1,0,1}},
            {{0,1,0,1},{0,0,1,1},{1,0,1,0},{1,1,1,0},{0,1,1,1},{1,0,0,1},{1,0,1,0},{0,1,0,0}},
            {{0,1,0,1},{1,0,1,1},{1,0,1,0},{1,0,0,0},{1,1,1,0},{0,1,0,1},{1,1,1,1},{0,1,0,1}},
            {{0,0,1,1},{1,0,1,0},{1,0,1,0},{0,1,0,0},{1,0,1,1},{0,1,1,0},{1,0,0,1},{0,1,0,0}},
            {{1,0,0,1},{1,1,0,0},{1,1,1,1},{0,0,1,1},{0,1,1,0},{1,0,0,1},{0,1,1,0},{0,1,0,1}},
            {{0,1,1,1},{0,0,1,1},{1,0,1,0},{1,0,1,0},{1,0,1,0},{0,0,1,0},{1,0,1,0},{0,1,1,0}}
        };
        // int[][][] walls = {
        //     {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}},
        //     {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}},
        //     {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}},
        //     {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}},
        //     {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}},
        //     {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}},
        //     {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}},
        //     {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}}
        // };

        for (int[][] row : walls) {
            for (int[] col : row) {
                if (col[0] == 1 && col[3] == 1) {
                    System.out.print("|‾");
                } else if (col[0] == 1) {
                    System.out.print(" ‾");
                } else if (col[3] == 1) {
                    System.out.print("| ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println("|");
        }
        System.out.println(" ‾ ‾ ‾ ‾ ‾ ‾ ‾ ‾");

        System.out.println();

        int[][] floodFillBoard = {
                { -1, -1, -1, -1, -1, -1, -1, -1 },
                { -1, -1, -1, -1, -1, -1, -1, -1 },
                { -1, -1, -1, -1, -1, -1, -1, -1 },
                { -1, -1, -1, -1, -1, -1, -1, -1 },
                { -1, -1, -1, -1, -1, -1, -1, -1 },
                { -1, -1, -1, -1, -1, -1, -1, -1 },
                { -1, -1, -1, -1, -1, -1, -1, -1 },
                { -1, -1, -1, -1, -1, -1, -1, -1 }
        };
        int currPos[] = {7, 0};

        floodFillBoard[GOAL[0]][GOAL[1]] = 0;

        // q = queue :p
        int[][] q = new int[64][2];
        for (int i = 0; i < 64; i++) {
            q[i][0] = -1;
            q[i][1] = -1;
        }
        
        int qHead = 0;
        int qTail = 1;

        // FLOODFILL
        // add GOAL as first item
        q[0][0] = GOAL[0];
        q[0][1] = GOAL[1];
        while (qHead != qTail) {
            // currItem = q.pop();
            int currX = q[qHead][0];
            int currY = q[qHead][1];
            qHead = (qHead + 1) % 64;

            // check 4 directions
            for (int i = 0; i < 4; i++) {
                int nextX = currX + directions[i][0];
                int nextY = currY + directions[i][1];
                if (nextX >= 0 && nextX < 8 // check bounds x
                        && nextY >= 0 && nextY < 8 // check bounds y
                        && floodFillBoard[nextX][nextY] == -1 // check if not used
                        && walls[currX][currY][(i + 1) % 4] == 0) { // check wall; i is the direction
                    floodFillBoard[nextX][nextY] = floodFillBoard[currX][currY] + 1;

                    // q.add(nextItem);
                    q[qTail][0] = nextX;
                    q[qTail][1] = nextY;
                    qTail = (qTail + 1) % 64;

                    // breaks out of the whole thing if currPos is found
                    if (currPos[0] == nextX && currPos[1] == nextY) {
                        qHead = qTail;
                        break;
                    }
                }
            }
        }
        for (int[] a : floodFillBoard) {
            System.out.println(Arrays.toString(a));
        }
        // CREATE PATH

        String path = "";
        int currStepsAway = floodFillBoard[currPos[0]][currPos[1]];

        // step limit so while loop doesnt run forever
        int stepLimit = 65;
        int currX = currPos[0];
        int currY = currPos[1];
        while (currStepsAway != 0 && stepLimit != 0) {
            for (int i = 0; i < 4; i++) {
                int nextX = currX + directions[i][0];
                int nextY = currY + directions[i][1];
                if (nextX >= 0 && nextX < 8 // check bounds x
                        && nextY >= 0 && nextY < 8 // check bounds y
                        && floodFillBoard[nextX][nextY] == floodFillBoard[currX][currY] - 1) { // check decreasing
                    path += "" + i;
                    currX = nextX;
                    currY = nextY;
                    currStepsAway--;
                    break;
                }
            }
            stepLimit--;
        }

        System.out.println(path);
    }
}
