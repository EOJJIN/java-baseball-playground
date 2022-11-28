package domain;

public class Player {
    private int[] number;
    private int ball;
    private int strike;
    private boolean isWin;

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
