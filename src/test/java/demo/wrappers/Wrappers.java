package demo.wrappers;
import java.util.Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Wrappers {
    //private static Object[] argument;
    private static WebDriver driver;

    public Wrappers(WebDriver driver) {
        this.driver = driver;
    }

    public static boolean entertext(WebElement element, String text){
     try{  
        element.click();
        element.clear();
        element.sendKeys(text);
        element.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        return true;
     } catch(Exception e){
        e.printStackTrace();
        return false;
     }
    }

    public static boolean waitForUrlToContain(String urlPart, int timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            wait.until(ExpectedConditions.urlContains(urlPart));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean clickonelement(WebElement element){
        try{
            // JavascriptExecutor js = (JavascriptExecutor) driver;
            //     js.executeScript("arguments[0].scrollIntoView(true);", element);
            //     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            //     wait.until(ExpectedConditions.elementToBeClickable(element));
            //     element.click();
            //     return true;
            
            
            
            
            
            
            element.click();
            Thread.sleep(4000);
             return true;

        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public static int washingMachineItemCount(WebDriver driver){
        
            List<WebElement> products = driver.findElements(By.xpath("//div[@class='_5OesEi']"));
        int count = 0;
        for(WebElement product: products){
          try{  
            
            WebElement ratingelement = product.findElement(By.xpath("./span/div"));
            Double rating = Double.parseDouble(ratingelement.getText());
            if(rating<=4){
                count++;
            }

            
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("0 products are found");

        }
    }
    if (count == 0) {
        System.out.println("0 products are found with ratings <= 4.");
    }
    return count;

    }

    public static void TitleandDiscountofIphone(List<WebElement> parentelemnts,WebDriver driver){
       // List<WebElement> parentelemnts = driver.findElements(By.xpath("//div[@class='yKfJKb row']"));
    int count = 0;
    for (WebElement parent : parentelemnts) {
    try {
    WebElement discount =
    parent.findElement(By.xpath("./div[2]/div[1]/div[1]/div[3]/span"));
    String discounttext = discount.getText();
    int n = Integer.parseInt(discounttext.replaceAll("[^0-9]", ""));
    WebElement title = parent.findElement(By.xpath("./div[1]/div[1]"));
    String titletext = title.getText();
//checking discount percentage more than 17 and counting them
    if (n > 17) {
    System.out.print("Title is: " + titletext);
    System.out.println(" and discount percentage is: " + n);
    count++;
    }
    } catch (Exception e) {
        e.printStackTrace();
    System.out.println("no product found more than 17%");

    }

    }
    System.out.println("Total no of item found mor ethan 17% discount are " +
    count);
   
    }

    public static void Popup(WebDriver driver){
        try {
            WebElement popup = driver.findElement(By.xpath("//span[@class='_30XB9F']"));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(popup));
            //WebElement closeicon = driver.findElement(By.xpath("//span[@class='_30XB9F']"));
            popup.click();
        
            } catch (Exception e) {
            System.out.println("login popup doesnt appear");
            }
    }
    public static String getText(WebElement element) {
        return element.getText();
    }

    public static int extractNumber(String str) {
        StringBuilder number = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                number.append(c);
            }
        }
        if (number.length() > 0) {
            return Integer.parseInt(number.toString());
        } else {
            throw new IllegalArgumentException("No number found in the string");
        }
    }


    public static void TitleandImageUrl(WebDriver driver) throws InterruptedException{
        // Extract product details (title, image URL, and number of reviews)
        List<WebElement> productTitles = new ArrayList<>();
        List<WebElement> productImages = new ArrayList<>();
        List<Integer> productReviews = new ArrayList<>();

        
        List <WebElement> Products = driver.findElements(By.xpath("//div[@class='slAVV4']"));
        for (WebElement product : Products) {
            

            WebElement titleElement = product.findElement(By.xpath(".//a[@class='wjcEIp']"));
            WebElement imageElement = product.findElement(By.xpath(".//img"));
            WebElement reviewsElement = product.findElement(By.xpath(".//span[@class='Wphh3N']"));

            productTitles.add(titleElement);
            productImages.add(imageElement);
            productReviews.add(Wrappers.extractNumber(Wrappers.getText(reviewsElement)));
        }

        // Sort products by number of reviews in descending order
        List<Integer> sortedIndices = new ArrayList<>();
        for (int i = 0; i < productReviews.size(); i++) {
            sortedIndices.add(i);
        }
        sortedIndices.sort(Comparator.comparingInt(productReviews::get).reversed());

        // Print the title and image URL of the top 5 products
        for (int i = 0; i < 5; i++) {
            int index = sortedIndices.get(i);
            System.out.println("Title: " + Wrappers.getText(productTitles.get(index)));
            System.out.println("Image URL: " + productImages.get(index).getAttribute("src"));
        }

        Thread.sleep(5000);


        
        }

        // public static boolean clickonelementfourstar(WebElement element,WebDriver driver){
        //     try{
        //         JavascriptExecutor js = (JavascriptExecutor) driver;
        //     js.executeScript("arguments[0].scrollIntoView(true);", element);
        //     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //     wait.until(ExpectedConditions.elementToBeClickable(element));
        //     element.click();
        //     return true;
    
        //     }
        //     catch(Exception e){
        //         e.printStackTrace();
        //         return false;
        //     }
        // }


    }



    



    
        
    

        
    
        

           
            

         
        
        
        
        
    







