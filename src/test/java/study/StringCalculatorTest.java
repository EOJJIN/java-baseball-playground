package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    private StringCalcaulator sc;

    @BeforeEach
    void setUp() {
        sc = new StringCalcaulator();
    }

    @Test
    void CalaulatorTest() {
        String input = "2 + 3 * 4 / 2";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        sc.start();
        assertThat(out.toString()).isEqualTo("10");
    }
}

