import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
8 8
.######.
#..o...#
#.####.#
#.#v.#.#
#.#.o#o#
#o.##..#
#.v..v.#
.######.
*/
public class Main {
    static char[][] map;
    static int[][] visited;
    
    static int[] x_move = {0, -1, 0, 1};
    static int[] y_move = {-1, 0, 1, 0};
    
    static int r;
    static int c;
    
    static int sheepCount;
    static int wolfCount;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // StringBuilder sb = new StringBuilder();
        // int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        map = new char[r][c];
        visited = new int[r][c];
        
        for(int i = 0; i < r; i++) {
            String temp = br.readLine();
            
            for(int j = 0; j < c; j++) {
                map[i][j] = temp.charAt(j);
            }
        }
        
        bfs();
    }
    
    static void bfs() {
        Queue<Pair> queue = new LinkedList<Pair>();
        
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(visited[i][j] == 0 && (map[i][j] == 'v' || map[i][j] == 'k')) { //한 영역에 들어갔다는뜻
                    queue.add(new Pair(i, j));
                    visited[i][j] = 1;

                    int landSheepCount = 0;
                    int landWolfCount = 0;
                    
                    if(map[i][j] == 'v') landWolfCount++;
                    if(map[i][j] == 'k') landSheepCount++;
                    
                    while(!queue.isEmpty()) {
                        Pair pair = queue.poll();
                        
                        int px = pair.x;
                        int py = pair.y;
                        
                        for(int k = 0; k < 4; k++) {
                            int x = px + x_move[k];
                            int y = py + y_move[k];
                            
                            if(x >= 0 && y >= 0 && x < r && y < c) {
                                if(visited[x][y] == 0 && map[x][y] != '#') {
                                  visited[x][y] = 1;
                                  queue.add(new Pair(x, y));
                                  
                                  if(map[x][y] == 'v') landWolfCount++;
                                  if(map[x][y] == 'k') landSheepCount++;
                                  
                                }
                            }
                        }
                    }

                    if(landSheepCount > landWolfCount) {
                      sheepCount = sheepCount + landSheepCount;
                    }else {
                      wolfCount = wolfCount + landWolfCount;
                    }
                }
            }
        }
   
        System.out.println(sheepCount + " " + wolfCount);
    }
}

class Pair{
    int x;
    int y;
    
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}