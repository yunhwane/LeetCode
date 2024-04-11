https://www.acmicpc.net/problem/7576


1번째 푼 날짜 : 240411 - 동시 탐색 생각 못함

```java
import java.util.*;
import java.lang.*;
import java.io.*;
// The main method must be in a class named "Main".
class Main {

    static int n, m;
    static int[][] arr;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int day;
    static Queue<Pair> qu = new LinkedList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        qu = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) {
                    qu.offer(new Pair(i,j));
                }
            }
        }
        bfs();
        
        int maxDay = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                maxDay = Math.max(maxDay, arr[i][j]);
            }
        }
        System.out.println(maxDay - 1); 
    }
    static void bfs() {
        while (!qu.isEmpty()) {
            Pair p = qu.poll();

            for (int k = 0; k < 4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && arr[nx][ny] == 0) {
                    arr[nx][ny] = arr[p.x][p.y] + 1;
                    qu.offer(new Pair(nx, ny));
                }
            }
        }
    }
}
class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
```
