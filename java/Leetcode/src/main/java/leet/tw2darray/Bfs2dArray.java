package leet.tw2darray;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Bfs2dArray {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}};

        // Initialize boolean matrix for traversal tracking
        Boolean[][] seen = new Boolean[matrix.length][matrix[0].length];
        for (int i = 0; i< matrix.length; i++)
            for (int j = 0; j< matrix[0].length; j++)
                seen[i][j] = false;

        List<Integer> values = new ArrayList<>();
        BFS(matrix, seen, values);
        System.out.println(values);
    }

    private static void BFS(int[][] matrix, Boolean[][] seen, List<Integer> values) {
        int[] up = {-1, 0};int[] right = {0, +1};int[] down = {+1, 0};int[] left = {0, -1};
        int[][] directions = {up, right, down, left};
        int row_min = 0, row_max = matrix.length - 1, col_min = 0, col_max = matrix[0].length - 1;
        Queue<int[]> cords = new ArrayDeque<>();
            cords.add(new int[]{0,0});
        while (!cords.isEmpty()) {
            int[] cord = cords.poll();
            int row = cord[0],col = cord[1];

            if (row < row_min || row > row_max || col < col_min || col > col_max || seen[row][col]) {
                continue;
            }
            values.add(matrix[row][col]);
            seen[row][col] = true;

            for (int i = 0; i < directions.length; i++) {
                cords.add(new int[]{row+directions[i][0],col+directions[i][1]});
            }
        }
    }
}
