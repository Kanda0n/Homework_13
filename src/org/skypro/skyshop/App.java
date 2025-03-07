package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

public class App {
    public static void main(String[] args) {
        System.out.println("HomeWork №15");
        Product product1 = new SimpleProduct("Рис", 120);
        Product product2 = new SimpleProduct("Гречка", 60);
        Product product3 = new DiscountedProduct("Кола", 100, 20);
        Product product4 = new FixPriceProduct("Морковь");
        Product product5 = new SimpleProduct("Петрушка", 20);
        Product product6 = new DiscountedProduct("Чай", 150, 10);

        Article article1 = new Article("Как готовить гречку", "Гречку нужно варить 20 минут.");
        Article article2 = new Article("История Кока-Колы", "Кока-Кола была изобретена в 1886 году.");

        ProductBasket basket = new ProductBasket();

        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);
        basket.addProduct(product4);
        basket.addProduct(product5);
        basket.addProduct(product6);

        SearchEngine searchEngine = new SearchEngine(10);

        searchEngine.add(product1);
        searchEngine.add(product2);
        searchEngine.add(product3);
        searchEngine.add(product4);
        searchEngine.add(product5);
        searchEngine.add(product6);
        searchEngine.add(article1);
        searchEngine.add(article2);

        System.out.println("Результаты поиска по запросу 'гречк':");
        Searchable[] results1 = searchEngine.search("гречк");
        printSearchResults(results1);

        System.out.println("\nРезультаты поиска по запросу 'Кола':");
        Searchable[] results2 = searchEngine.search("Кола");
        printSearchResults(results2);

        System.out.println("\nРезультаты поиска по запросу 'история':");
        Searchable[] results3 = searchEngine.search("история");
        printSearchResults(results3);

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

    private static void printSearchResults(Searchable[] results) {
        for (Searchable result : results) {
            if (result != null) {
                System.out.println(result.getStringRepresentation());
            }
        }
    }
}