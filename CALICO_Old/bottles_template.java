import java.io.*;
import java.util.*;

class bottles_template {
    /**
    * Output the minimum total wait time on the first line.
    * Output the optimal new permutation on the second line.
    * 
    * N: the number of students in line
    * C: the list of the bottle capacities, in liters, for each student
    */
    static void solve (int N, int[] C) {
        ArrayList<Integer> sorted = new ArrayList<>();
        ArrayList<Tuple> movedPeopleOrder = new ArrayList<>();
        int[] res = new int[N];
        for (int i = 0; i < N; i++) {
            res[i] = i;
            sorted.add(C[i]);
        }
        // make sorted actually sorted
        Collections.sort(sorted);

        for (int i = 0; i < sorted.size(); i++) {
            if (C[i] != sorted.get(i)) {
                movedPeopleOrder.add(new Tuple(C[i], i));
            }
        }

        // sort movedPeopleOrder to get it in order
        Collections.sort(movedPeopleOrder);

        // calculate total and print and merge movedPeopleOrder with res
        long total = 0;
        String print = "";

        int movedPeopleOrderIndex = 0;
        for (int i = 0; i < N; i++) {
            if (C[i] != sorted.get(i)) {
                res[i] = movedPeopleOrder.get(movedPeopleOrderIndex).y;
                movedPeopleOrderIndex++;
            }
            total += sorted.get(i) * (N - i);
            print += res[i] + 1 + " ";
        }

        out.println(total);
        out.println(print);
    }
    
    
    static PrintWriter out = new PrintWriter(System.out);
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws IOException {
        
        int T = Integer.parseInt(in.readLine());
        for (int i = 0; i < T; ++i) {
            int N = Integer.parseInt(in.readLine());
            String[] Cs = in.readLine().split(" ");
            int[] C = new int[N];
            for (int j = 0; j < N; ++j) C[j] = Integer.parseInt(Cs[j]);
            solve(N, C);
        }
        out.flush();
    }
}

class Tuple implements Comparable<Tuple> { 
    public final int x; 
    public final int y; 
    public Tuple(int x, int y) { 
      this.x = x; 
      this.y = y;
    }

    public int compareTo(Tuple t) {
        if (x == t.x) return 0;
        if (x > t.x) return 1;
        return -1;
    }
}