package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        System.out.println("HomeWork №13");
        Product product1 = new SimpleProduct("Рис", 120);
        Product product2 = new SimpleProduct("Гречка", 60);
        Product product3 = new DiscountedProduct("Кола", 100, 20);
        Product product4 = new FixPriceProduct("Морковь");
        Product product5 = new SimpleProduct("Петрушка", 20);
        Product product6 = new DiscountedProduct("Чай", 150, 10);

        ProductBasket basket = new ProductBasket();

        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);
        basket.addProduct(product4);
        basket.addProduct(product5);
        basket.addProduct(product6);

        System.out.println("Содержимое корзины:");
        basket.printBasket();

        System.out.println("Общая стоимость корзины: " + basket.getTotalCost());

        System.out.println("Есть ли в корзине Морковь? " + basket.containsProduct("Морковь"));

        System.out.println("Есть ли в корзине Кофе? " + basket.containsProduct("Кофе"));

        basket.clearBasket();

        System.out.println("Содержимое корзины после очистки:");
        basket.printBasket();

        System.out.println("Общая стоимость пустой корзины: " + basket.getTotalCost());

        System.out.println("Есть ли в корзине Гречка? " + basket.containsProduct("Гречка"));
    }
}