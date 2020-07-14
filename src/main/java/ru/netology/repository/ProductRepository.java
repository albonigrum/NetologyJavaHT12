package ru.netology.repository;

import ru.netology.domain.Product;

import java.util.ArrayList;

public class ProductRepository {
    private ArrayList<Product> products = new ArrayList<>();

    public Product[] findAll() {
        return products.toArray(new Product[0]);
    }

    public void save(Product product) {
        products.add(product);
    }

    public void removeById(long id) {
        products.removeIf(elem -> (elem.getId() == id));
    }
}
