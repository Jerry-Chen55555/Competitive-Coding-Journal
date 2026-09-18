// THIS SOLUTION IS SLOW
// Correct solution doesn't use BFS at all
// Search alg for a room x:
// 1. if visited don't process
// 2. turn on all switches corresponding with x
// 3. if it has a visited neighbor search it can be searched
// 4. if x has any neighbors itself (it created a bridge) search their neighbors as well

// Basically the solution accounts for 2 cases of the rooms
// The room switched on a room that was adjacent to a visited room
// The room created a bridge from the visited rooms to non-visited rooms


import java.util.*;
import java.io.*;

public class lightson {
    static void searchUnused() {
        LinkedList<Room> l = new LinkedList<>();
        boolean[][] bfsused = new boolean[n][n];
        l.add(new Room(0, 0));

        while (l.size() >= 1) {
            Room currRoom = l.removeFirst();
            
            for (int j = 0; j < directions.length; j++) {
                Room newRoom = new Room(currRoom.x + directions[j][0], currRoom.y + directions[j][1]);
                if (isInBounds(newRoom) && lights[newRoom.x][newRoom.y] && !bfsused[newRoom.x][newRoom.y]) {
                    l.addFirst(newRoom);
                    if (!used[newRoom.x][newRoom.y]) {
                        roomsToSearch.add(newRoom);
                    }
                    bfsused[newRoom.x][newRoom.y] = true;
                }
                
            }
        }
    }

    static boolean isInBounds(Room r) {
        return r.x >= 0 && r.x < n && r.y >= 0 && r.y < n;
    }
    static boolean[][] used;
    static boolean[][] lights;
    static int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    static int n;
    static ArrayList<Room> roomsToSearch = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new FileReader("lightson.in"));
        PrintWriter pw = new PrintWriter("lightson.out");

        HashMap<Room, ArrayList<Room>> switches = new HashMap<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        used = new boolean[n][n];
        lights = new boolean[n][n];
        

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int[] x = new int[4];
            for (int j = 0; j < x.length; j++) 
                x[j] = Integer.parseInt(st.nextToken()) - 1;
            
            ArrayList<Room> a = switches.getOrDefault(new Room(x[0], x[1]), new ArrayList<Room>());
            a.add(new Room(x[2], x[3]));
            switches.put(new Room(x[0], x[1]), a);
        }

        int result = 1;
        roomsToSearch.add(new Room(0, 0));
        lights[0][0] = true;
        while (roomsToSearch.size() > 0) {
            Room currRoom = roomsToSearch.remove(roomsToSearch.size() - 1);
            used[currRoom.x][currRoom.y] = true;
            for (Room z : switches.getOrDefault(currRoom, new ArrayList<Room>())) {
                if (lights[z.x][z.y] == false) {
                    result++;
                    lights[z.x][z.y] = true;
                    if (Math.abs(z.x - currRoom.x) + Math.abs(z.y - currRoom.y)<= 1 && !used[z.x][z.y]) {
                        roomsToSearch.add(new Room(z.x, z.y));
                    }
                }
            }

            if (roomsToSearch.size() == 0) {
                searchUnused();
            }
            
            // for (boolean[] bs : lights) {
            //     System.out.println(Arrays.toString(bs));
            // }
            // System.out.println("--------------");
            
        }


        
        pw.println(result);
        pw.close();
        br.close();
    }
}

class Room {
    int x, y;

    public Room(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Room)) return false;
        Room r = (Room) o;
        return this.x == r.x && this.y == r.y;
    }

    public int hashCode() {
        return Objects.hash(x, y);
    }


    public String toString() {
        return "Room: " + x + " " + y;
    }
}