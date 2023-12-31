import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import screens.HomePage;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.Assert.assertEquals;

public class CalculatorTest {

    AndroidDriver driver;
    HomePage page;

    @BeforeTest
    public void SetUp() throws MalformedURLException {

        // Set DesiredCapabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("platformVersion", "9");
        caps.setCapability("automationName", "UiAutomator2");

        // Set Capability for Build in Calculator
        caps.setCapability("appPackage", "com.android.calculator2");
        caps.setCapability("appActivity", ".Calculator");

        // URL Appium Server
        URL url = new URL("http://localhost:4723/wd/hub");

        // definition Android Driver
        driver = new AndroidDriver(url, caps);
        page = new HomePage(driver);

    }

    @Test
    public void testAddition() {
        // sum ( 402, 15 ) 417
        page.addition();

        System.out.println("Addition Result : " + page.getResult());

        // Assertion result
        assertEquals(page.getResult(), "417", "Addition not work");

        // clear calculator
        page.clear();
    }

    @Test
    public void testSubtraction() {
        // sub( 48 , 8 ) 40
        page.subtraction();

        System.out.println("Subtraction Result : " + page.getResult());

        // Assertion result
        assertEquals(page.getResult(), "40", "Subtraction not work");

        // clear calculator
        page.clear();

    }

    @Test
    public void testMultiplication() {
        // Multiplication( 39 , 67 ) 2,613
        page.multiplication();

        String result = page.getResult();
        System.out.println("Multiplication Result : " + result);

        // Assertion result
        assertEquals(result.replace(",", ""), "2613", "Multiplication not work");

        // clear calculator
        page.clear();

    }

    @Test
    public void testDivision() {
        // Division( 27 , 3 ) 9
        page.division();

        String result = page.getResult();
        System.out.println("Division Result : " + result);

        // Assertion result
        assertEquals(result, "9", "Division not work");

        // clear calculator
        page.clear();

    }

    @Test
    public void testDecimalPoint() {
        // Decimal Point   sum( 20.5 , 3.5 ) 24
        page.decimalPoint();

        String result = page.getResult();
        System.out.println("Decimal Point Sum Result : " + result);

        // Assertion result
        assertEquals(result, "24", "Decimal Point Sum not work");

        // clear calculator
        page.clear();

    }

    @Test
    public void testDivisionByZero() {
        // Division By Zero
        page.divisionByZero();

        String result = page.getResult();
        System.out.println("Division By Zero Message : " + result);

        // Assertion result
        assertEquals(result, "Can't divide by 0", "Division By Zero could not work successfully");

        // clear calculator
        page.clear();

    }

    @Test
    public void testNegativeNumbers() {
        // Negative Numbers Subtraction ( -123 , 24 ) -147
        page.negativeNumbers();

        String result = page.getResult();
        System.out.println("Negative Numbers Subtraction Result: " + result);

        // Assertion result
        assertEquals(result, "−147", "Negative Numbers could not work successfully");

        // clear calculator
        page.clear();

    }

    @Test
    public void testCombinationOperations() {
        //  Combination Operations ( 3*5+6/2-1 ) 17
        page.combinationOperations();

        String result = page.getResult();
        System.out.println(" Combination Operations Result: " + result);

        // Assertion result
        assertEquals(result, "17", "Combination Operations could not work successfully");

        // clear calculator
        page.clear();

    }

    @Test
    public void testHistory() {
        //  History Function make Sum operation ( 402, 15 ) and check if 417 found in history
        page.historyFunction();

        String result = page.getHistoryResult();
        System.out.println("History Result: " + result);

        // Assertion result
        assertEquals(result, "417", "History could not work successfully");
        driver.navigate().back();

        // clear calculator
        page.clear();
    }

    @Test
    public void testScientificCalculatorFunctions() {
        //  Scientific Calculator Functions tan ( 45 ) = 1
        page.ScientificCalculator();

        String result = page.getResult();
        System.out.println("Scientific Result: " + result);

        // Assertion result
        assertEquals(result, "1", "Scientific Calculator Functions could not work successfully");

        // clear calculator
        page.clear();
    }


    @AfterTest
    public void TireDown() {
        driver.quit();
    }
}
