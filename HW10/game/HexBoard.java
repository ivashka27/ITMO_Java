package game;

import java.util.Arrays;
import java.util.Map;

public class HexBoard extends TicTacToeBoard implements Board {
    private static final Map<Cell, String> CELL_TO_STRING = Map.of(
            Cell.E, ".",
            Cell.X, "X",
            Cell.O, "0"
    );

    private final Cell[][] field;
    final Position position;
    private Cell turn;
    private final int n;
    private final int m;
    private final int k;
    private int cells;


    public HexBoard(int n, int m, int k) {
        field = new Cell[n][m];
        for (Cell[] row : field) {
            Arrays.fill(row, Cell.E);
        }
        turn = Cell.X;
        this.n = n;
        this.m = m;
        this.k = k;
        this.cells = n * m;
        position = new CurrentPosition();
        System.out.println("Left to right diagonal direction is not taken");
    }


    public Position getPosition() {
        return this.position;

    }
    class CurrentPosition implements Position{
        @Override
        public Cell getCell(int row, int column) {
            return field[row][column];
        }
        @Override
        public Cell getTurn() {
            return turn;
        }
        public int getN() {
            return n;
        }
        public int getM() {
            return m;
        }
        public int getK() {
            return k;
        }
        public boolean isValid(final Move move) {
            return 0 <= move.getRow() && move.getRow() < n
                    && 0 <= move.getCol() && move.getCol() < m
                    && field[move.getRow()][move.getCol()] == Cell.E
                    && turn == move.getValue();
        }
    }


    @Override
    public GameResult makeMove(Move move) {
        if (!position.isValid(move)) {
            return GameResult.LOOSE;
        }

        field[move.getRow()][move.getCol()] = move.getValue();
        cells--;

        if (checkWin(move.getRow(), move.getCol())) {
            return GameResult.WIN;
        }

        if (checkDraw()) {
            return GameResult.DRAW;
        }

        turn = turn == Cell.X ? Cell.O : Cell.X;

        return GameResult.UNKNOWN;
    }

    private boolean checkDraw() {
        return cells == 0;
    }

    private boolean checkWin(int x, int y) {
        //d1 = [x + i][y - i]
        // r = [x + i][y]
        // c = [x][y + i]
        int r = 0, c = 0, d1 = 0;
        int mxR = 0, mxC = 0, mxD1 = 0;
        for (int i = -k; i <= k; i++) {
            mxR = Math.max(r = (x + i >= 0 && x + i < n && field[x + i][y] == turn ? r + 1 : 0), mxR);
            mxC = Math.max(c = (y + i >= 0 && y + i < m && field[x][y + i] == turn ? c + 1 : 0), mxC);
            mxD1 = Math.max(d1 = (x + i >= 0 && x + i < n && y - i >= 0 && y - i < m
                    && field[x + i][y - i] == turn ? d1 + 1 : 0), mxD1);
        }
        return mxR >= k || mxC >= k || mxD1 >= k;

    }

    @Override
    public String toString() {
        int spaces = String.valueOf(m).length() + 1;
        final StringBuilder board = new StringBuilder();
        board.append(String.format("%" + spaces + "s", " "));
        for (int i = 1; i <= m; i++) {
            board.append(String.format("%" + spaces + "d", i));
        }
        board.append(System.lineSeparator());
        for (int r = 0; r < n; r++) {
            board.append(" ".repeat(r + 1));
            board.append(String.format("%" + spaces + "d", r + 1));
            for (Cell cell : field[r]) {
                board.append(String.format("%" + spaces + "s", CELL_TO_STRING.get(cell)));
            }
            board.append(System.lineSeparator());
        }
        board.setLength(board.length() - System.lineSeparator().length());
        return board.toString();
    }
}

