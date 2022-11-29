package service;

import domain.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class TargetServiceTest {
    private TargetService targetService;

    @BeforeEach
    void setUp() {
        targetService = new TargetService();
    }

    @Test
    void makeRandomIntArr() {
        int[] ints = targetService.makeRandomIntArr();
        Set<Integer> set = Arrays.stream(ints).boxed().collect(Collectors.toSet());

        assertThat(ints).hasSize(3);
        assertThat(set).hasSize(3);
    }

    @Test
    void judgePlayer() {
        Player player = new Player();
        int[] ints = targetService.setTargetNumber();
        player.setNumber(ints);

        targetService.judgePlayer(player);

        assertThat(player.getStrike()).isEqualTo(3);

        player = new Player();
        player.setNumber(targetService.makeRandomIntArr());

        targetService.judgePlayer(player);

        assertThat(player.getStrike())
                .isGreaterThan(-1)
                .isLessThan(4);
    }

}
