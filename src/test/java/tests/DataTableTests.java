package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import org.testng.Assert;
//import dev.failsafe.internal.util.Assert;

public class DataTableTests extends BaseTest {
    private final By SORTABLE_DATA_TABLES = By.xpath(String.format(PRECISE_TEXT_XPATH, "Sortable Data Tables"));
    private final By DUE_ELEMENTS_LOCATOR = By.xpath("//*[@id='table1']//td[4]"); 
    private final Double EXPECTED_SUM = 251.0;
    private final String CURRENCY_REGEX = "[^\\d.]";

    @Test
    public void dataTableTest() {
        driver.findElement(SORTABLE_DATA_TABLES).click();
        List<WebElement> dueList = driver.findElements(DUE_ELEMENTS_LOCATOR);
        Double actsum = 0.0;
        for(WebElement element :dueList){
        String elemenText = element.getText();
        actsum += Double.parseDouble(elemenText.replaceAll(CURRENCY_REGEX, ""));
        }
        // todo: assert due sum
        Assert.assertEquals(actsum, EXPECTED_SUM, "sum is not correct");
    }
}
