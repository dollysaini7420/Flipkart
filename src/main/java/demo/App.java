package demo;
import java.net.MalformedURLException;


public class App {
    public void getGreeting() throws InterruptedException, MalformedURLException {
        System.setProperty("java.util.logging.config.file", "logging.properties");
        System.out.println("Hello Autmation Wizards!");
    }

    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        new App().getGreeting();
    }
}
