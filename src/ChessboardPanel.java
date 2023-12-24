public class ChessboardPanel  {

    public boolean[][] board = new boolean[8][8];

    public ChessboardPanel(boolean[][] board) {
        board = new boolean[8][8];
    }
   // ok does ur answer come in the form of a matrix?
    // if the answer comes in the form of matrix we can set it equal to the printCommand
    public void initializeBoard() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                board[row][col] = false;
            }
        }
    }


   // there has to be a way to connect this class to my GUI class

    //a simple function that accesses the objects Board position and
    //returns true if there is a queen at that position, false if there is not
    public boolean isQueenAt(int row, int col) {
        return board[row][col];

    }

    // Main functions that checks Rows, Columns and Diagonals for attacking queens
    public boolean solvePuzzle() {
        return validRow() && validCol() && validDiagonal();
    }

    public boolean validRow() {
        for (int row = 0; row < 8; row++) { // for each row
            int queenCount = 0;
            for (int col = 0; col < 8; col++) { // for each column
                if (this.isQueenAt(row, col)) { // if there is a queen at this position
                    queenCount++; // increment queenCount
                }
            }
            if (queenCount > 1) {
                return false; // if there is more than 1 queen in a row, return false
            }
        }
        return true; // if there is not more than 1 queen in a row, return true
    }

    /*  checks if there is more than 1 Queen in a column
     True if no more than 1 Queen in a column, false if there is more than 1 Queen */
    public boolean validCol() {
        for (int col = 0; col < 8; col++) {
            int queenCount = 0;
            for (int row = 0; row < 8; row++) {
                if (this.isQueenAt(row, col)) {
                    queenCount++;
                }
            }
            if (queenCount > 1) {
                return false;
            }
        }
        return true;
    }

    // Checks Diagonals for queens > 1
    // True if no more than 1 Queen in a diagonal, false if there is more than 1 Queen

    /* really tricky part of this algorithm
     * We use 3 Cases to implement this function
     * 1.
     *
     */
    public boolean validDiagonal() {
        int queenCount = 0;
        for(int col = 0; col < 7; col++)
        {
            for(int row = 0; row <= 7-col; row++)
            {
                if(this.isQueenAt(row, col + row))
                {
                    queenCount++;
                }
            }
            if (queenCount > 1)
            {
                return false;
            }
        }

        for(int row = 0; row < 7; row++)
        {
            for(int col = 7; col >= row; col--)
            {
                if(this.isQueenAt(7 - col + row, col))
                {
                    queenCount++;
                }
            }
            if (queenCount > 1)
            {
                return false;
            }
        }

        for(int row = 7; row < 7; row++)
        {
            for(int col = 7; col >= row; col--)
            {
                if(this.isQueenAt(7 - col + row, col))
                {
                    queenCount++;
                }
            }
            if (queenCount > 1)
            {
                return false;
            }
        }
        for(int col= 7; col > 0; col--)
        {
            for(int row = 7; col >= 7-col; row--)
            {
                if(this.isQueenAt(row, row+col-7))
                {
                    queenCount++;
                }
            }
            if (queenCount > 1)
            {
                return false;
            }
        }
        for(int row= 7; row > 0; row--)
        {
            for(int col = 0; col <=row; col++)
            {
                if(this.isQueenAt(row-col, col))
                {
                    queenCount++;
                }
            }
            if (queenCount > 1)
            {
                return false;
            }
        }

        return true;
    }
}