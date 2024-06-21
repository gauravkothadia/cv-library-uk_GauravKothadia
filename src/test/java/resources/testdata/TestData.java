package resources.testdata;

import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name = "searchCriteria")
    public Object[][] getData() {
        Object[][] data = new Object[][]{
                //|jobTitle|location|distance|salaryMin|salaryMax|salaryType|jobType|result|
                //|Tester|Harrow| up to 5 miles|30000|500000|Per annum| Permanent|Permanent Tester jobs in Harrow on the Hill|
                {"Tester", "Harrow on the Hill","5 miles","30000","500000","Per annum","Permanent","Permanent Tester jobs in Harrow on the Hill"}
        };
        return data;
    }
}
