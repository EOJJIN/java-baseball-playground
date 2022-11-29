package controller;

import service.PlayerService;
import service.TargetService;
import util.InputValidationUtil;
import view.InputView;
import view.ResultView;

public class GameController {
    private final PlayerService playerService = new PlayerService();
    private final TargetService targetService = new TargetService();

    public void startGame() {
        targetService.setTargetNumber();
        playerService.resetWin();
        playGame();
    }

    public void playGame() {
        String strNum = InputView.enterNumber();

        while (!InputValidationUtil.isNumericAndThreeDigit(strNum)) {
            strNum = enterAgain();
        }
        playerService.setNumber(strNum);

        playerService.resetResult();
        targetService.judgePlayer(playerService.getPlayer());
        String result = playerService.getResult();
        ResultView.showResult(result);

        if (!playerService.getPlayer().isWin()) {
            playGame();
        }
        gameOver();
    }

    public String enterAgain() {
        ResultView.pleaseEnterAgain();
        return InputView.enterNumber();
    }

    public void gameOver() {
        ResultView.gameOver();
        String strNum = InputView.chooseRestartGame();

        while (!InputValidationUtil.isOneOrTwo(strNum)) {
            strNum = chooseAgain();
        }
        if (Integer.parseInt(strNum) == 2) {
            System.exit(0);
        }
        startGame();
    }

    public String chooseAgain() {
        ResultView.pleaseChooseAgain();
        return InputView.chooseRestartGame();
    }

}
