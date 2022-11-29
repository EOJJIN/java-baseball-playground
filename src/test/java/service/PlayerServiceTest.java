package service;

import domain.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerServiceTest {
    private PlayerService playerService;

    @BeforeEach
    void setUp() {
        playerService = new PlayerService();
    }

    @Test
    void setPlayerStringToNumberArr() {
        String str = "123";

        playerService.setNumber(str);
        Player player = playerService.getPlayer();

        assertThat(player.getNumber()).isInstanceOf(int[].class);
        assertThat(player.getNumber()).hasSize(3);
        assertThat(player.getNumber()[0]).isEqualTo(1);
    }

    @Test
    void getResultThreeStrike() {
        Player player = playerService.getPlayer();
        player.addStrike();
        player.addStrike();
        player.addStrike();

        assertThat(playerService.getResult()).isEqualTo("3스트라이크");
        assertThat(player.isWin()).isEqualTo(true);
    }

    @Test
    void getResultNothing() {
        Player player = playerService.getPlayer();

        assertThat(playerService.getResult()).isEqualTo("낫싱");
        assertThat(player.isWin()).isEqualTo(false);
    }

    @Test
    void getResultOneBallAndTwoStrike() {
        Player player = playerService.getPlayer();
        player.addBall();
        player.addStrike();
        player.addStrike();

        assertThat(playerService.getResult()).isEqualTo("1볼 2스트라이크");
        assertThat(player.isWin()).isEqualTo(false);
    }

    @Test
    void resetPlayerResult() {
        Player player = playerService.getPlayer();
        player.addBall();
        player.addStrike();
        player.addStrike();

        playerService.resetResult();

        assertThat(playerService.getResult()).isEqualTo("낫싱");
        assertThat(player.isWin()).isEqualTo(false);
    }

    @Test
    void resetPlayerWin() {
        Player player = playerService.getPlayer();
        player.addStrike();
        player.addStrike();
        player.addStrike();
        playerService.getResult();

        assertThat(player.isWin()).isEqualTo(true);
        playerService.resetWin();

        assertThat(player.isWin()).isEqualTo(false);
    }


}
