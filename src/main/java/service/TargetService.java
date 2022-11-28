package service;

import domain.Player;
import domain.Target;

import java.util.stream.IntStream;

public class TargetService {
    private final Target target = new Target();

    public void setTargetNumber() {
        int[] number = new int[3];

        number[0] = (int) (Math.random() * 9) + 1;

        number[1] = (int) (Math.random() * 9) + 1;
        while (number[0] == number[1]) {
            number[1] = (int) (Math.random() * 9) + 1;
        }

        number[2] = (int) (Math.random() * 9) + 1;
        while (number[0] == number[2] || number[1] == number[2]) {
            number[2] = (int) (Math.random() * 9) + 1;
        }

        target.setNumber(number);
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
