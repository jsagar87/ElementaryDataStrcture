package leet.tw2darray;

class Solution {
    public void dfs(char[][] grid,Integer[][] seenAndGroup,int row,int col,int currentcount) {
        int[][] directions = {{0,-1},{1,0},{0,1},{-1,0}};
        int nrow = grid.length;
        int ncol = grid[0].length;

        if (row < 0 || row >= nrow || col < 0 || col >= ncol || grid[row][col] == '0' || seenAndGroup[row][col] != -1) {
            return;
        }
        seenAndGroup[row][col] = currentcount;
        for (int i=0; i<directions.length; i++) {
            dfs(grid,seenAndGroup,row+directions[i][0],col+directions[i][1],currentcount);
        }
    }

    public int numIslands(char[][] grid) {
        int nrow = grid.length;
        if (nrow <= 0) return 0;
        int ncol = grid[0].length;
        if (ncol <= 0) return 0;

        int islandCount = 0;

        Integer[][] seenAndGroup = new Integer[nrow][ncol];
        for (int i = 0; i < nrow; i++) {
            for (int j = 0; j < ncol; j++) {
                seenAndGroup[i][j] = -1;
            }
        }

        for (int i = 0; i < nrow; i++) {
            for (int j = 0; j < ncol; j++) {
                if (seenAndGroup[i][j] == -1 && grid[i][j] != '0') {
                    dfs (grid,seenAndGroup,i,j,islandCount++);
                }
            }
        }
        return islandCount;
    }
}
public class NumberOfIsolatedIsland {
    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        Solution sol = new Solution();
        System.out.println(sol.numIslands(grid));
        
        char[][] grid2 = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        System.out.println(sol.numIslands(grid2));
    }
}
