/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3
*/
public class Solution {
    //union-find
    ///////////////////////////////////////////////////////////////////////////////////////////////////
    /**
    * Created by shaobo on 2016/4/15.
    */
    public class Solution {
        public int numIslands(char[][] grid) {
            if(grid.length==0||grid[0].length==0)return 0;
            int m = grid.length, n = grid[0].length;
            UF uf = new UF(m, n, grid);

            for(int i = 0; i<m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (grid[i][j] == '0') continue;
                    int p = i * n + j;
                    int q;
                    if (i > 0 && grid[i - 1][j] == '1') {
                        q = p - n;
                        uf.union(p, q);
                    }
                    if (i < m - 1 && grid[i + 1][j] == '1') {
                        q = p + n;
                        uf.union(p, q);
                    }
                    if (j > 0 && grid[i][j - 1] == '1') {
                        q = p - 1;
                        uf.union(p, q);
                    }
                    if (j < n - 1 && grid[i][j + 1] == '1') {
                        q = p + 1;
                        uf.union(p, q);
                    }
                }
            }

            return uf.count;
        }
    }

    class UF {
        public int count = 0;
        public int[] father = null;

        public UF(int m, int n, char[][] grid) {
            for(int i = 0; i < m; ++i) {
                for(int j = 0; j < n; ++j) {
                    if(grid[i][j] == '1') ++count;
                }
            }
            father = new int[m * n];
            for(int i = 0; i < m * n; ++i) {
                father[i] = i;
            }
        }

        public int find(int p) {
            while(p != father[p]) {
                father[p] = father[father[p]];
                p = father[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if(pRoot == qRoot) return;
            father[pRoot] = qRoot;
            --count;
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////
    //dfs
    private int row;
    private int col;
    
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        
        int islands = 0;
        row = grid.length;
        col = grid[0].length;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++)
                if (grid[i][j] == '1') {
                    DFSMarking(grid, i, j);
                    ++islands;
                }
        }    
        return islands;
    }
    
    private void DFSMarking(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= row || j >= col || grid[i][j] != '1') return;
        grid[i][j] = '0';
        DFSMarking(grid, i + 1, j);
        DFSMarking(grid, i - 1, j);
        DFSMarking(grid, i, j + 1);
        DFSMarking(grid, i, j - 1);
    }
    
    //bfs by myself
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int islands = 0;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if ((grid[i][j] == '1') && !visited[i][j]) {
                    ++islands;
                    bfs(grid, visited, i, j);
                }
            }
        }
        return islands;
    }

    private void bfs(char[][] grid, boolean[][] visited, int row, int col) {
        Queue<PointIsland> points = new LinkedList<PointIsland>();
        visited[row][col] = true;
        points.offer(new PointIsland(row, col));

        while (!points.isEmpty()) {
            PointIsland point = points.poll();
            int i = point.row;
            int j = point.col;
            if (i > 0 && grid[i-1][j] == '1' && !visited[i-1][j]) {
                visited[i-1][j] = true;
                points.offer(new PointIsland(i-1, j));
            }
            if (j > 0 && grid[i][j-1] == '1' && !visited[i][j-1]) {
                visited[i][j-1] = true;
                points.offer(new PointIsland(i, j-1));
            }
            if (i < grid.length-1 && grid[i+1][j] == '1' && !visited[i+1][j]) {
                visited[i+1][j] = true;
                points.offer(new PointIsland(i+1, j));
            }
            if (j < grid[0].length-1 && grid[i][j+1] == '1' && !visited[i][j+1]) {
                visited[i][j+1] = true;
                points.offer(new PointIsland(i, j+1));
            }
        }
    }

    public class PointIsland {
        int row;
        int col;
        public PointIsland(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    
    //dfs by myself
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int islands = 0;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if ((grid[i][j] == '1') && (visited[i][j] == false)) {
                    ++islands;
                    dfs(grid, visited, i, j);
                }
            }
        }
        return islands;
    }

    private void dfs(char[][] grid, boolean[][] visited, int row, int col) {
        Stack<PointIsland> points = new Stack<PointIsland>();
        points.push(new PointIsland(row, col));

        while (!points.isEmpty()) {
            PointIsland point = points.pop();
            int i = point.row;
            int j = point.col;
            visited[i][j] = true;
            if (i > 0 && grid[i-1][j] == '1' && !visited[i-1][j]
                    && !points.contains(new PointIsland(i-1, j))) {
                points.push(new PointIsland(i-1, j));
            }
            if (j > 0 && grid[i][j-1] == '1' && !visited[i][j-1]
                    && !points.contains(new PointIsland(i, j-1))) {
                points.push(new PointIsland(i, j-1));
            }
            if (i < grid.length-1 && grid[i+1][j] == '1' && !visited[i+1][j]
                    && !points.contains(new PointIsland(i+1, j))) {
                points.push(new PointIsland(i+1, j));
            }
            if (j < grid[0].length-1 && grid[i][j+1] == '1' && !visited[i][j+1]
                    && !points.contains(new PointIsland(i, j+1))) {
                points.push(new PointIsland(i, j+1));
            }
        }
    }

    public class PointIsland {
        int row;
        int col;
        public PointIsland(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}