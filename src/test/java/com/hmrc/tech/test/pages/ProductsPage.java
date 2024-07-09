package com.hmrc.tech.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void addHighestPricedItemToCart() {
        List<WebElement> items = driver.findElements(By.className("inventory_item"));
        WebElement highestPricedItem = items.stream()
                .max((item1, item2) -> {
                    double price1 = Double.parseDouble(item1.findElement(By.className("inventory_item_price")).getText().substring(1));
                    double price2 = Double.parseDouble(item2.findElement(By.className("inventory_item_price")).getText().substring(1));
                    return Double.compare(price1, price2);
                })
                .orElseThrow(() -> new RuntimeException("No items found"));

        WebElement addToCartButton = highestPricedItem.findElement(By.className("btn_inventory"));
        click(addToCartButton);
    }
}
