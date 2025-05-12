package week03.problems.numIsland;

class Solution {
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int rowLen;
    static int colLen;

    public int numIslands(char[][] grid) {
        rowLen = grid.length;
        colLen = grid[0].length;
        visited = new boolean[rowLen][colLen];
        int num = 0;

        // 네트워크의 수 구하기 => dfs
        for(int i=0; i<rowLen; i++) {
            for(int j=0; j<colLen; j++){
                if(grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, i, j);
                    num++;
                }
            }
        }
        return num;
    }

    public void dfs(char[][] grid, int row, int col){
        visited[row][col] = true;
        for(int d = 0; d < 4 ; d++) {
            int nx = row + dx[d];
            int ny = col + dy[d];

            if((0<=nx && nx<rowLen) && (0<=ny && ny<colLen)) {
                if(!visited[nx][ny] && grid[nx][ny] == '1'){
                    dfs(grid, nx, ny);
                }
            }
        }
    }
}