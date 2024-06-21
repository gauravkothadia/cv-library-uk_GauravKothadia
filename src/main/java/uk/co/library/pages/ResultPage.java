package uk.co.library.pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import uk.co.library.browserfactory.ManageBrowser;
import uk.co.library.customlisteners.CustomListeners;
import uk.co.library.utility.Utility;

public class ResultPage extends Utility {

    //2.ResultPage
    //  Locators - resultText
    @CacheLookup
    @FindBy(tagName = "h1")
    WebElement resultText;

    //  Method - verifyTheResults(String expected)
    public void verifyTheResults(String expected) {
        refreshingPage();
        Assert.assertEquals(getTextFromElement(resultText), expected);

        Reporter.log("Verifying the result heading at " + resultText.toString() + " as " + expected);
        CustomListeners.test.log(Status.PASS, "Verifying the result heading as" + expected);
    }
}
