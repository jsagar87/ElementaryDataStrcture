package leet.tw2darray;

public class Dfs2dArray {


    public static void printmatrix(Object[][] matrix) {
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void traversalDFS(int[][] matrix) {
        int[] values = new int[matrix.length * matrix[0].length];
        Boolean seen[][] = new Boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < seen.length; i++){
            for (int j = 0; j < seen[0].length; j++) {
                seen[i][j] = false;
            }
        }
        printmatrix(seen);
        dfs(matrix, seen, 0, 0, values);
        printmatrix(seen);

        // Printing output
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + " ");
        }
    }


    static int crr_idx = 0;
    static int[] left = {0, -1};
    static int[] right = {0, +1};
    static int[] up = {-1, 0};
    static int[] down = {+1, 0};
    static int[][] directions = {up, right, down, left};

    private static void dfs(int[][] matrix, Boolean[][] seen, int row, int col, int[] values) {
        int row_min = 0, row_max = matrix.length - 1, col_min = 0, col_max = matrix[0].length - 1;
        if (row < row_min || row > row_max || col < col_min || col > col_max || seen[row][col]) {
            return;
        }
        values[crr_idx++] = matrix[row][col];
        seen[row][col] = true;

        for (int i = 0; i < directions.length; i++) {
            dfs(matrix,seen,row+directions[i][0],col+directions[i][1],values);
        }
    }

    public static void main(String[] args) {

        int[][] matrix = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}};

        traversalDFS(matrix);
    }
}
