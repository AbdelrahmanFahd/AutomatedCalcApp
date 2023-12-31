package screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    AndroidDriver driver;

    public HomePage(AndroidDriver driver) {
        this.driver = driver;
    }

    By digit_1 = AppiumBy.id("digit_1");
    By digit_2 = AppiumBy.id("digit_2");
    By digit_3 = AppiumBy.id("digit_3");
    By digit_4 = AppiumBy.id("digit_4");
    By digit_5 = AppiumBy.id("digit_5");
    By digit_6 = AppiumBy.id("digit_6");
    By digit_7 = AppiumBy.id("digit_7");
    By digit_8 = AppiumBy.id("digit_8");
    By digit_9 = AppiumBy.id("digit_9");
    By digit_0 = AppiumBy.id("digit_0");
    By dec_point = AppiumBy.id("dec_point");
    By equal = AppiumBy.id("eq");
    By add = AppiumBy.id("op_add");
    By sub = AppiumBy.id("op_sub");
    By multi = AppiumBy.id("op_mul");
    By div = AppiumBy.id("op_div");
    By delete = AppiumBy.id("del");
    By clearButton = AppiumBy.id("clr");
    By result = AppiumBy.id("result");
    By formula = AppiumBy.id("formula");
    By moreOptions = AppiumBy.accessibilityId("More options");
    By history = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"History\"]");
    By historyResult = AppiumBy.id("history_result");
    By padAdvanced = AppiumBy.id("pad_advanced");
    By tan = AppiumBy.id("fun_tan");
    By toggleMode = AppiumBy.id("toggle_mode");

    public void addition() {
        // sum ( 402, 15 )
        driver.findElement(digit_4).click();
        driver.findElement(digit_0).click();
        driver.findElement(digit_2).click();
        driver.findElement(add).click();
        driver.findElement(digit_1).click();
        driver.findElement(digit_5).click();

    }

    public void subtraction() {
        // sub( 48 , 8 )
        driver.findElement(digit_4).click();
        driver.findElement(digit_8).click();
        driver.findElement(sub).click();
        driver.findElement(digit_8).click();
    }

    public String getResult() {
        return driver.findElement(result).getText();
    }

    public void clear() {
        TouchAction action = new AndroidTouchAction(driver);
        action.longPress(ElementOption.element(driver.findElement(delete))).release().perform();
    }

    public void multiplication() {
        // Multiplication( 39 , 67 ) 2,613
        driver.findElement(digit_3).click();
        driver.findElement(digit_9).click();
        driver.findElement(multi).click();
        driver.findElement(digit_6).click();
        driver.findElement(digit_7).click();

    }

    public void division() {
        // Division( 27 , 3 ) 9
        driver.findElement(digit_2).click();
        driver.findElement(digit_7).click();
        driver.findElement(div).click();
        driver.findElement(digit_3).click();
    }

    public void decimalPoint() {
        // Decimal Point   sum( 20.5 , 3.5 ) 24
        driver.findElement(digit_2).click();
        driver.findElement(digit_0).click();
        driver.findElement(dec_point).click();
        driver.findElement(digit_5).click();
        driver.findElement(add).click();
        driver.findElement(digit_3).click();
        driver.findElement(dec_point).click();
        driver.findElement(digit_5).click();
    }

    public void divisionByZero() {
        // Division By Zero
        driver.findElement(digit_2).click();
        driver.findElement(div).click();
        driver.findElement(digit_0).click();
        driver.findElement(equal).click();

    }

    public void negativeNumbers() {
        // Negative Numbers Subtraction ( -123 , 24 ) -147
        driver.findElement(sub).click();
        driver.findElement(digit_1).click();
        driver.findElement(digit_2).click();
        driver.findElement(digit_3).click();
        driver.findElement(sub).click();
        driver.findElement(digit_2).click();
        driver.findElement(digit_4).click();
    }

    public void combinationOperations() {
        //  Combination Operations ( 3*5+6/2-1 ) 17
        driver.findElement(digit_3).click();
        driver.findElement(multi).click();
        driver.findElement(digit_5).click();
        driver.findElement(add).click();
        driver.findElement(digit_6).click();
        driver.findElement(div).click();
        driver.findElement(digit_2).click();
        driver.findElement(sub).click();
        driver.findElement(digit_1).click();
    }

    public void historyFunction() {
        // TouchAction action = new TouchAction(driver);
        addition();
        driver.findElement(equal).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(clearButton));
        driver.findElement(clearButton).click();
        driver.findElement(moreOptions).click();
        driver.findElement(history).click();
    }

    public String getHistoryResult() {
        return driver.findElement(historyResult).getText();
    }

    public void ScientificCalculator() {
        //  Scientific Calculator Functions tan ( 45 ) = 1

        driver.findElement(padAdvanced).click();
        driver.findElement(toggleMode).click();
        driver.findElement(tan).click();
        driver.navigate().back();

        driver.findElement(digit_4).click();
        driver.findElement(digit_5).click();
    }
}
