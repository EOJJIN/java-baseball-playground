package view;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public static String enterNumber() {
        System.out.print("숫자를 입력해 주세요 : ");
        String strNum = scanner.nextLine();
        return strNum;
    }

    public static String chooseRestartGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String strNum = scanner.nextLine();
        return strNum;
    }

}
