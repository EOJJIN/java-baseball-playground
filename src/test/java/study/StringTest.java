package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String[] actual = "1,2".split(",");
        assertThat(actual).contains("1");
        assertThat(actual).contains("2");
        actual = "1".split(",");
        assertThat(actual).containsExactly("1");
    }

    @Test
    void substring() {
        String actual = "(1,2)".substring(1, "(1,2)".length() - 1);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt 성공,예외")
    void charAt() {
        String actual = "abc";
        assertThat(actual.charAt(0)).isEqualTo('a');
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    actual.charAt(3);
                }).withMessageContaining("String index out of range:");

    }
}
