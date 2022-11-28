package service;

import domain.Player;

import java.util.Arrays;

public class PlayerService {
    private final Player player = new Player();

    public Player getPlayer() {
        return player;
    }

    public void setNumber(String strNum) {
        if (strNum.length() == 3) {
            int[] arrNum = Arrays.stream(strNum.split("")).mapToInt(Integer::parseInt).toArray();
            player.setNumber(arrNum);
        }
    }

    public String getResult() {
        if (player.getStrike() == 3) {
            player.setWin(true);
            return player.getStrike() + "스트라이크";
        }
        if (player.getBall() == 0 && player.getStrike() == 0) {
            return "낫싱";
        }
        if (player.getStrike() == 0) {
            return player.getBall() + "볼";
        }
        if (player.getBall() == 0) {
            return player.getStrike() + "스트라이크";
        }
        return player.getBall() + "볼 " + player.getStrike() + "스트라이크";
    }

    public void resetResult() {
        player.reset();
    }

    public void resetWin() {
        player.setWin(false);
    }

}
