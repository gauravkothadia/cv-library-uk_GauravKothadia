package uk.co.library.pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;
import uk.co.library.customlisteners.CustomListeners;
import uk.co.library.utility.Utility;

public class HomePage extends Utility {
    //1.HomePage -
    //  Locators - jobTitle, location, distanceDropDown, moreSearchOptionsLink, salaryMin, salaryMax, salaryTypeDropDown, jobTypeDropDown, findJobsBtn
    //  Methods - enterJobTitle(String jobTitle), enterLocation(String location), selectDistance(String distance), clickOnMoreSearchOptionLink(),
    //  enterMinSalary(String minSalary),  enterMaxSalary(String maxSalary), selectSalaryType(String sType), selectJobType(String jobType),
    //  clickOnFindJobsButton().
    @CacheLookup
    @FindBy(xpath = "//iframe[@id='gdpr-consent-notice']")
    WebElement iFrameGDPR;
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Accept All')]")
    WebElement gdprAcceptAllButton;
    @CacheLookup
    @FindBy(xpath = "//input[@id='keywords']")
    WebElement jobTitleField;
    @CacheLookup
    @FindBy(id = "location")
    WebElement locationField;
    @CacheLookup
    @FindBy(xpath = "//select[@id='distance']")
    WebElement distanceDropDown;
    @CacheLookup
    @FindBy(xpath = "//button[@id='toggle-hp-search']")
    WebElement moreSearchOptionsLink;
    @CacheLookup
    @FindBy(xpath = "//input[@id='salarymin']")
    WebElement salaryMin;
    @CacheLookup
    @FindBy(xpath = "//input[@id='salarymax']")
    WebElement salaryMax;
    @CacheLookup
    @FindBy(xpath = "//select[@id='salarytype']")
    WebElement salaryTypeDropDown;
    @CacheLookup
    @FindBy(id = "tempperm")
    WebElement jobTypeDropDown;
    @CacheLookup
    @FindBy(id = "hp-search-btn")
    WebElement findJobsBtn;

    String currentUrlValue;

    public void managingConsentIframe(){
        switchToIFrame(iFrameGDPR);
        clickOnElement(gdprAcceptAllButton);
        switchBackFromIFrame();
        Reporter.log("Clearing the GDPR consent iFrame "+iFrameGDPR.toString()+" clicking Accept All "+gdprAcceptAllButton.toString());
        CustomListeners.test.log(Status.PASS,"Clearing the GDPR consent iFrame and clicking Accept All button");
    }

    public void enterJobTitle(String jobTitle){
        sendTextToElement(jobTitleField,jobTitle);
        Reporter.log("Entering Job Title in "+jobTitleField.toString()+" as "+jobTitle);
        CustomListeners.test.log(Status.PASS,"Entering Job Title as "+jobTitle);
    }
    public void enterLocation(String location){
        sendTextToElement(locationField,location);
        selectAutoPopulateFirstEntryByArrowKeysAndEnter(locationField);
        Reporter.log("Entering the location in "+locationField.toString()+" as "+location);
        CustomListeners.test.log(Status.PASS,"Entering the location as "+location);
    }
    public void selectDistance(String distance){
        /*clickOnElement(distanceDropDown);
        List<WebElement> listDistance = webElementList("//select[@class='hp-distance form__select']/option");
        for(WebElement ele : listDistance){
            if(ele.getText().trim().equals(distance)){
                findSingleElementByXpath("//option[normalize-space()='"+distance+"']").click();
            }
        }*/
        clickOnElement(distanceDropDown);
        //selectEntryByArrowKeysAndEnter(distanceDropDown,distance);
        mouseHoverToElementAndClick(findSingleElementByXpath("//option[normalize-space()='"+distance+"']"));

        //selectByVisibleTextFromDropDown(distanceDropDown,distance);

        //selectByContainsTextFromDropDown(distanceDropDown,distance);

        Reporter.log("Selecting the distance from locator "+distanceDropDown.toString()+" as "+distance);
        CustomListeners.test.log(Status.PASS,"Selecting the distance as "+distance);
    }
    public void clickOnMoreSearchOptionLink(){
        mouseHoverToElementAndClick(moreSearchOptionsLink);
        Reporter.log("Clicking on search more link at "+moreSearchOptionsLink.toString());
        CustomListeners.test.log(Status.PASS,"Clicking on search more link");
    }
    public void enterMinSalary(String minSalary){
        sendTextToElement(waitUntilVisibilityOfElement(salaryMin,10),minSalary);
        Reporter.log("Entering min salary at "+salaryMin.toString()+" as "+minSalary);
        CustomListeners.test.log(Status.PASS,"Entering min salary as "+minSalary);
    }
    public void enterMaxSalary(String maxSalary){
        sendTextToElement(salaryMax,maxSalary);
        Reporter.log("Entering the max salary at "+salaryMax.toString()+" as "+maxSalary);
        CustomListeners.test.log(Status.PASS,"Entering the max salary as "+maxSalary);
    }
    public void selectSalaryType(String sType){
        selectByVisibleTextFromDropDown(salaryTypeDropDown,sType);
        Reporter.log("Selecting the Salary Type at "+salaryTypeDropDown.toString()+" as "+sType);
        CustomListeners.test.log(Status.PASS,"Selecting the salary type as "+sType);
    }
    public void selectJobType(String jobType){
        selectByVisibleTextFromDropDown(jobTypeDropDown,jobType);
        Reporter.log("Selecting the job type at "+jobTypeDropDown.toString()+" as "+jobType);
        CustomListeners.test.log(Status.PASS,"Selecting the job type as "+jobType);
    }
    public void clickOnFindJobsButton(){
        //currentUrlValue = gettingCurrentUrl();
        clickOnElement(findJobsBtn);
        Reporter.log("Clicking on find jobs button "+findJobsBtn.toString());
        CustomListeners.test.log(Status.PASS,"Clicking on find jobs button");
    }
}