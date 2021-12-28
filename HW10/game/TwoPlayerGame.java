package game;

import java.util.List;

public class TwoPlayerGame {
    private final Board board;
    private final List<Player> players;


    public TwoPlayerGame(Board board, List<Player> players) {
        this.board = board;
        this.players = players;
    }

    public int play(boolean log) {
        System.out.println(board);
        while (true) {
            for (int i = 0; i < players.size(); i++) {
                final int result = makeMove(players.get(i), i + 1, log);
                if (result != -1) {
                    return result;
                }
            }
        }
    }

    private int makeMove(Player player, int no, boolean log) {
        final Move move = player.makeMove(board.getPosition());
        final GameResult result = board.makeMove(move);
        if (log) {
            System.out.println();
            System.out.println("Player: " + no);
            System.out.println(move);
            System.out.println(board);
            System.out.println("Result: " + result);
        }
        return switch (result) {
            case WIN -> no;
            case LOOSE -> ++no % players.size();
            case DRAW -> 0;
            case UNKNOWN -> -1;
        };
    }
}
