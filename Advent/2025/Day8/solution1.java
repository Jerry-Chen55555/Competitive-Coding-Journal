package Day8;

import java.io.*;
import java.util.*;

public class solution1 {
    static long squareDistance(point a, point b) {
        return (long) (Math.pow(a.a - b.a, 2) +  Math.pow(a.b - b.b, 2) + Math.pow(a.c - b.c, 2));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Day8/actual.txt"));

        point[] points = new point[1000];

        ArrayList<pointPair> pairs = new ArrayList<>();

        for (int i = 0; i < points.length; i++) {
            String[] coordStrings = br.readLine().split(",");
            long[] coords = new long[3];
            for (int j = 0; j < coordStrings.length; j++) {
                coords[j] = Long.parseLong(coordStrings[j]);
            }
            points[i] = new point(coords[0], coords[1], coords[2]);
        }

        for (int i = 0; i < points.length; i++) {
            for (int j = i; j < points.length; j++) {
                if (i != j) {
                    pairs.add(new pointPair(points[i], points[j], squareDistance(points[i], points[j])));
                }
            }
        }

        Collections.sort(pairs);

        // for (int i = 0; i < 10; i++) {
        //     System.out.println(pairs.get(i));
        // }

        ArrayList<ArrayList<point>> circuits = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            circuits.add(new ArrayList<>(Arrays.asList(points[i])));
        }
        for (int i = 0; i < 1000; i++) {
            int aGroup = 0, bGroup = 0;

            for (int j = 0; j < circuits.size(); j++) {
                if (circuits.get(j).contains(pairs.get(i).a)) {
                    aGroup = j;
                }
                if (circuits.get(j).contains(pairs.get(i).b)) {
                    bGroup = j;
                }
            }

            if (aGroup == bGroup) {
                continue;
            }

            circuits.get(aGroup).addAll(circuits.get(bGroup));
            circuits.set(bGroup, new ArrayList<>());

            // for (ArrayList<point> ps : circuits) {
            //     System.out.println(ps);
            // }
            // System.out.println("-------------");
        }

        ArrayList<Long> circuitSizes = new ArrayList<>();
        for (ArrayList<point> ps : circuits) {
            circuitSizes.add((long)ps.size());
        }

        Collections.sort(circuitSizes);
        Collections.reverse(circuitSizes);

        System.out.println(circuitSizes.get(0) * circuitSizes.get(1) * circuitSizes.get(2));

        br.close();
    }
}

class pointPair implements Comparable<pointPair> {
    point a, b;
    long distance;

    public pointPair(point a, point b, long distance) {
        this.a = a;
        this.b = b;
        this.distance = distance;
    }
    @Override
    public int compareTo(pointPair o) {
        if (distance < o.distance) {
            return -1;
        }
        if (distance == o.distance) {
            return 0;
        }
        return 1;
    }

    public String toString() {
        return "(distance: " + distance + "; points: " + a + ", " + b + ")";
    }
}

class point {
    long a, b, c;
    
    public point(long a, long b, long c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public boolean equals(Object o) {
        if (!(o instanceof point)) return false;
        point other = (point) o;
        return a == other.a && b == other.b && c == other.c;
    }

    public String toString() {
        return "(" + a + ", " + b + ", " + c + ")";
    }
}

// 96672