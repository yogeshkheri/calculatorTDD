import com.proj.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    @Test
    public void shouldReturnZero_onEmptyString() {
        assertEquals(0, Calculator.add(""));
    }

    @Test
    public void shouldReturnValue_onStringValue() {
        assertEquals(5, Calculator.add("5"));
    }

    @Test
    public void shouldReturnAdditionValue_onStringValue() {
        assertEquals(6, Calculator.add("1,5"));
    }

    @Test
    public void shouldReturnSumValue_onMultipleStringValue() {
        assertEquals(6, Calculator.add("1,2,3"));
    }

    @Test
    public void shouldReturnSumValue_withTwoDelimiter_onMultipleStringValue() {
        assertEquals(7, Calculator.add("1\n2,4"));
    }

    @Test
    public void shouldReturnSumValue_withCustomDelimiter_onMultipleStringValue() {
        assertEquals(6, Calculator.add("//,\n1,2,3"));
    }
}
