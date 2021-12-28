/*package game;

import java.util.Scanner;

public class HumanPlayer implements Player {
    private final Scanner in;

    public HumanPlayer(Scanner in) {
        this.in = in;
    }

    @Override
    public Move makeMove(Position position) {
        System.out.println();
        System.out.println("Enter you move for " + position.getTurn());
        while (true) {
            Move move = new Move(in.nextInt() - 1, in.nextInt() - 1, position.getTurn());
            if (position.isValid(move)) {
                return move;
            }
            System.out.println("Not a valid move, try again:");
        }
    }
}
*/

package game;

import java.util.Scanner;

public class HumanPlayer implements Player {
    private final Scanner in;

    public HumanPlayer(Scanner in) {
        this.in = in;
    }

    @Override
    public Move makeMove(Position position) {
        System.out.println();
        int x = 0, y = 0;
        boolean flag;
        System.out.println("Enter your move for " + position.getTurn());
        do {
            try {
                x = in.nextInt();
                y = in.nextInt();
                flag = !position.isValid(new Move(x - 1, y - 1, position.getTurn()));
            } catch (Exception e) {
                flag = true;
                String s = in.nextLine();
            }
            if (flag) {
                System.out.println("Please, enter valid move for " + position.getTurn());
            }
        } while (flag);
        return new Move(x - 1, y - 1, position.getTurn());
    }
}