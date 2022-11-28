package controller;

import service.PlayerService;
import service.TargetService;
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

    public void gameOver() {
        ResultView.gameOver();
        int i = InputView.chooseRestartGame();
        if (i == 2) {
            System.exit(0);
        }
        startGame();
    }

}
