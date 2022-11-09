package Steps;

import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URL;

public class Logowanie {

    static WebDriver driver;

    @BeforeAll
    public static void setDriver(){
        System.out.println("Uruchomienie raz przed wszystkimi scenariuszami testowymi");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Before
    public void before(){
        System.out.println("Uruchomoenie przed kazdym scenariuszem testowym");
    }

    @Given("Uzytkownik otwiera przegladarke")
    public void testUzytkownikOtwieraPrzegladarke(){
        System.out.println("Uzytkownik otworzyl przegladarke");
        //System.setProperty("webdriver.chrome.driver","C:/Users/Użytkownik/Downloads/chromedriver.exe");
        //driver = new ChromeDriver();
        //driver.manage().window().maximize();
    }

    @Given("Uzytkownik wpisuje adres https:\\/\\/the-internet.herokuapp.com\\/login")
    public void uzytkownik_wpisuje_adres_https_the_internet_herokuapp_com_login(){
        System.out.println("uzytkownik wpisuje adres internetowy");
        driver.navigate().to("https://the-internet.herokuapp.com/login");
    }

    //Given Uzytkownik wpisuje adres "https://the-internet.herokuapp.com/login"
    @Given("Uzytkownik wpisuje adres {string}")
    public void UzytkownikWpisujeAdres(String url){
        driver.navigate().to(url);
    }
    @When("Uzytkownik wpisuje {string} username")
    public void Uzytkownik_wpisuej_w_pole_username(String nazwaUzytkownika) {
        driver.findElement(By.id("username")).sendKeys(nazwaUzytkownika);
    }
    @When("Uzytkownik wpisuje {string} w pole password")
    public void uzytkownik_wpisuje_w_pole_password(String hasloUzytkownika) {
        driver.findElement(By.id("password")).sendKeys(hasloUzytkownika);
    }
    @When("Uzytkownik wpisuje poprawny username")
    public void uzytkownik_wpisuje_poprawny_username(){
        System.out.println("uzytkownik wpisuje poprawny username");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
    }

    @When("Uzytkownik wpisuje poprawne haslo")
    public void uzytkownik_wpisuje_poprawne_haslo() {
        System.out.println("uzytkownik wpisuje poprawne haslo");
        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.sendKeys("SuperSecretPassword!");
        //driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
    }

    @When("Uzytkownik kilka przycisk Login")
    public void uzytkownik_kilka_przycisk_login() {
        System.out.println("uzytkownik klika przycisk Login");
        driver.findElement(By.tagName("button")).click();
    }
    @When("Uzytkownik wpisuje niepoprawne haslo")
    public void uzytkownik_wpisuje_niepoprawne_haslo() {
        System.out.println("uzytkownik wpisuje niepoprawne haslo");
        driver.findElement(By.id("password")).sendKeys("dupadupa");
    }
    @Then("Uzytkownik nie zostaje zalogowany")
    public void uzytkownik_nie_zostaje_zalogowany() {
        System.out.println("uzytkownik nie zostal poprawnie zalogowany");
        Assert.assertNotEquals("https://the-internet.herokuapp.com/secure",driver.getCurrentUrl());
        //driver.close();
    }
    @Then("Uzytkownik zostaje zalogowany")
    public void uzytkownik_zostaje_zalogowany() {
        System.out.println("uzytkownik zostal poprawnie zalogowany");
        Assert.assertEquals("https://the-internet.herokuapp.com/secure",driver.getCurrentUrl());
        //driver.close();
    }

    @When("^Uzytkownik wpisuje (.+) username$")
    public void uzytkownik_wpisuje_username(String nazwauzytkownika) {
    }

    @And("^Uzytkownik wpisuje (.+) w pole password$")
    public void uzytkownik_wpisuje_w_pole_password2(String haslo) {
    }

    @AfterAll
    public static void tearDown(){
        driver.close();
    }
}
