package com.udacity.jwdnd.cl.review;

import com.udacity.jwdnd.cl.review.model.ChatMessage;
import com.udacity.jwdnd.cl.review.object.ChatPage;
import com.udacity.jwdnd.cl.review.object.LoginPage;
import com.udacity.jwdnd.cl.review.object.SignupPage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ReviewApplicationTest {

    @LocalServerPort
    public int port;
    public static WebDriver driver;
    public String baseURL;

    @BeforeAll
    public static void beforeAll() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @BeforeEach
    public void beforeEach() {
        baseURL = baseURL = "http://localhost:" + port;
    }
    @AfterAll
    public static void afterAll() {
        driver.quit();
        driver = null;
    }

    @Test
    //Test User, Signup, Login, SubmitButton
    public void test() {
        String username = "testUserName";
        String password = "superstrongpassword";
        String messageText = "Hello!";

        driver.get(baseURL + "/signup");

        SignupPage signupPage = new SignupPage(driver);
        signupPage.signup("Quan", "Le", username, password);

        driver.get(baseURL + "/login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        ChatPage chatPage = new ChatPage(driver);
        chatPage.sendChatMessage(messageText);

        ChatMessage sentMessage = chatPage.getFirstMessage();

        assertEquals(username, sentMessage.getUsername());
        assertEquals(messageText, sentMessage.getMessageText());
    }
}