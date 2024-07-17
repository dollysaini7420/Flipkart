package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.internal.thread.ThreadExecutionException;

import java.beans.Transient;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

// import io.github.bonigarcia.wdm.WebDriverManager;
import demo.wrappers.Wrappers;

public class TestCases {
    ChromeDriver driver;
    // public TestCases()
    // {
    // System.out.println("Constructor: TestCases");
    // WebDriverManager.chromedriver().timeout(30).setup();
    // driver = new ChromeDriver();
    // driver.manage().window().maximize();
    // }
    // ChromeDriver driver;

    /*
     * TODO: Write your tests here with testng @Test annotation.
     * Follow `testCase01` `testCase02`... format or what is provided in
     * instructions
     */

    /*
     * Do not change the provided methods unless necessary, they will help in
     * automation and assessment
     */
    // private WebDriver driver;

    // @BeforeClass
    // public void setUp() {

    // // Setup WebDriverManager for Chrome
    // WebDriver.chromedriver().setup();
    // driver = new ChromeDriver();
    // }

    @BeforeTest
    public void startBrowser() {
        System.setProperty("java.util.logging.config.file", "logging.properties");

        // NOT NEEDED FOR SELENIUM MANAGER
        // WebDriverManager.chromedriver().timeout(30).setup();

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log");

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
    }

    @AfterTest
    public void endTest() {
        // driver.close();
        driver.quit();

    }

    @Test
    public void testCase01() throws InterruptedException {
        System.out.println("Start test case 01");
        try {
            driver.get("https://www.flipkart.com/");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
            wait.until(ExpectedConditions.urlContains("flipkart.com"));
            // boolean urlconatins = Wrappers.waitForUrlToContain("flipkart.com", 4);
            // System.out.println("URL contains 'flipkart.com': " + urlconatins);
            // click on search bar and send washingmachine
            WebElement searchbar = driver
                    .findElement(By.xpath("//input[@title='Search for Products, Brands and More']"));
            Wrappers.entertext(searchbar, "Washing Machine");
            // finding popularity tab
            WebElement popularitytab = driver.findElement(By.xpath("//div[@class='sHCOk2']/div[2]"));
            Wrappers.clickonelement(popularitytab);
        //    popularitytab.click();
        //    Thread.sleep(4000);
            // counting the no of products less than or equal to rating 4
            Wrappers.washingMachineItemCount(driver);

        } catch (Exception e) {
            e.printStackTrace();
            // If there is no rating, we skip the product
            System.out.println("Rating less than or equal to 4 not found for a product.");
        }
        System.out.println("end test case 01");

    }

