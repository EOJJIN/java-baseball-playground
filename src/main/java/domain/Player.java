package domain;

public class Player {
    private int[] number;
    private int ball;
    private int strike;
    private boolean isWin;

    public String getResult() {
        if (strike == 3) {
            isWin = true;
            return strike + "스트라이크";
        }
        if (ball == 0 && strike == 0) {
            return "낫싱";
        }
        if (strike == 0) {
            return ball + "볼";
        }
        if (ball == 0) {
            return strike + "스트라이크";
        }
        return ball + "볼 " + strike + "스트라이크";
    }

    public int[] getNumber() {
        return number;
    }

    public void setNumber(int[] number) {
        this.number = number;
    }

    public int getBall() {
        return ball;
    }

    public void addBall() {
        ball++;
    }

    public int getStrike() {
        return strike;
    }

    public void addStrike() {
        strike++;
    }

    public boolean isWin() {
        return isWin;
    }

    public void setWin(boolean win) {
        isWin = win;
    }

    public void reset() {
        this.ball = 0;
        this.strike = 0;
    }
}
