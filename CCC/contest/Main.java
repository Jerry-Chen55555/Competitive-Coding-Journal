import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        
        boolean slimy[][] = new boolean[M*20][M*20];

        int sx = M*10;
        int sy = M*10;
        slimy[sx][sy] = true;
        int slimyTouched = 0;
        for (int i = 0; i < M; i++) {
            String instruction = br.readLine();
            char direction = instruction.charAt(0);
            int distance = Integer.parseInt(instruction.substring(1));
            for (int j = 0; j < distance; j++) {
                if (direction == 'N') {
                    sy++;
                } else if (direction == 'S') {
                    sy--;
                } else if (direction == 'E') {
                    sx++;
                } else if (direction == 'W') {
                    sx--;
                }
                if (slimy[sx][sy]) slimyTouched++;
                slimy[sx][sy] = true;
            }
        }

        System.out.println(slimyTouched);
    }
}