/**
 * Zachary Cook
 *
 * Tests the Tiger Center web page using Selenium.
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TigerCenterClass {
    private WebDriver driver;

    /**
     * Sets up the test.
     */
    @Before
    public void setup() {
        this.driver = new ChromeDriver();
        this.driver.get("https://tigercenter.rit.edu/tigerCenterApp/landing");
    }

    /**
     * Tears down the test.
     */
    @After
    public void teardown() {
        this.driver.close();
    }

    /**
     * Delays the driver for set amount of milliseconds.
     */
    private void delayDriver(long milliseconds) {
        synchronized (this.driver) {
            try {
                this.driver.wait(milliseconds);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Find an element for a given by with a timeout.
     */
    private WebElement getElement(By by,long timeout) {
        return new WebDriverWait(driver,timeout).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    /**
     * Find a element for a given XPath with a timeout.
     */
    private WebElement getElementByXPath(String xpath,long timeout) {
        return this.getElement(By.xpath(xpath),timeout);
    }

    /**
     * Find a clickable element for a given by with a timeout.
     */
    private WebElement getClickableElement(By by,long timeout) {
        return new WebDriverWait(driver,timeout).until(ExpectedConditions.elementToBeClickable(by));
    }

    /**
     * Find a clickable element for a given XPath with a timeout.
     */
    private WebElement getClickableElementByXPath(String xpath,long timeout) {
        return this.getClickableElement(By.xpath(xpath),timeout);
    }

    /**
     * Outputs the information for a course code.
     * Assumes the course to be exist and the section to be unique.
     * No assertions are done since it isn't in the instructions to run assertions
     */
    private void outputClassInformation(String classCode,String term) {
        // Navigate to the class search page.
        this.getClickableElementByXPath("//div[@class=\"row\"]//a[@href=\"/tigerCenterApp/api/class-search\"]",5).click();

        // Search for the class by setting the term and course code.
        // Assumes to show 1 course since a section is given.
        new Select(this.getElementByXPath("//select[@name=\"termSelector\"]",5)).selectByVisibleText(term);
        WebElement courseSearchBox = this.getElementByXPath("//input[@type=\"search\"]",2);
        courseSearchBox.clear();
        courseSearchBox.sendKeys(classCode);
        this.getClickableElementByXPath("//button[@class=\"classSearchSearchButton ng-star-inserted\"]",2).click();

        // Output the name of the course.
        System.out.println("Class name from header: " + this.getElementByXPath("//span[@class=\"classSearchResultsDisplayName\"]",5).getText());

        // Open the class details and wait for the first element with information.
        this.getClickableElementByXPath("//div[@class=\"row classSearchDivHover\"]",1).click();
        this.getElementByXPath("//span[@class=\"classSearchExpandedDetailsBodyText classSearchNoPaddingLeftRight col-xs-12 subjectText addPadding\"]",5);

        // Output the remaining required information.
        for (WebElement element : driver.findElements(By.xpath("//div[@id=\"detailsContainer\"]//div//div//span"))) {
            System.out.println(element.getText());
        }
    }

    /**
     * Runs the specified test for the assignment.
     * Uses the course SWEN-352 section 01.
     */
    @Test
    public void assignmentTest_SWEN_352_01() {
        outputClassInformation("SWEN 352 01","2019-20 Spring (2195)");
    }

    /**
     * Runs the specified test for the assignment.
     * Uses the course SWEN-261 section 01.
     */
    @Test
    public void assignmentTest_SWEN_261_01() {
        outputClassInformation("SWEN 261 01","2019-20 Spring (2195)");
    }

    /**
     * Runs the specified test for the assignment.
     * Uses the course SWEN-261 section 01.
     */
    @Test
    public void assignmentTest_SWEN_262_01() {
        outputClassInformation("SWEN 262 01","2019-20 Spring (2195)");
    }

    /**
     * Runs the specified test for the assignment.
     * Uses the course SWEN-444 section 02 (section 01 doesn't exist).
     */
    @Test
    public void assignmentTest_SWEN_444_01() {
        outputClassInformation("SWEN 444 02","2019-20 Spring (2195)");
    }
}
