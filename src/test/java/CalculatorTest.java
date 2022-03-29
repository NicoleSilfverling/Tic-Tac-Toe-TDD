import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CalculatorTest {

    int tal1 = 4;
    int tal2 = 5;

    @BeforeEach
    public void setup(){
        System.out.println("Before test");
    }


    @Test
    public void addTest(){
        int sum = Calculator.add(tal1, tal2);
        assertEquals(tal1+tal2, sum);
    }

    @Test
    public void subTest(){
        int sum = Calculator.sub(tal1, tal2);
        assertEquals(tal1-tal2, sum);
    }
}
