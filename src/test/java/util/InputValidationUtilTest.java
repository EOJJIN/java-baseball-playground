package util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class InputValidationUtilTest {

    @ParameterizedTest
    @CsvSource(value = {"123,true", "12,false", "1234,false", "abc,false"})
    void isNumericAndThreeDigit(String str, boolean expected) {
        assertThat(InputValidationUtil.isNumericAndThreeDigit(str)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true", "3,false", "11,false", "a,false"})
    void isOneOrTwo(String str, boolean expected) {
        assertThat(InputValidationUtil.isOneOrTwo(str)).isEqualTo(expected);
    }
}
