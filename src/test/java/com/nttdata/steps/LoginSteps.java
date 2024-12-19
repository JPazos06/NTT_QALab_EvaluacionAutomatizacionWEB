package com.nttdata.steps;

import com.nttdata.page.StorePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginSteps {
    private WebDriver driver;
    public LoginSteps(WebDriver driver){
        this.driver = driver;
    }

    public void typeUser(String user) {
        WebElement userInputElement = driver.findElement(StorePage.userInput);
        userInputElement.sendKeys(user);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(StorePage.loginButton));
    }

    public void typePassword(String password) {
        this.driver.findElement(StorePage.passInput).sendKeys(password);
    }

    public void login() {
        this.driver.findElement(StorePage.loginButton).click();
    }

}
