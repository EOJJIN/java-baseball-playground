package service;

import domain.Player;
import domain.Target;

import java.util.stream.IntStream;

public class TargetService {
    private final Target target = new Target();

    public int[] makeRandomIntArr() {
        int[] ints = new int[3];

        ints[0] = (int) (Math.random() * 9) + 1;

        ints[1] = (int) (Math.random() * 9) + 1;
        while (ints[0] == ints[1]) {
            ints[1] = (int) (Math.random() * 9) + 1;
        }

        ints[2] = (int) (Math.random() * 9) + 1;
        while (ints[0] == ints[2] || ints[1] == ints[2]) {
            ints[2] = (int) (Math.random() * 9) + 1;
        }

        return ints;
    }

    public int[] setTargetNumber() {
        int[] ints = makeRandomIntArr();
        target.setNumber(ints);
        return ints;
    }

    public Player judgePlayer(Player player) {
        int[] playerNumber = player.getNumber();

        for (int i = 0; i < 3; i++) {
            int playerNum = playerNumber[i];
            int index = IntStream.range(0, target.getNumber().length)
                    .filter(j -> playerNum == target.getNumber()[j])
                    .findFirst()
                    .orElse(-1);
            if (index < 0) continue;
            if (index == i) player.addStrike();
            if (index != i) player.addBall();
        }
        return player;
    }
}
