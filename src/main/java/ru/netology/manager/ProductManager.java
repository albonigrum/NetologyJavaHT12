package ru.netology.manager;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import java.util.ArrayList;

public class ProductManager {
    private ProductRepository repository;

    ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void add(Product product) {
        repository.save(product);
    }


    public Product[] searchBy(String request) {
        ArrayList<Product> matches = new ArrayList<>();

        for (Product product : repository.findAll()) {
            if (product.matches(request))
                matches.add(product);
        }

        return matches.toArray(new Product[0]);
    }
}
