package leet.sudokusolver;

import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int boxId(int row, int col) {
        int colVal = (int)Math.floor(col/3);
        int rowVal = (int)Math.floor(row/3)*3;
        return colVal+rowVal;
    }
    public void solveSudoku(char[][] board) {
        final int n = board.length;
        final ArrayList<HashMap<Character,Boolean>> boxes = new ArrayList<>();
        final ArrayList<HashMap<Character,Boolean>> rows = new ArrayList<>();
        final ArrayList<HashMap<Character,Boolean>> cols = new ArrayList<>();
        for (int i = 0; i< n; i++ ){
            boxes.add(i,new HashMap<>());
            rows.add(i, new HashMap<>());
            cols.add(i, new HashMap<>());
        }
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] != '.') {
                    rows.get(r).put(board[r][c], true);
                    cols.get(c).put(board[r][c], true);
                    boxes.get(boxId(r,c)).put(board[r][c], true);
                }
            }
        }
        System.out.println(boxes);
        System.out.println(rows);
        System.out.println(cols);
        solveBackTrack(board,boxes,rows,cols, 0,0);

    }

    private static char[] chars = {'1','2','3','4','5','6','7','8','9'};
    private boolean solveBackTrack(char[][] board,
                                ArrayList<HashMap<Character, Boolean>> boxes,
                                ArrayList<HashMap<Character, Boolean>> rows,
                                ArrayList<HashMap<Character, Boolean>> cols, int row, int col) {
        if (row==board.length || col==board[0].length) {
            return true;
        }else {
            if (board[row][col] =='.') {
                for (int i = 0; i < 9; i++) {
                    // add element
                    board[row][col] = chars[i];
                    if (isValid(board, boxes, rows, cols, row, col)) {
                        rows.get(row).put(board[row][col], true);
                        cols.get(col).put(board[row][col], true);
                        boxes.get(boxId(row, col)).put(board[row][col], true);
                        if ((col == board[0].length - 1)) {
                            if (solveBackTrack(board, boxes, rows, cols, row + 1, 0)) {
                                return true;
                            }
                        }
                        else {
                            if(solveBackTrack(board, boxes, rows, cols, row, col+1)){
                                return true;
                            }
                        }
                        // remove element
                        rows.get(row).put(board[row][col], false);
                        cols.get(col).put(board[row][col], false);
                        boxes.get(boxId(row, col)).put(board[row][col], false);
                    }
                    board[row][col] = '.';
                }
            } else {
                if ((col == board[0].length - 1)) {
                    if (solveBackTrack(board, boxes, rows, cols, row + 1, 0)) {
                        return true;
                    }
                }
                else {
                    if(solveBackTrack(board, boxes, rows, cols, row, col+1)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean isValid(char[][] board, ArrayList<HashMap<Character, Boolean>> boxes, ArrayList<HashMap<Character, Boolean>> rows, ArrayList<HashMap<Character, Boolean>> cols, int row, int col) {
        char item = board[row][col];
        int boxId = boxId(row,col);
        return !( (boxes.get(boxId) != null && boxes.get(boxId).get(item) != null && boxes.get(boxId).get(item))
                || (cols.get(col) != null && cols.get(col).get(item)!= null && cols.get(col).get(item))
                || (rows.get(row) != null && rows.get(row).get(item) != null && rows.get(row).get(item)));

    }
}

public class Backtracking {
    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},
                          {'6','.','.','1','9','5','.','.','.'},
                          {'.','9','8','.','.','.','.','6','.'},
                          {'8','.','.','.','6','.','.','.','3'},
                          {'4','.','.','8','.','3','.','.','1'},
                          {'7','.','.','.','2','.','.','.','6'},
                          {'.','6','.','.','.','.','2','8','.'},
                          {'.','.','.','4','1','9','.','.','5'},
                          {'.','.','.','.','8','.','.','7','9'}};
        Solution sol = new
                Solution();
        sol.solveSudoku(board);
//        System.out.println(sol.boxId(3,3));
        System.out.println();
        int n = board.length;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }
    }
}
