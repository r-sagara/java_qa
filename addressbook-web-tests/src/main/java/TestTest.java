import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestTest {

    @Test
    public static void main() {
        WebDriver dr = new FirefoxDriver();

        dr.get("http://localhost/addressbook/");
        System.out.println(dr.findElement(By.xpath("//input")));
    }
}
