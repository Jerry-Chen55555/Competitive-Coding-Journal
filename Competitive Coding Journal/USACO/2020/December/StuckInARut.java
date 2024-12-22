// NOT MY SOLUTION (i tried to comment it up though)
// this solution isn't simulation

import java.util.*;
     
public class StuckInARut {
 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] xs = new int[n];
        int[] ys = new int[n];
        char[] dir = new char[n];

        // populate arrays with input 
        for (int j = 0; j < n; j++) {
            dir[j] = in.next().charAt(0);
            xs[j] = in.nextInt();
            ys[j] = in.nextInt();
        }

        // answer array
        int[] answer = new int[n];

        // make every answer max_value (this represents infinity as the values for x and y can't be greater as stated in the problem)
        Arrays.fill(answer, Integer.MAX_VALUE);

        // make list of differences between each x and each y
        List<Integer> differences = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            for (int k = j + 1; k < n; k++) {
                differences.add(Math.abs(xs[k] - xs[j]));
                differences.add(Math.abs(ys[k] - ys[j]));
            }
        }
        // sort
        Collections.sort(differences);

        // iterate through differences to check if the difference actually exists 
        for (int d : differences) {
            // iterate twice because we need two cows to compare
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {

                    // if first is e, second is n and first is to the left of second, second is below first
                    if (dir[j] == 'E' && dir[k] == 'N' && xs[j] < xs[k] && ys[k] < ys[j]) {

                        // if x's intersect after d, and y's don't intersect before x does:
                        // mark answer of East cow as the earliest possible value (Math.min)
                        if (xs[j] + d == xs[k] && ys[k] + Math.min(answer[k], d) > ys[j]) {
                            answer[j] = Math.min(answer[j], d);
                        } 
                        // simply the other way around
                        // if y's intersect, and x's don't intersect before y does:
                        // mark answer of North cow as earliest possible value
                        else if (ys[k] + d == ys[j] && xs[j] + Math.min(answer[j], d) > xs[k]) {
                            answer[k] = Math.min(answer[k], d);
                        }
                    }
                }
            }
        }
        // this works because it compares all east cows the amount of times of the west cows
        // same thing with west cows against east cows because they compare at the same time

        // print answers in order
        for (int j = 0; j < n; j++) {
            System.out.println(answer[j] == Integer.MAX_VALUE ? "Infinity" : answer[j]);
        }

        in.close();
    }
}