import java.io.*;

public class circle {
    public static double solve(int n, double[] x, double[] y) {
        double minX = x[0], maxX = x[0], minY = y[0], maxY = y[0];

        for (int i = 1; i < n; i++) {
            minX = Math.min(minX, x[i]);
            maxX = Math.max(maxX, x[i]);
            minY = Math.min(minY, y[i]);
            maxY = Math.max(maxY, y[i]);
        }

        return (maxX - minX) * (maxY - minY);
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);
    public static void main(String[] args) throws IOException {
        

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            double[] x = new double[n];
            double[] y = new double[n];
            for (int j = 0; j < n; j++) {
                String[] xy = br.readLine().split(" ");
                x[j] = Double.parseDouble(xy[0]);
                y[j] = Double.parseDouble(xy[1]);
            }
            out.println(solve(n, x, y));
        }

        out.close();
    }
}
