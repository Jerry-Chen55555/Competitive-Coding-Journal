package Day12;

import java.io.*;
import java.util.*;

public class solution {
    public static boolean isValidPos(int y, int x, String[] s) {
        return (y >= 0 && y < s.length && x >= 0 && x < s[0].length());
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("Day12/input.txt"));

        int size = 140;
        String[] input = new String[size];
        long res = 0;

        for (int i = 0; i < size; i++) {
            input[i] = br.readLine();
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (input[i].charAt(j) != '.') {
                    ArrayList<Tuple<Integer, Integer>> region = new ArrayList<>(Arrays.asList(new Tuple<>(j, i)));
                    List<ArrayList<Tuple<Integer, Integer>>> fences = Arrays.asList(
                            new ArrayList<Tuple<Integer, Integer>>(), new ArrayList<Tuple<Integer, Integer>>(),
                            new ArrayList<Tuple<Integer, Integer>>(), new ArrayList<Tuple<Integer, Integer>>());
                    int numFences = 0;
                    char currChar = input[i].charAt(j);
                    for (int k2 = 0; k2 < 4; k2++) {
                        int newX = 0, newY = 0;
                        if (k2 == 0) {
                            newY = 1;
                        } else if (k2 == 1) {
                            newY = -1;
                        } else if (k2 == 2) {
                            newX = 1;
                        } else {
                            newX = -1;
                        }
                        if (!(isValidPos(i + newY, j + newX, input) &&
                                input[i + newY].charAt(j + newX) == currChar)) {
                            fences.get(k2).add(new Tuple<>(j + newX, i + newY));
                        }
                    }
                    while (true) {
                        ArrayList<Tuple<Integer, Integer>> add = new ArrayList<>();
                        for (int k = 0; k < region.size(); k++) {
                            for (int k2 = 0; k2 < 4; k2++) {
                                int newX = 0, newY = 0;
                                if (k2 == 0) {
                                    newY = 1;
                                } else if (k2 == 1) {
                                    newY = -1;
                                } else if (k2 == 2) {
                                    newX = 1;
                                } else {
                                    newX = -1;
                                }
                                boolean isAlreadyIn = false;
                                for (int l = 0; l < region.size(); l++) {
                                    if (region.get(k).y + newY == region.get(l).y
                                            && region.get(k).x + newX == region.get(l).x) {
                                        isAlreadyIn = true;
                                        break;
                                    }
                                }
                                for (int l = 0; l < add.size(); l++) {
                                    if (region.get(k).y + newY == add.get(l).y
                                            && region.get(k).x + newX == add.get(l).x) {
                                        isAlreadyIn = true;
                                        break;
                                    }
                                }
                                if (!isAlreadyIn) {
                                    if (isValidPos(region.get(k).y + newY, region.get(k).x + newX, input) &&
                                            input[region.get(k).y + newY].charAt(region.get(k).x + newX) == currChar) {
                                        add.add(new Tuple<>(region.get(k).x + newX, region.get(k).y + newY));
                                    }
                                }
                            }
                        }

                        for (int k = 0; k < add.size(); k++) {
                            for (int k2 = 0; k2 < 4; k2++) {
                                int newX = 0, newY = 0;
                                if (k2 == 0) {
                                    newY = 1;
                                } else if (k2 == 1) {
                                    newY = -1;
                                } else if (k2 == 2) {
                                    newX = 1;
                                } else {
                                    newX = -1;
                                }
                                if (!(isValidPos(add.get(k).y + newY, add.get(k).x + newX, input) &&
                                        input[add.get(k).y + newY].charAt(add.get(k).x + newX) == currChar)) {
                                    fences.get(k2).add(new Tuple<>(add.get(k).x + newX, add.get(k).y + newY));
                                }
                            }
                        }
                        if (add.size() == 0) {
                            break;
                        } else {
                            for (int k = 0; k < add.size(); k++) {
                                region.add(add.get(k));
                            }
                        }
                    }
                    
                    for (int k = 0; k < 4; k++) {
                        System.out.println(fences.get(k));
                        while (fences.get(k).size() != 0) {
                            int x = fences.get(k).get(0).x;
                            int x2 = fences.get(k).get(0).x;
                            int y = fences.get(k).get(0).y;
                            int y2 = fences.get(k).get(0).y;
                            fences.get(k).remove(0);
                            while (x != -8 || x2 != -8) {
                                if (k < 2) {
                                    if (x != -8) {x++;}
                                    if (x2 != -8) {x2--;}
                                } else {
                                    if (y != -8) {y++;}
                                    if (y2 != -8) {y2--;}
                                }
                                boolean isIn = false;
                                int l;
                                for (l = 0; l < fences.get(k).size(); l++) {
                                    if (fences.get(k).get(l).x == x
                                            && fences.get(k).get(l).y == y) {
                                        isIn = true;
                                        break;
                                    }
                                }
                                if (isIn) {
                                    fences.get(k).remove(l);
                                } else {
                                    x = -8;
                                    y = -8;
                                }
                                isIn = false;
                                for (l = 0; l < fences.get(k).size(); l++) {
                                    if (fences.get(k).get(l).x == x2
                                            && fences.get(k).get(l).y == y2) {
                                        isIn = true;
                                        break;
                                    }
                                }
                                if (isIn) {
                                    fences.get(k).remove(l);
                                } else {
                                    x2 = -8;
                                    y2 = -8;
                                }
                            }
                            System.out.println(fences.get(k));
                            numFences++;
                        }
                    }
                    System.out.println(i + " " + j + " " + numFences + " " + region.size() + " " + currChar);

                    res += numFences * region.size();
                    for (int k = 0; k < region.size(); k++) {
                        input[region.get(k).y] = input[region.get(k).y].substring(0, region.get(k).x) + '.'
                                + input[region.get(k).y].substring(region.get(k).x + 1);
                    }
                }
            }
        }

        System.out.println(res);
        br.close();
    }
}

class Tuple<X, Y> {
    public final X x;
    public final Y y;

    public Tuple(X x, Y y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "(" + x +", " + y + ")";
    }
}