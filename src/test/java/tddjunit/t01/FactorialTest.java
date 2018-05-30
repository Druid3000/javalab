package tddjunit.t01;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(value=Parameterized.class)
public class FactorialTest {

    private long expected;
    private int value;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList( new Object[][] {
                { 1, 0 }, // expected, value
                { 1, 1 },
                { 2, 2 },
                { 24, 4 },
                { 5040, 7 },
        });
    }

    public FactorialTest(long expected, int value) {
        this.expected = expected;
        this.value = value;
    }

    @Test
    public void testFactorial() {
        try {
            Factorial factorial = new Factorial();
            assertEquals(expected, factorial.fact(value));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testExceptionMethod() {
        try {
            Factorial factorial = new Factorial();
            factorial.fact(-1);
            Assert.fail("Expected IOException");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Disabled
    @Test
    public void testSomeIgnoredMethod(){
        System.out.println("Some ignored method");
    }
}
