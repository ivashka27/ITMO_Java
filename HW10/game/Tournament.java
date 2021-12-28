package game;

import java.util.*;

public class Tournament {
    List<Player> players;
    int[] score;
    int n, m, k;

    public Tournament(List<Player> players, int n, int m, int k) {
        this.players = players;
        this.n = n;
        this.m = m;
        this.k = k;
        score = new int[players.size()];
    }

    public int[] play(boolean log) {
        for (int i = 0; i < players.size(); i++) {
            for (int j = 0; j < players.size(); j++) {
                if (i == j) {
                    continue;
                }
                int result = new TwoPlayerGame(
                        new HexBoard(n, m, k),
                        new ArrayList<>(List.of(players.get(i), players.get(j)))
                ).play(log);
                switch (result) {
                    case 1 -> score[i] += 3;
                    case 2 -> score[j] += 3;
                    case 0 -> {
                        score[i]++;
                        score[j]++;
                    }
                    default -> throw new AssertionError("Unknown result " + result);
                }

            }
        }
        return score;
    }
}
