import java.io.*;

public class J4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        
        boolean slimy[][] = new boolean[M*20][M*20];

        for (int i = 0; i < M*20; i++) {
            for (int j = 0; j < M*20; j++) {
                slimy[i][j] = false;
            }
        }

        int sx = M*10;
        int sy = M*10;

        slimy[sx][sy] = true;
        int slimyTouched = 0;
        for (int i = 0; i < M; i++) {
            String instruction = br.readLine();
            char direction = instruction.charAt(0);
            int distance = Integer.parseInt(instruction.substring(1));
            int nx = sx;
            int ny = sy;
            if (direction == 'N') {
                for (ny = sy + 1; ny < sy + distance; ny++) {
                    if (slimy[nx][ny]) {
                        slimyTouched++;
                    }
                    slimy[nx][ny] = true;
                }
            } else if (direction == 'S') {
                for (ny = sy - 1; ny > sy - distance; ny--) {
                    if (slimy[nx][ny]) {
                        slimyTouched++;
                    }
                    slimy[nx][ny] = true;
                }
            } else if (direction == 'E') {
                for (nx = sx + 1; ny < sx + distance; nx++) {
                    if (slimy[nx][ny]) {
                        slimyTouched++;
                    }
                    slimy[nx][ny] = true;
                }
            } else if (direction == 'W') {
                for (nx = sx - 1; nx > sx - distance; nx--) {
                    if (slimy[nx][ny]) {
                        slimyTouched++;
                    }
                    slimy[nx][ny] = true;
                }
            }
            if (slimy[nx][ny]) {
                slimyTouched++;
            }
            slimy[nx][ny] = true;
            sx = nx;
            sy = ny;
        }

        System.out.println(slimyTouched);
    }
}
