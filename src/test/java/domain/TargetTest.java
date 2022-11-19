package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class TargetTest {

    @Test
    void setNumber(){
        Target target = new Target();
        target.setNumber();
        assertThat(target.getNumber().length).isEqualTo(3);
    }

    @Test
    void duplicateNumber(){
        Target target = new Target();
        target.setNumber();
        int[] result = Arrays.stream(target.getNumber()).distinct().toArray();
        assertThat(result.length).isEqualTo(3);
    }
}
