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
        int totalCost = 0;
        for (List<Product> products : productsMap.values()) {
            for (Product product : products) {
                totalCost += product.getPrice();
            }
        }
        return totalCost;
    }

    public void printBasket() {
        byte specialProductsCount = 0;
        if (productsMap.isEmpty()) {
            System.out.println("В корзине пусто.");
        } else {
            for (List<Product> products : productsMap.values()) {
                for (Product product : products) {
                    System.out.println(product.toString());
                    if (product.isSpecial()) {
                        specialProductsCount++;
                    }
                }
            }
            System.out.println("Итого: " + getTotalCost());
            System.out.println("Специальных товаров: " + specialProductsCount);
        }
    }

    public boolean containsProduct(String name) {
        if (productsMap.isEmpty()) {
            return false;
        } else {
            for (List<Product> products : productsMap.values()) {
                for (Product product : products) {
                    if (product != null && product.getName().equals(name)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void clearBasket() {
        productsMap.clear();
    }
}
