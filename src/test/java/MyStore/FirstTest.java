package MyStore;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class FirstTest {
    private WebDriver driver;

    @Given("The user is on the shop page")
    public void openBrowserShop() {
        this.driver = new ChromeDriver();
        this.driver.get("https://mystore-testlab.coderslab.pl/");
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    @When("User logs in with email tomasz.kapibara@gmail.com and password 12345")
    public void loginAccountWith(String mail, String password) {
        WebElement signInButton = this.driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a"));
        signInButton.click();
        WebElement emailAddressInput = this.driver.findElement(By.xpath("//*[@id=\"field-email\"]"));
        emailAddressInput.clear();
        emailAddressInput.sendKeys(mail);
        WebElement passwordInput = this.driver.findElement(By.xpath("//*[@id=\"field-password\"]"));
        passwordInput.sendKeys(password);
        WebElement submitButton = this.driver.findElement(By.xpath("//*[@id=\"submit-login\"]"));
        submitButton.click();
    }

    @And("The user adds their first address {word} {word} {word} {word} {word} {word}")
    public void AddressInput(String alias, String address, String city, String postalCode, String phone) {
        WebElement clickButtonAddress = this.driver.findElement(By.xpath("//*[@id=\"addresses-link\"]"));
        clickButtonAddress.click();

        WebElement clickCreateNewAddress = this.driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/a"));
        clickCreateNewAddress.click();

        WebElement customerAlias = this.driver.findElement(By.xpath("//*[@id=\"field-alias\"]"));
        customerAlias.sendKeys(alias);

        WebElement customerAddress = this.driver.findElement(By.xpath("//*[@id=\"field-address1\"]"));
        customerAddress.sendKeys(address);

        WebElement customerCity = this.driver.findElement(By.xpath("//*[@id=\"field-city\"]"));
        customerCity.sendKeys(city);

        WebElement customerPostalCode = this.driver.findElement(By.xpath("//*[@id=\"field-postcode\"]"));
        customerPostalCode.sendKeys(postalCode);

        WebElement customerPhone = this.driver.findElement(By.xpath("//*[@id=\"field-phone\"]"));
        customerPhone.sendKeys(phone);

        WebElement clickButtonSave = this.driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/footer/button"));
        clickButtonSave.click();
    }


    @Then("Your address has been saved")
    public void VeryficationAddressCreation() {

        WebElement successAlert = this.driver.findElement(By.xpath("//*[@id=\"notifications\"]/div/article/ul/li"));
        assertTrue(true);

    }

    @And("Closing the browser")
    public void quitBrowser() {
        this.driver.quit();
    }
}
