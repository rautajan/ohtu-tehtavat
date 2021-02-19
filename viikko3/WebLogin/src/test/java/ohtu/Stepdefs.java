package ohtu;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Stepdefs {
    //WebDriver driver = new ChromeDriver();
    WebDriver driver = new HtmlUnitDriver();
    String baseUrl = "http://localhost:4567";
    
    @Given("login is selected")
    public void loginIsSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click();   
    } 
    
    @Given("user with username {string} and with password {string} is successfully created")
    public void succesfulLoginSuccesfullyGeneratedAccount(String username, String password) {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));       
        element.click(); 
        signUpWith(username, password);
        pageHasContent("Welcome to Ohtu Application!");
        
    }
    
    @Given("user with username {string} and password {string} is tried to be created")
    public void failedUserCreation(String username, String password) {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));       
        element.click(); 
        signUpWith(username, password);
        pageHasContent("Create username and give password");
        pageHasContent("username should have at least 3 characters, password should have at least 8 characters");
    }
    
    @When("incorrect username {string} and incorrect password {string} are given")
    public void incorrectUsernameAndPasswordGiven(String username, String password) {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click();  
        logInWith(username, password);
    }
    
    @When("correct username {string} and correct password {string} are given")
    public void correctUsernameAndPasswordGiven(String username, String password) {
        logInWith(username, password);
    }
    
    
    @When("user {string} with password {string} can login to account")
    public void succesfullycreateduserCanLogin(String username, String password) {
        logInWith(username, password);
    }
    @Then("user is created and logged in")
    public void userIsCreatedAndLoggedIn() {
        pageHasContent("Ohtu Application main page");
    }
    
    @When("correct username {string} and password {string} are given")
    public void correctUsernameAndPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }    
    
    @Then("user is logged in")
    public void userIsLoggedIn() {
        pageHasContent("Ohtu Application main page");
    }    
 
    @When("correct username {string} and incorrect password {string} are given")
    public void correctUsernameAndIncorrectPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }

    @When("nonexistent username {string} and password {string} are given")
    public void nonexistentUsernameAndIncorrectPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }  
    
    @Then("user is not logged in and error message is given")
    public void userIsNotLoggedInAndErrorMessageIsGiven() {
        pageHasContent("invalid username or password");
        pageHasContent("Give your credentials to login");
    }
    
    @Then("invalid user is not logged in and error message is given")
    public void invalidUserIsNotLoggedInAndErrorMessageIsGiven() {
        pageHasContent("Give your credentials to login");
        pageHasContent("nvalid username or password");
    }

    @Given("command new user is selected")
    public void newIsSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));       
        element.click();   
    } 
    
    @When("a valid username {string} and password {string} and matching password confirmation are entered")
    public void validUsernameAndPasswordAreGiven(String username, String password) {
        signUpWith(username, password);
    }
    
    @Then("a new user is created")
    public void newUserIsCreatedAndUserIsLoggedIn() {
        pageHasContent("Welcome to Ohtu Application!");
    }
    
    @When("incorrect username {string} and valid password {string} are entered")
    public void incorrectUsernameAndValidPassword(String username, String password) {
        signUpWith(username, password);
    }
    
    @Then("user is not created and error \"username should have at least 3 characters\" is reported")
    public void errorMessageTooShortUsername() {
        pageHasContent("Create username and give password");
        pageHasContent("username should have at least 3 characters");
    }
    
    @When("correct username {string} and incorrect password {string} are entered")
    public void correctUsernameAndIncorrectPassword(String username, String password) {
        signUpWith(username, password);
    }
    
    @Then("user is not created and error \"password should have at least 8 characters\" is reported")
    public void errorMessageTooShortPassword() {
        pageHasContent("password should have at least 8 characters");
    }
    
    @When("correct username {string} and correct password {string} and unmatched pwconfirmation {string} are entered")
    public void unmatchedPassword(String username, String password, String passwordConfirmation) {
        signUpWithConfirmation(username, password, passwordConfirmation);
    }
    
    @Then("user is not created and error \"password and password confirmation do not match\" is reported")
    public void errorMessageUnmatchedPassword() {
        pageHasContent("password and password confirmation do not match");
    }
    
//    @Given("login is selected")
//    public void loginIsSelected() {
//        driver.get(baseUrl);
//        WebElement element = driver.findElement(By.linkText("login"));       
//        element.click();   
//    }  
    
    @After
    public void tearDown(){
        driver.quit();
    }
        
    /* helper methods */
 
    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }
        
    private void logInWith(String username, String password) {
        assertTrue(driver.getPageSource().contains("Give your credentials to login"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();  
    } 
    
    private void signUpWith(String username, String password) {
        assertTrue(driver.getPageSource().contains("Create username and give password"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(password);
        element = driver.findElement(By.name("signup"));
        element.submit(); 
    }
    
    private void signUpWithConfirmation(String username, String password, String passwordConfirmation) {
        assertTrue(driver.getPageSource().contains("Create username and give password"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(passwordConfirmation);
        element = driver.findElement(By.name("signup"));
        element.submit(); 
    }
}
