import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StreamsTest1 {

    @Test
    public void testWOStreamsAPI() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/");

        // fetch longest text link starting with F
        List<WebElement> links = driver.findElements(By.tagName("a"));
        List<String> linkTexts = new ArrayList<>();
        for (int i = 0; i < links.size(); i++) {
            linkTexts.add(links.get(i).getText());
        }

        List<String> linksF = new ArrayList<>();
        for (int i = 0; i < linkTexts.size(); i++) {
            if (linkTexts.get(i).startsWith("F"))
                linksF.add(linkTexts.get(i));
        }

        int max = 0;
        int index = -1;
        for (int i = 0; i < linksF.size(); i++) {
            if (linksF.get(i).length() > max) {
                max = linksF.get(i).length();
                index = i;
            }
        }

        System.out.printf("Longest link starting with F is %s\n", linksF.get(index));
        driver.close();
    }

    @Test
    public void testStreamsAPI() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/");

        // fetch longest text link starting with F
        String max = driver.findElements(By.tagName("a")).stream()
                .map(WebElement::getText)
                .filter(s -> s.startsWith("F"))
                .max(Comparator.comparingInt(String::length))
                .get();

        System.out.printf("Longest link starting with F is %s\n", max);
        driver.close();
    }
}
