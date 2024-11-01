import com.proj.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void shouldRaiseExceptionOnNegativeValues(){
        Exception exception =   assertThrows(NumberFormatException.class, ()-> {
            Calculator.add("-1,2,3");
        });
        String expectedMessage = "negative numbers not allowed [-1]";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void shouldReturnSumValue_withCustomDelimiter_with1000Limit_onMultipleStringValue() {
        assertEquals(6, Calculator.add("//,\n1,2,3,1001"));
    }

    @Test
    public void shouldReturnSumValue_withCustomDelimiter_withLargeLengthDelimiter_onMultipleStringValue() {
        assertEquals(7, Calculator.add("//[***]\n1***2***4"));
    }

    @Test
    public void shouldReturnSumValue_withCustomDelimiter_with_onMultipleStringValue() {
        assertEquals(6, Calculator.add("//[*][%]\n1*2%3"));
    }

    @Test
    public void shouldReturnSumValue_withCustomDelimiter_withLargeMultipleLengthDelimiter_onMultipleStringValue() {
        assertEquals(9, Calculator.add("//[***][,,]\n1***2,,6"));
    }
}