    @Test
    public void testCase02() throws InterruptedException {
        System.out.println("Start test case 02");
        driver.get("https://www.flipkart.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlContains("flipkart.com"));
        // try {
        //     WebElement popup = driver.findElement(By.xpath("//span[@class='_30XB9F']"));
        //     wait.until(ExpectedConditions.visibilityOf(popup));
        //     //WebElement closeicon = driver.findElement(By.xpath("//span[@class='_30XB9F']"));
        //     popup.click();
        
        //     } catch (Exception e) {
        //     System.out.println("login popup doesnt appear");
        //     }
        Wrappers.Popup(driver);
        WebElement searchbar = driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']"));
        Wrappers.entertext(searchbar, "iPhone");
        List<WebElement> parentelemnts = driver.findElements(By.xpath("//div[@class='yKfJKb row']"));
        Wrappers.TitleandDiscountofIphone(parentelemnts,driver);
        System.out.println("end test case 02");


                    

    }

    @Test
    public void testCase03() throws InterruptedException {
        try{
        System.out.println("Start test case 03");
        driver.get("https://www.flipkart.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlContains("flipkart.com"));
        Wrappers.Popup(driver);
        WebElement searchbar = driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']"));
        Wrappers.entertext(searchbar, "Coffee Mug");
        WebElement fourstarstartIcon = driver.findElement(By.xpath("//div[contains(text(),'4')]/parent::label"));
        Wrappers.clickonelement(fourstarstartIcon);
        //fourstarstartIcon.click();
        //Thread.sleep(3000);
        Wrappers.TitleandImageUrl(driver);
        }
        catch(Exception e){
            e.printStackTrace();
        }






    }



    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // @Test
    // public void testcase01() throws InterruptedException{
    // System.out.println("Start test case 01");
    // driver.get("https://www.flipkart.com/");
    // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
    // wait.until(ExpectedConditions.urlContains("flipkart.com"));

    // WebElement searchbar = driver.findElement(By.xpath("//input[@title='Search
    // for Products, Brands and More']"));
    // searchbar.click();
    // searchbar.clear();
    // searchbar.sendKeys("Washing Machine");
    // searchbar.sendKeys(Keys.ENTER);
    // Thread.sleep(3000);
    // WebElement popularitytab =
    // driver.findElement(By.xpath("//div[@class='sHCOk2']/div[2]"));

    // //Thread.sleep(5000);

    // List<WebElement> products =
    // driver.findElements(By.xpath("//div[@class='_5OesEi']"));
    // int count = 0;
    // for(WebElement product: products){
    // try{

    // WebElement ratingelement = product.findElement(By.xpath("./span/div"));
    // Double rating = Double.parseDouble(ratingelement.getText());
    // if(rating<=4){
    // count++;
    // }

    // }
    // catch (Exception e) {
    // // If there is no rating, we skip the product
    // System.out.println("Rating less than or equal to 4 not found for a
    // product.");
    // }
    // }
    // System.out.println("No of products having rating leass than or equalt to 4
    // are: "+count);

    // System.out.println("end test case 01");
    // }

    // @Test
    // public void testcase02() throws InterruptedException {
    // System.out.println("Start test case 02");
    // driver.get("https://www.flipkart.com/");
    // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
    // wait.until(ExpectedConditions.urlContains("flipkart.com"));
    // try {
    // WebElement popup = driver.findElement(By.xpath("//span[@class='_30XB9F']"));
    // wait.until(ExpectedConditions.visibilityOf(popup));
    // // WebElement closeicon =
    // // driver.findElement(By.xpath("//span[@class='_30XB9F']"));
    // popup.click();

    // } catch (Exception e) {
    // System.out.println("login popup doesnt appear");
    // }

    // Thread.sleep(4000);
    // WebElement searchbar = driver.findElement(By.xpath("//input[@title='Search
    // for Products, Brands and More']"));
    // searchbar.click();
    // searchbar.clear();
    // searchbar.sendKeys("iPhone");
    // searchbar.sendKeys(Keys.ENTER);
    // //
    // wait.until(ExpectedConditions.urlContains("q=iphone&otracker=search&otracker1=search&marketplace"));

    // Thread.sleep(5000);
    // List<WebElement> parentelemnts =
    // driver.findElements(By.xpath("//div[@class='yKfJKb row']"));
    // int count = 0;
    // for (WebElement parent : parentelemnts) {
    // try {
    // WebElement discount =
    // parent.findElement(By.xpath("./div[2]/div[1]/div[1]/div[3]/span"));
    // String discounttext = discount.getText();
    // int n = Integer.parseInt(discounttext.replaceAll("[^0-9]", ""));
    // WebElement title = parent.findElement(By.xpath("./div[1]/div[1]"));
    // String titletext = title.getText();

    // if (n > 17) {
    // System.out.print("Title is: " + titletext);
    // System.out.println(" and discount percentage is: " + n);
    // count++;
    // }
    // } catch (Exception e) {
    // System.out.println("no product found more than 17%");

    // }

    // }
    // System.out.println("Total no of item found mor ethan 17% discount are " +
    // count);
    // System.out.println("end test case 02");

    // }

//     // @Test
//     public void testcase03() throws InterruptedException {
//         System.out.println("Start test case 03");
//         driver.get("https://www.flipkart.com/");
//         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
//         wait.until(ExpectedConditions.urlContains("flipkart.com"));

//         WebElement searchbar = driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']"));
//         searchbar.click();
//         searchbar.clear();
//         searchbar.sendKeys("Coffee Mug");
//         searchbar.sendKeys(Keys.ENTER);
//         Thread.sleep(5000);
//         WebElement fourstar = driver.findElement(By.xpath(
//                 "//*[@id='container']/div/div[3]/div[1]/div[1]/div/div/div/section[5]/div[2]/div/div[1]/div/label/div[1]"));
//         fourstar.click();
//         Thread.sleep(5000);

//         List<WebElement> cofeemugs = driver.findElements(By.xpath("//div[@class='slAVV4']"));

//     }
 }
