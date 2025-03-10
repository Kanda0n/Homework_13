package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final Product[] products;
    private int count;

    public ProductBasket() {
        this.products = new Product[5];
        this.count = 0;
    }

    public void addProduct(Product product) {
        if (count < products.length) {
            products[count] = product;
            count++;
        } else {
            System.out.println("Невозможно добавить продукт: корзина заполнена.");
        }
    }

    public int getTotalCost() {
        int totalCost = 0;
        if (count != 0) {
            for (Product product : products) {
                if (product != null) {
                    totalCost += product.getPrice();
                }
            }
        }
        return totalCost;
    }

    public void printBasket() {
        if (count == 0) {
            System.out.println("В корзине пусто.");
        } else {
            byte specialProductsCount = 0;
            for (Product product : products) {
                if (product != null) {
                    System.out.println(product);
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
        if (count != 0) {
            for (Product product : products) {
                if (product != null && product.getName().equals(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void clearBasket() {
        for (int i = 0; i < products.length; i++) {
            products[i] = null;
        }
        count = 0;
    }
}
