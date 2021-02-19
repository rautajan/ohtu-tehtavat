package ohtu;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import ohtu.io.*;
import ohtu.data_access.*;
import ohtu.services.*;

public class Stepdefs {
    App app;
    StubIO io;
    UserDao userDao;
    AuthenticationService auth;
    List<String> inputLines;
    
    @Before
    public void setup(){
        userDao = new InMemoryUserDao();
        auth = new AuthenticationService(userDao);
        inputLines = new ArrayList<>();      
    }
    
    @Given("^command login is selected$")
    public void commandLoginSelected() throws Throwable {
        inputLines.add("login");
        System.out.println("Given1");
        for (String line : inputLines) {
            System.out.println(line);
        }
    }

    @When("username {string} and password {string} are entered")
    public void usernameAndPasswordAreEntered(String username, String password) {
       inputLines.add(username);
       inputLines.add(password);
       
       io = new StubIO(inputLines); 
       app = new App(io, auth);
       app.run();
       System.out.println("When1");
       for (String line : inputLines) {
            System.out.println(line);
        }
    }    
    
    @Then("system will respond with {string}")
    public void systemWillRespondWith(String expectedOutput) {
        assertTrue(io.getPrints().contains(expectedOutput));
    } 
    
    @When("incorrect password {string} and username {string} are entered")
    public void IncorrectPasswordAndUsernameAreEntered(String password, String username) {
       inputLines.add(username);
       inputLines.add(password);
       
       io = new StubIO(inputLines); 
       app = new App(io, auth);
       app.run();
       System.out.println("When2");
       for (String line : inputLines) {
            System.out.println(line);
        }
    }  
    
    @Then("system will respond with this message: {string}")
    public void systemWillRespondWithThis(String expectedOutput) {
        assertTrue(io.getPrints().contains(expectedOutput));
    }
    
    @When("nonexistent username {string} and password {string} are entered")
    public void nonexistentUsernameAndPasswordAreEntered(String password, String username) {
       inputLines.add(username);
       inputLines.add(password);
       
       io = new StubIO(inputLines); 
       app = new App(io, auth);
       app.run();
       
       System.out.println("When3");
       for (String line : inputLines) {
            System.out.println(line);
        }
    } 
    
    @Then("system will respond with error message: {string}")
    public void systemWillRespondWithThisErrorMessage(String expectedOutput) {
        assertTrue(io.getPrints().contains(expectedOutput));
    }
    
    @Given("^command new is selected$")
    public void commandNewSelected() throws Throwable {
        inputLines.add("new");
    }
    
    @When("valid username {string} and password {string} are entered")
    public void validUsernameAndPasswordAreEntered(String username, String password) {
       inputLines.add(username);
       inputLines.add(password);
       
       io = new StubIO(inputLines); 
       app = new App(io, auth);
       app.run();
    } 
    
    @Given("user {string} with password {string} is created")
    public void succesfulLoginSuccesfullyGeneratedAccount(String username, String password) {
        inputLines.add("new");
        inputLines.add(username);
        inputLines.add(password);
        
    }
    
//    @Then("system will respond with this {string}")
//    public void systemWillRespondWithNewUserMessage(String expectedOutput) {
//        assertTrue(io.getPrints().contains(expectedOutput));
//    }
    
    
    
    
}
