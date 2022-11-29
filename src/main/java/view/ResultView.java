package view;

public class ResultView {
    public static void showResult(String result) {
        System.out.println(result);
    }

    public static void pleaseEnterAgain(){
        System.out.println("잘못 입력하셨습니다. 3개의 숫자를 입력해주세요.");
    }

    public static void pleaseChooseAgain() {
        System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
    }

    public static void gameOver() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

}
