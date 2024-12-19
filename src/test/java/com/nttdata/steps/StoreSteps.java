package com.nttdata.steps;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import com.nttdata.page.StorePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class StoreSteps {
    private WebDriver driver;
    public StoreSteps(WebDriver driver){
        this.driver = driver;
    }

    public void loginpage() {
        this.driver.findElement(StorePage.login).click();
    }
    public void typeUser(String usuario){
        WebElement userInputElement = driver.findElement(StorePage.userInput);
        userInputElement.sendKeys(usuario);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(StorePage.loginButton));
    }
    public void typePassword(String contrasena){
        this.driver.findElement(StorePage.passInput).sendKeys(contrasena);
    }
    public void login(){
        this.driver.findElement(StorePage.loginButton).click();
    }
    public String getName(){
        return this.driver.findElement(StorePage.nombre).getText();
    }

    public void goToMen(String categoria, String subcategoria) {
        WebElement mainMenu = driver.findElement(StorePage.clothes);
        if(categoria.equals(mainMenu.getText())){
            mainMenu.click();
            WebElement subMenu = driver.findElement(StorePage.men);
            if(subcategoria.equals(subMenu.getText())){
                subMenu.click();
            }
        }
    }

    public void agregarProductos(int cantidad) {
        this.driver.findElement(StorePage.product).click();
        this.driver.findElement((StorePage.quantity)).click();
        this.driver.findElement((StorePage.buttonSubmit)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(StorePage.confirmProduct));
    }

    public String validarProductoAgregado() {
        return this.driver.findElement(StorePage.confirmProduct).getText();
    }

    public String validarPrecio() {
        return this.driver.findElement(StorePage.totalPrice).getText();
    }

    public void finalizarCompra() {
        this.driver.findElement(StorePage.finishBuy).click();
    }

    public String validarTitulo() {
        return this.driver.getTitle();
    }

    public String validarPrecioFinal() {
        return this.driver.findElement(StorePage.total).getText();
    }
}
