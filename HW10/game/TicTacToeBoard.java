package game;

import java.util.Arrays;
import java.util.Map;
import java.lang.*;

public class TicTacToeBoard implements Board {
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


    public TicTacToeBoard(int n, int m, int k) {
        field = new Cell[n][m];
        for (Cell[] row : field) {
            Arrays.fill(row, Cell.E );
        }
        turn = Cell.X;
        this.n = n;
        this.m = m;
        this.k = k;
        this.cells = n * m;
        position = new CurrentPosition();
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

        //поле - field
        //x, y - последний ход
        //turn - буква

        int r = 0, c = 0, d1 = 0, d2 = 0;
        for (int i = -k; i <= k; i++) {
            r += (x + i >= 0 && x + i < n && field[x + i][y] == turn ? 1 : 0);
            c += (y + i >= 0 && y + i < m && field[x][y + i] == turn ? 1 : 0);
            d1 += (x + i >= 0 && x + i < n && y + i >= 0 && y + i < m && field[x + i][y + i] == turn ? 1 : 0);
            d2 += (x + i >= 0 && x + i < n && y - i >= 0 && y - i < m && field[x + i][y - i] == turn ? 1 : 0);
        }
        if (r >= k || c >= k || d1 >= k || d2 >= k) {
            return true;
        }

        return false;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(" ");
        for (int i = 1; i <= m; i++) {
            sb.append(i);
        }
        sb.append(System.lineSeparator());
        for (int r = 0; r < n; r++) {
            sb.append(r + 1);
            for (Cell cell : field[r]) {
                sb.append(CELL_TO_STRING.get(cell));
            }
            sb.append(System.lineSeparator());
        }
        sb.setLength(sb.length() - System.lineSeparator().length());
        return sb.toString();
    }


}
