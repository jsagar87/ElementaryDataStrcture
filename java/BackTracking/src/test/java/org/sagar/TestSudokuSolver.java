package org.sagar;

import org.junit.Assert;
import org.junit.Test;

public class TestSudokuSolver {

    @Test
    public void testSolveSudoku () {
        SudokuSolver solve = new SudokuSolver();
        char[][] board = new char[][]{{'.', '.'}, {'.', '.'}};
//        int actual = solve.solveSudoku(board);
//        Assert.assertEquals(4,actual);
    }
}
