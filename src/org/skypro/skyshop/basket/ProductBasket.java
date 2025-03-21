package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

public class ProductBasket {
    private final List<Product> products;

    public ProductBasket() {
        this.products = new LinkedList<>();
    }

    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Продукт не может быть null.");
        }
        products.add(product);
    }

    public List<Product> removeProductsByName(String name) {
        List<Product> removedProducts = new LinkedList<>();
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().contains(name)) {
                removedProducts.add(product);
                iterator.remove();
            }
        }
        return removedProducts;
    }

    public int getTotalCost() {
        return products.stream().mapToInt(Product::getPrice).sum();
    }

    public void printBasket() {
        byte specialProductsCount = 0;
        if (products.isEmpty()) {
            System.out.println("В корзине пусто.");
        } else {
            products.forEach(product -> System.out.println(product.toString()));
            specialProductsCount = (byte) products.stream().filter(Product::isSpecial).count();
        }
        System.out.println("Итого: " + getTotalCost());
        System.out.println("Специальных товаров: " + specialProductsCount);
    }

    public boolean containsProduct(String name) {
        if (products.isEmpty()) {
            return false;
        } else {
            for (Product product : products) {
                if (product != null && product.getName().equals(name)) {
                    return true;
                }
            }
        }
        return false;
    }

        public void clearBasket () {
           products.clear();
        }
    }
