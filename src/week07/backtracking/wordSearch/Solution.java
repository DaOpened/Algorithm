package week07.backtracking.wordSearch;

// https://leetcode.com/problems/word-search/description/
class Solution {
    boolean ans;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    public boolean exist(char[][] board, String word) {
        ans = false;
        int rows = board.length;
        int cols = board[0].length;

        char[] wordArr = word.toCharArray();

        for(int i = 0 ; i < rows; i++) {
            for(int j = 0 ; j < cols; j++) {
                if(board[i][j] == wordArr[0]) {
                    boolean[][] visited = new boolean[rows][cols];
                    visited[i][j] = true;
                    dfs(board, visited, wordArr, 1, i, j);
                    if(ans)
                        return true;
                }
            }
        }
        return ans;
    }

    public void dfs(char[][] board, boolean[][] visited, char[] wordArr, int curLen, int x, int y) {

        if(ans) {
            return;
        }

        if(curLen == wordArr.length) {
            ans = true;
            return;
        }

        int rows = board.length;
        int cols = board[0].length;

        for(int i = 0 ; i < 4 ; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(0<=nx && nx < rows && 0<=ny && ny < cols) {
                if(!visited[nx][ny] && board[nx][ny] == wordArr[curLen]) {
                    visited[nx][ny] = true;
                    dfs(board, visited, wordArr, curLen+1, nx, ny);
                    visited[nx][ny] = false;
                }
            }
        }

    }
}