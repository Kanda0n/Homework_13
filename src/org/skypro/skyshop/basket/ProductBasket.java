package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;


public class ProductBasket {
    private final Map<String, List<Product>> productsMap;

    public ProductBasket() {
        this.productsMap = new HashMap<>();
    }

    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Продукт не может быть null.");
        }
        List<Product> products = productsMap.getOrDefault(product.getName(), new LinkedList<>());
        products.add(product);
        productsMap.put(product.getName(), products);

    }

    public List<Product> removeProductsByName(String name) {
        List<Product> removedProducts = productsMap.remove(name);
        return removedProducts != null ? removedProducts : new LinkedList<>();
    }

    public int getTotalCost() {
        if (productsMap.isEmpty()) {
            return 0;
        }
        return productsMap.values().stream()
                .flatMap(Collection::stream)
                .mapToInt(Product::getPrice)
                .sum();
    }

    public void printBasket() {
        if (productsMap.isEmpty()) {
            System.out.println("В корзине пусто.");
            return;
        }
        productsMap.values().stream()
                .flatMap(Collection::stream)
                .forEach(product -> System.out.println(product.getStringRepresentation()));

        System.out.println("Итого: " + getTotalCost());
        System.out.println("Специальных товаров: " + getSpecialCount());
    }

    public boolean containsProduct(String name) {
        return !productsMap.isEmpty() &&
                productsMap.values().stream()
                        .flatMap(Collection::stream)
                        .anyMatch(p -> p != null && p.getName().equals(name));
    }

    private long getSpecialCount() {
        return productsMap.values().stream()
                .flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
    }

    public void clearBasket() {
        productsMap.clear();
    }
}
