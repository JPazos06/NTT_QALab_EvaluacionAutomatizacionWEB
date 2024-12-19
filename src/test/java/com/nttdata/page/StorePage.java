package com.nttdata.page;

import org.openqa.selenium.By;

public class StorePage {
    public static By login = By.xpath("//div[@class=\"user-info\"]/a");
    public static By userInput = By.id("field-email");
    public static By passInput = By.id("field-password");
    public static By loginButton = By.id("submit-login");
    public static By nombre = By.xpath("//div[@class=\"user-info\"]/a[@class=\"account\"]/span");
    public static By clothes = By.xpath("//li[@id=\"category-3\"]/a");
    public static By men = By.xpath("//ul[@class=\"category-sub-menu\"]/li/a");
    public static By product = By.xpath("//div[@id=\"js-product-list\"]/div/div/article/div/div[2]/h2/a");
    public static By quantity = By.xpath("//form[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[1]/div/span[3]/button[1]");
    public static By buttonSubmit = By.xpath("//form[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button");
    public static By confirmProduct = By.id("myModalLabel");
    public static By price = By.xpath("//div[@class=\"col-md-6\"]/p");
    public static By totalPrice = By.xpath("//p[@class=\"product-total\"]/span[2]");
    public static By finishBuy = By.xpath("//div[@class=\"cart-content-btn\"]/a");
    public static By title = By.xpath("/html/head/title");
    public static By total = By.xpath("//div[@class=\"cart-summary-line cart-total\"]/span[2]");
    public static By finish = By.xpath("//div[@class=\"text-sm-center\"]/a");
}
