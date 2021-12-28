package game;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int n = 0, m = 0, k = 0, p = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter n, m, k:");
        boolean flag;
        do {
            flag = false;
            try {
                n = in.nextInt();
                m = in.nextInt();
                k = in.nextInt();
                if (n <= 0 || m <= 0 || k <= 0) {
                    flag = true;
                    System.out.println("Please, enter valid n, m, k: ");
                }
            } catch (Exception e) {
                flag = true;
                System.out.println("Please, enter valid n, m, k: ");
                in.nextLine();
            }
        } while (flag);
        System.out.println("Enter number of players:");
        do {
            flag = false;
            try {
                p = in.nextInt();
                if (p <= 0) {
                    flag = true;
                    System.out.println("Please, enter valid number");
                }
            } catch (Exception e) {
                flag = true;
                in.nextLine();
                System.out.println("Please, enter valid number");
            }
        } while (flag);
        List<Player> players = new ArrayList<>();
        System.out.println("Enter players types: human/seq/rand");
        int cnt = 0;
        while (cnt < p) {
            String s = in.next();
            cnt++;
            switch (s) {
                case "human" -> players.add(new HumanPlayer(in));
                case "seq" -> players.add(new SequentialPlayer());
                case "rand" -> players.add(new RandomPlayer());
                default -> {
                    cnt--;
                    System.out.println("Please, enter valid type of player");
                }
            }
        }
        int[] result = new Tournament(
                players, n, m, k
        ).play(true);
        for (int i = 0; i < p; i++) {
            System.out.println("Player" + (i + 1)  + ": totally has " + result[i] + " points");
        }
    }
}
