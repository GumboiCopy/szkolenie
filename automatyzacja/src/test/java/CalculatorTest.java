import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void canAdd() throws Exception {
        double a = 5;
        double b = 3;
        Calculator calc = new Calculator();
        double result = calc.add(a, b);
        Assert.assertTrue("5 + 3 = 8", result == 8);
    }
   @Test
   public void canAdd2() throws Exception {
        double a = 5;
        double b = -3;
        Calculator calc = new Calculator();
        double result = calc.add(a, b);
        Assert.assertTrue("5 + (-3) = 2", result == 2);
    }
    @Test
    public void CanSubtract() throws Exception {
        double a = 1;
        double b = 2;
        Calculator calc = new Calculator();
        double result =calc.subtract(a,b);
        Assert.assertTrue ("1-2", result ==-1);
    }
    @Test
    public void CanSubtract2() throws Exception {
        double a = 1;
        double b = 3;
        Calculator calc = new Calculator();
        double result =calc.subtract(a,b);
        Assert.assertTrue ("1-3", result ==-2);
    }

    @Test
    public void CanMultiply() throws Exception{
        double a = 10;
        double b = 2;
        Calculator calc = new Calculator();
        double result =calc.multiply(a,b);
        Assert.assertTrue ("10*2", result ==20);
    }

    @Test
    public void CanMultiply2() throws Exception{
        double a = 100;
        double b = 2.5;
        Calculator calc = new Calculator();
        double result =calc.multiply(a,b);
        Assert.assertTrue ("100*2.5", result ==250);
    }

    @Test
    public void CanDivide() throws Exception {
        double a = 10;
        double b = 2;
        Calculator calc = new Calculator();
        double result =calc.divide(a,b);
        Assert.assertTrue ("10:2", result ==5);
    }

@Test
    public void CanDivide2() throws Exception {
        double a = 1;
        double b = 2;
        Calculator calc = new Calculator();
        double result =calc.divide(a,b);
        Assert.assertTrue ("1:2", result ==0.5);
    }
}