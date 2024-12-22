package Day6;
import java.io.*;


public class solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File("Day6/real.txt").getAbsoluteFile()));
        BufferedReader pp = new BufferedReader(new FileReader(new File("Day6/possiblePositions.txt").getAbsoluteFile()));


        String[] map = new String[130];
        int posX = 0, posY = 0;
        int permPosX = 0, permPosY = 0;
        int dir = 0;
        int dirX = 0, dirY = 1;
        long res = 0;

        String[] ppY = pp.readLine().split(" ");
        String[] ppX = pp.readLine().split(" ");
        
        

        for (int i = 0; i < map.length; i++) {
            map[i] = br.readLine();
        }
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length(); j++) {
                if (map[i].charAt(j) == '^') {
                    permPosX = j;
                    permPosY = i;
                    map[i] = map[i].substring(0, j) + '.' + map[i].substring(j + 1);
                }
            }
        }
        for (int i = 0; i < ppX.length; i++) {
            String[] newMap = map.clone();
            dir = 0;
            posX = permPosX;
            posY = permPosY;
            int x = Integer.parseInt(ppX[i]);
            int y = Integer.parseInt(ppY[i]);
            newMap[y] = newMap[y].substring(0, x) + '#' + newMap[y].substring(x + 1);

            
            boolean isOut = false;
            while (!isOut) {
                if (dir == 0) {
                    dirX = 0;
                    dirY = -1;
                } else if (dir == 1) {
                    dirX = 1;
                    dirY = 0;
                } else if (dir == 2) {
                    dirX = 0;
                    dirY = 1;
                } else if (dir == 3) {
                    dirX = -1;
                    dirY = 0;
                }
                posX += dirX;
                posY += dirY;
                if (posX >= newMap[0].length() || posX < 0 || posY >= newMap.length || posY < 0) {
                    isOut = true;
                
                } else if (newMap[posY].charAt(posX) == '#') {
                    dir ++;
                    posX -= dirX;
                    posY -= dirY;
                } else if(newMap[posY].charAt(posX) != '.' && Integer.parseInt(newMap[posY].charAt(posX) + "") == dir){
                    break;
                } else {
                    newMap[posY] = newMap[posY].substring(0, posX) + dir + newMap[posY].substring(posX + 1);
                }
                dir = dir % 4;
                // if (dir == 0) {
                //     for (int b = 0; b < newMap.length; b++) {
                //         System.out.println(newMap[b]);
                //     }
                // }
                //System.out.println("--------------------------------------------------------");
            }
            if (!isOut) {
                res ++;
            }
            // if (i == 100) {
            //     for (int b = 0; b < newMap.length; b++) {
            //         System.out.println(newMap[b]);
            //     }
            // }
        }


        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[i].charAt(j) == 'X') {
                    System.out.print(j+ " ");
                    res++;
                }
            }
        }
        for (int i = 0; i < map.length; i++) {
            System.out.println(map[i]);
        }
        System.out.println(res);
        br.close();
        pp.close();
    }
}