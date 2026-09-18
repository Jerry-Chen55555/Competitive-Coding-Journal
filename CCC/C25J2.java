import java.io.*;

public class C25J2{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int d = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());
        for (int i = 0; i < e; i++) {
            if (br.readLine().equals("+"))
                d += Integer.parseInt(br.readLine());
            else
                d -= Integer.parseInt(br.readLine());
        }

        pw.println(d);
        pw.close();
    }
}
