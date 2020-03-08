import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Zachary Cook
 *
 * Tests the RIT SWEN department web page using Selenium.
 */

public class SwenDeptInfo {
    private WebDriver driver;

    /**
     * Sets up the test.
     */
    @Before
    public void setup() {
        this.driver = new ChromeDriver();
        this.driver.get("https://www.rit.edu/");
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
     * Find a clickable element for a given by with a timeout.
     */
    private WebElement getClickableElement(By by,long timeout) {
        return new WebDriverWait(driver,timeout).until(ExpectedConditions.elementToBeClickable(by));
    }

    /**
     * Find a clickable element for a given id with a timeout.
     */
    private WebElement getClickableElementById(String id,long timeout) {
        return this.getClickableElement(By.id(id),timeout);
    }

    /**
     * Find a clickable element for a given XPath with a timeout.
     */
    private WebElement getClickableElementByXPath(String xpath,long timeout) {
        return this.getClickableElement(By.xpath(xpath),timeout);
    }
    /**
     * Runs the specified test for the assignment.
     */
    @Test
    public void assignmentTest() {
        // Navigate to the Colleges page using the home page.
        this.getClickableElementById("main-nav--link--academics",5).click();
        this.getClickableElementByXPath("//div[@class=\"dropdown-menu show\"]//div//ul//li//a[@href=\"/colleges\"]",2).click();

        // Navigate to the Golisano College of Computing and Information Sciences home page.
        WebElement computingButton = this.getClickableElementByXPath("//a[@href=\"https://www.rit.edu/computing/\"]",5);
        this.delayDriver(500);
        computingButton.click();

        // Navigate to the contact page.
        WebElement contactButton = this.getClickableElementByXPath("//ul[@block=\"rit_bootstrap_subtheme_rit_main_menu\"]//li//a[@href=\"/computing/contact\"]",5);
        String computingWebsiteUrl = this.driver.getCurrentUrl();
        this.delayDriver(500);
        contactButton.click();

        // Open the Department of Software Engineering's information.
        WebElement seDepartmentButton = this.getClickableElementByXPath("//a[contains(text(),\"Department of Software Engineering\")]",5);
        this.delayDriver(500);
        seDepartmentButton.click();

        // Output the information of the Department Chair.
        try {
            // Get the department chair's title text. If it isn't found in time, an exception is thrown and the contact information is not retrieved.
            WebElement titleElement = this.getClickableElementByXPath("//div[@class=\"card paragraph paragraph--type--accordion-item paragraph--view-mode--default is-shown\"]//div//div//article//div//div//div[text()=\"Department Chair\"]",5);

            // Get the information.
            String name = this.getClickableElementByXPath("//div[@class=\"card paragraph paragraph--type--accordion-item paragraph--view-mode--default is-shown\"]//div//div//article//div//div//div[@class=\"pb-1 pb-md-2\"]//a",1).getText();
            String email = this.getClickableElementByXPath("//div[@class=\"card paragraph paragraph--type--accordion-item paragraph--view-mode--default is-shown\"]//div//div//article//div//div//div[@class=\"pb-1 pb-md-2 directory-text-small\"]//a",1).getText();
            String title = titleElement.getText();
            String department = this.getClickableElementByXPath("//div[@class=\"card paragraph paragraph--type--accordion-item paragraph--view-mode--default is-shown\"]//div//div//article//div//div//div[@class=\"directory-department-description pb-1 pb-md-2 directory-text-small\"]",1).getText();
            String college = this.getClickableElementByXPath("//div[@class=\"card paragraph paragraph--type--accordion-item paragraph--view-mode--default is-shown\"]//div//div//article//div//div//div[@class=\"directory-college-division pb-1 pb-md-2 directory-text-small\"]",1).getText();

            // Assert the information is expected.
            Assert.assertEquals("Name is incorrect.",name,"Naveen Sharma");
            Assert.assertEquals("Email is incorrect.",email,"nxsvse@rit.edu");
            Assert.assertEquals("Title is incorrect.",title,"Department Chair");
            Assert.assertEquals("Department is incorrect.",department,"Department of Software Engineering");
            Assert.assertEquals("College is incorrect.",college,"Golisano College of Computing and Information Sciences");
            Assert.assertEquals("College URL is incorrect.",computingWebsiteUrl,"https://www.rit.edu/computing/");

            // Output the required information.
            System.out.println(name);
            System.out.println(email);
            System.out.println(title);
            System.out.println(department);
            System.out.println(college);
            System.out.println(computingWebsiteUrl);
        } catch (TimeoutException e) {
            System.out.println("Contact information not found");
        }
    }
}
