package Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class YTMusicSteps {
    WebDriver driver;
    @Given("I Open browser")
    public void iOpenBrowser() {
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        System.setProperty("webdriver.chrome.driver", dir + "/src/test/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @And("Open website Youtube Music")
    public void openWebsiteYoutubeMusice() throws InterruptedException {
        driver.get("https://music.youtube.com/");
        Thread.sleep(1000);
    }

    @When("I input valid username and password")
    public void iInputValidUsernameAndPassword() throws InterruptedException{
        driver.findElement(By.id("identifierId")).sendKeys("yttestefishery");
        driver.findElement(By.id("identifierNext")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("password")).sendKeys("Davin123");
        driver.findElement(By.id("passwordNext")).click();
    }

    @Then("I success login to Youtube Music")
    public void iSuccessLoginToYoutubeMusic() throws InterruptedException {
        Thread.sleep(10000);
        driver.findElement(By.cssSelector("tp-yt-paper-icon-button.ytmusic-settings-button")).click();
        Thread.sleep(10000);
//        WebElement titleEmail = driver.findElement(By.xpath("//yt-formatted-string[@id='email']"));
        WebElement titleEmail1 = driver.findElement(By.cssSelector("#email.ytd-active-account-header-renderer"));
//        System.out.println("current email = " +titleEmail.getText());
        System.out.println("current email 1= " +titleEmail1.getText());
//        Assert.assertEquals(titleEmail.getText(), "yttestefishery@gmail.com");
        Assert.assertEquals(titleEmail1.getText(), "yttestefishery@gmail.com");

    }

    @When("I search {string}")
    public void iSearch(String searchValue) throws InterruptedException{
        driver.findElement(By.cssSelector("tp-yt-iron-icon.tp-yt-paper-icon-button")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//input[@id='input']")).sendKeys(searchValue + "\n");
        Thread.sleep(10000);

    }

    @Then("Showing result related with {string}")
    public void showingResultRelatedWith(String result) {
//        driver.findElement(By.cssSelector(".yt-simple-endpoint.ytmusic-responsive-list-item-renderer")).isDisplayed();
        WebElement hasilCari = driver.findElement(By.cssSelector("a.yt-simple-endpoint.style-scope.ytmusic-responsive-list-item-renderer"));
        System.out.println(hasilCari.getAttribute("aria-label"));
        Assert.assertEquals(hasilCari.getAttribute("aria-label"), result);
    }

    @When("I click play")
    public void iClickPlay() {
        driver.findElement(By.cssSelector("yt-icon.icon.style-scope.ytmusic-play-button-renderer")).click();

    }

    @Then("Playing a random music")
    public void playingAMusic() throws InterruptedException {
        driver.findElement(By.cssSelector("ytmusic-player-bar.style-scope.ytmusic-app")).isDisplayed();
        Thread.sleep(20000);
        driver.quit();
    }

    @And("Click Sign in")
    public void clickSignIn() {
        driver.findElement(By.cssSelector(".sign-in-link.ytmusic-nav-bar")).click();
    }

}
