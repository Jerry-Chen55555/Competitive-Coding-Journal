import java.io.*;
import java.util.*;

public class clash {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        String[] nhStrings = br.readLine().split(" ");
        int n = Integer.parseInt(nhStrings[0]);
        int h = Integer.parseInt(nhStrings[1]);

        int[] ci = new int[n];
        String[] ciStrings = br.readLine().split(" ");
        for (int i = 0; i < ciStrings.length; i++) {
            ci[i] = Integer.parseInt(ciStrings[i]);
        }
        int k = Integer.parseInt(br.readLine());
        int[] si = new int[k];
        String[] siStrings = br.readLine().split(" ");
        for (int i = 0; i < siStrings.length; i++) {
            si[i] = Integer.parseInt(siStrings[i]);
            ci[si[i]-1] = -100 + ci[si[i]-1];
        }

        PriorityQueue<Integer> hand = new PriorityQueue<>();
        Queue<Integer> draw = new LinkedList<>();
        for (int i = 0; i < h; i++) {
            hand.add(ci[i]);
        }
        for (int i = h; i < n; i++) {
            draw.add(ci[i]);
        }

        int firstCard = hand.peek();
        int currCard = 0;
        long currW = 0;
        long currT = 0;
        ArrayList<Long> firstTs = new ArrayList<>();
        ArrayList<Long> firstWs = new ArrayList<>();
        firstTs.add(0L);
        firstWs.add(0L);

        currCard = hand.poll();
        if (currCard < 0) {
            currW++;
            currT += 100 + currCard;
            firstTs.add(currT);
            firstWs.add(currW);
        } else {
            currT += currCard;
        }
        hand.add(draw.remove());
        draw.add(currCard);

        while (firstCard != hand.peek()) {
            currCard = hand.poll();
            if (currCard < 0) {
                currW++;
                currT += 100 + currCard;
                firstTs.add(currT);
                firstWs.add(currW);
            } else {
                currT += currCard;
            }
            hand.add(draw.remove());
            draw.add(currCard);
        }
        firstTs.add(currT);
        firstWs.add(currW);

        firstCard = hand.peek();
        currCard = 0;
        currW = 0;
        currT = 0;
        ArrayList<Long> secondTs = new ArrayList<>();
        ArrayList<Long> secondWs = new ArrayList<>();
        secondTs.add(0L);
        secondWs.add(0L);

        currCard = hand.poll();
        if (currCard < 0) {
            currW++;
            currT += 100 + currCard;
            secondTs.add(currT);
            secondWs.add(currW);
        } else {
            currT += currCard;
        }
        hand.add(draw.remove());
        draw.add(currCard);
        currCard = hand.peek();

        while (firstCard != hand.peek()) {
            currCard = hand.poll();
            if (currCard < 0) {
                currW++;
                currT += 100 + currCard;
                secondTs.add(currT);
                secondWs.add(currW);
            } else {
                currT += currCard;
            }
            hand.add(draw.remove());
            draw.add(currCard);
        }
        secondTs.add(currT);
        secondWs.add(currW);

        int q = Integer.parseInt(br.readLine());
        // pw.println(firstTs);
        // pw.println(firstWs);
        // pw.println(secondTs);
        // pw.println(secondWs);

        for (int i = 0; i < q; i++) {
            long t = Long.parseLong(br.readLine());
            long total = 0;
            int index = Collections.binarySearch(firstTs, t);
            if (index < 0) {index = -(index+1) - 1;}
            total += firstWs.get(index);
            if (t > firstTs.get(firstTs.size()-1)) {
                t -= firstTs.get(index);
                total += (t / secondTs.get(secondTs.size()-1)) * secondWs.get(secondWs.size()-1);
                t -= (t / secondTs.get(secondTs.size()-1)) * secondTs.get(secondTs.size()-1);
                index = Collections.binarySearch(secondTs, t);
                if (index < 0) {index = -(index+1) - 1;}
                total += secondWs.get(index);
            }
            pw.println(total);
        }

        pw.close();
        br.close();
    }
}
