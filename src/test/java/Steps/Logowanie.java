package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URL;

public class Logowanie {

    WebDriver driver;

    @Given("Uzytkownik otwiera przegladarke")
    public void testUzytkownikOtwieraPrzegladarke(){
        System.out.println("Uzytkownik otworzyl przegladarke");
        System.setProperty("webdriver.chrome.driver","C:/Users/Użytkownik/Downloads/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Given("Uzytkownik wpisuje adres https:\\/\\/the-internet.herokuapp.com\\/login")
    public void uzytkownik_wpisuje_adres_https_the_internet_herokuapp_com_login(){
        System.out.println("uzytkownik wpisuje adres internetowy");
        driver.navigate().to("https://the-internet.herokuapp.com/login");
    }

    @When("Uzytkownik wpisuje poprawny username")
    public void uzytkownik_wpisuje_poprawny_username(){
        System.out.println("uzytkownik wpisuje poprawny username");
        driver.findElement(By.id("username")).sendKeys("aaa");
    }

    @When("Uzytkownik wpisuje poprawne haslo")
    public void uzytkownik_wpisuje_poprawne_haslo() {
        System.out.println("uzytkownik wpisuje poprawne haslo");
    }

    @When("Uzytkownik kilka przycisk Login")
    public void uzytkownik_kilka_przycisk_login() {
        System.out.println("uzytkownik klika przycisk Login");
    }

    @Then("Uzytkownik zostaje zalogowany")
    public void uzytkownik_zostaje_zalogowany() {
        System.out.println("uzytkownik zostal poprawnie zalogowany");
    }
}
