
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.zip.DeflaterOutputStream;

public class BackLogicTest {
    private BackLogic backLogic;

    @Before
    public void setup(){
        backLogic = new BackLogic();
    }
    // ableToArriveAt24 Test

    @Test
    public void ableToArriveAt24Test1(){
        // Given
        Double[] testArray = {1.0, 2.0, 3.0, 4.0};

        // When
        // Then
        Assert.assertTrue(backLogic.ableToArriveAt24Attempt3(testArray, 1535));
    }

    @Test
    public void ableToArriveAt24Test2(){
        // Given
        Double[] testArray = {8.0, 8.0, 9.0, 9.0};

        // When
        // Then
        Assert.assertFalse(backLogic.ableToArriveAt24Attempt3(testArray, 1535));
    }

    @Test
    public void ableToArriveAt24Test3(){
        // Given
        Double[] testArray = {3.0, 4.0, 5.0, 6.0};

        // When
        // Then
        Assert.assertTrue(backLogic.ableToArriveAt24Attempt3(testArray, 1535));
    }

    @Test
    public void ableToArriveAt24Attempt1Test1(){
        // Given
        Double[] testArray = {1.0, 2.0, 3.0, 4.0};

        // When
        // Then
        Assert.assertTrue(backLogic.ableToArriveAt24Attempt1(testArray));
    }

    @Test
    public void ableToArriveAt24Attempt1Test2(){
        // Given
        Double[] testArray = {8.0, 8.0, 9.0, 9.0};

        // When
        // Then
        Assert.assertFalse(backLogic.ableToArriveAt24Attempt1(testArray));
    }

    @Test
    public void ableToArriveAt24Attempt1Test3(){
        // Given
        Double[] testArray = {3.0, 4.0, 5.0, 6.0};

        // When
        // Then
        Assert.assertTrue(backLogic.ableToArriveAt24Attempt1(testArray));
    }

    // checkTwoParenthesis Test

    @Test
    public void checkTwoParenthesisTest1(){
        // Given
        Double number1 = 12.0;
        Double number2 = 8.0;
        Double number3 = 2.0;
        Double number4 = 4.0;
        int op1 = 1;
        int op2 = 2;
        int op3 = 0;

        // When
        boolean actual = backLogic.checkTwoParenthesis(number1, number2, number3, number4, op1, op2, op3);

        // Then
        Assert.assertTrue(actual);
    }

    @Test
    public void checkTwoParenthesisTest2(){
        // Given
        Double number1 = 1.0;
        Double number2 = 5.0;
        Double number3 = 3.0;
        Double number4 = 4.0;
        int op1 = 3;
        int op2 = 1;
        int op3 = 2;

        // When
        boolean actual = backLogic.checkTwoParenthesis(number1, number2, number3, number4, op1, op2, op3);

        // Then
        Assert.assertFalse(actual);
    }

    @Test
    public void checkTwoParenthesisTest3(){
        // Given
        Double number1 = 14.0;
        Double number2 = 34.0;
        Double number3 = 3.0;
        Double number4 = 1.0;
        int op1 = 0;
        int op2 = 3;
        int op3 = 1;

        // When
        boolean actual = backLogic.checkTwoParenthesis(number1, number2, number3, number4, op1, op2, op3);

        // Then
        Assert.assertTrue(actual);
    }

    // checkNoParenthesis Test

    @Test
    public void checkNoParenthesisTest1(){
        // Given
        Double number1 = 1.0;
        Double number2 = 8.0;
        Double number3 = 3.0;
        Double number4 = 4.0;
        int op1 = 0;
        int op2 = 1;
        int op3 = 2;

        // When
        boolean actual = backLogic.checkNoParenthesis(number1, number2, number3, number4, op1, op2, op3);

        // Then
        Assert.assertTrue(actual);
    }

    @Test
    public void checkNoParenthesisTest2(){
        // Given
        Double number1 = 1.0;
        Double number2 = 5.0;
        Double number3 = 3.0;
        Double number4 = 4.0;
        int op1 = 0;
        int op2 = 1;
        int op3 = 2;

        // When
        boolean actual = backLogic.checkNoParenthesis(number1, number2, number3, number4, op1, op2, op3);

        // Then
        Assert.assertFalse(actual);
    }

    @Test
    public void checkNoParenthesisTest3(){
        // Given
        Double number1 = 8.0;
        Double number2 = 2.0;
        Double number3 = 3.0;
        Double number4 = 12.0;
        int op1 = 3;
        int op2 = 2;
        int op3 = 0;

        // When
        boolean actual = backLogic.checkNoParenthesis(number1, number2, number3, number4, op1, op2, op3);

        // Then
        Assert.assertTrue(actual);
    }

    // performOperation Test

    @Test
    public void performOperationTest1(){
        // Given
        Double number1 = 16.0;
        Double number2 = 8.0;
        int operation = 0;

        // When
        Double expected = 24.0;
        Double actual = backLogic.performOperation(number1, number2, operation);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void performOperationTest2(){
        // Given
        Double number1 = 15.0;
        Double number2 = 8.0;
        int operation = 1;

        // When
        Double expected = 7.0;
        Double actual = backLogic.performOperation(number1, number2, operation);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void performOperationTest3(){
        // Given
        Double number1 = 6.0;
        Double number2 = 3.0;
        int operation = 2;

        // When
        Double expected = 18.0;
        Double actual = backLogic.performOperation(number1, number2, operation);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void performOperationTest4(){
        // Given
        Double number1 = 16.0;
        Double number2 = 8.0;
        int operation = 3;

        // When
        Double expected = 2.0;
        Double actual = backLogic.performOperation(number1, number2, operation);

        // Then
        Assert.assertEquals(expected, actual);
    }

    // removeTheElement Test

    @Test
    public void removeTheElementTest1(){
        // Given
        Double[] givenArray = {4.0, 5.0, 7.0};
        int givenIndex = 1;
        // When
        Double[] expected = {4.0, 7.0};
        Double[] actual = backLogic.removeTheElement(givenArray, givenIndex);

        // Then
        Assert.assertEquals(expected[0], actual[0]);
        Assert.assertEquals(expected[1], actual[1]);
    }

    @Test
    public void removeTheElementTest2(){
        // Given
        Double[] givenArray = {4.0, 5.0, 14.0, 7.0};
        int givenIndex = 3;
        // When
        Double[] expected = {4.0, 5.0, 14.0};
        Double[] actual = backLogic.removeTheElement(givenArray, givenIndex);

        // Then
        Assert.assertEquals(expected[0], actual[0]);
        Assert.assertEquals(expected[1], actual[1]);
        Assert.assertEquals(expected[2], actual[2]);
    }

}
