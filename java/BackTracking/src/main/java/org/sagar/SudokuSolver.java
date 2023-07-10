package org.sagar;

import java.util.HashMap;
import java.util.Map;

public class SudokuSolver {

    public int getBoxId(int col, int row) {
        final int col_num = (int) Math.floor(col/3);
        final int row_num = ((int) Math.floor(row/3)) * 3;

        return col_num + row_num;
    }
    public void solveSudoku(char[][] board) {
        int r = board.length;
        int c = board[0].length;
        int n = board.length;
        Map<Character, Boolean>[] boxes = new HashMap[n];
        Map<Character, Boolean>[] rows = new HashMap[n];
        Map<Character, Boolean>[] cols = new HashMap[n];

        // Initialize datastructures
        for (int row = 0; row<r; row++) {
            for (int col = 0; col<c; col++) {
                if (board[row][col] != '.') {
                    char val = board[row][col];
                    int boxId = getBoxId(col, row);
                    boxes[boxId].put(val,true);
                    cols[col].put(val, true);
                    rows[row].put(val, true);
                }
            }
        }

        // backtrack
        backtrackSolveSudoku(board, boxes, rows, cols, 0, 0);

    }

    private boolean isValid(Map<Character, Boolean> box,
                            Map<Character, Boolean> col,
                            Map<Character, Boolean> row,
                            char val) {
        boolean hasBoxVal = box.get(val) != null ? box.get(val) : false;
        boolean hasColVal = col.get(val) != null ? col.get(val) : false;
        boolean hasRowVal = row.get(val) != null ? row.get(val) : false;

        return !(hasBoxVal || hasColVal || hasRowVal);
    }

    private boolean backtrackSolveSudoku(char[][] board,
                                      final Map<Character, Boolean>[] boxes,
                                      final Map<Character, Boolean>[] rows,
                                      final Map<Character, Boolean>[] cols,
                                      int r, int c) {
        if (board.length == r || board[0].length == c) {
            return true;
        } else {
            if (board[r][c] == '.') {
                // Add
                for (int num = 1; num <=9; num++) {
                    char numVal = (char) num;
                    board[r][c] = numVal ;
                    // is valid
                    final int boxId = getBoxId(c,r);
                    final Map box = boxes[boxId];
                    final Map col = cols[c];
                    final Map row = rows[r];
                    if (isValid(box,col,row,numVal)) {
                        boxes[boxId].put(numVal, true);
                        cols[c].put(numVal, true);
                        rows[c].put(numVal, true);
                        if (c == board[0].length-1) {
                            if (backtrackSolveSudoku(board,boxes,rows,cols,r++,0))
                                return true;
                        } else {
                            if (backtrackSolveSudoku(board, boxes, rows, cols, 0, c++))
                                return true;
                        }
                        boxes[boxId].remove(numVal);
                        cols[c].remove(numVal);
                        rows[r].remove(numVal);
                    }
                    board[r][c] = '.' ;
                }
            } else {
                if (c == board[0].length-1) {
                    if (backtrackSolveSudoku(board,boxes,rows,cols,r++,0))
                        return true;
                } else {
                    if (backtrackSolveSudoku(board, boxes, rows, cols, 0, c++))
                        return true;
                }
            }
        }
        return false;
    }
}
