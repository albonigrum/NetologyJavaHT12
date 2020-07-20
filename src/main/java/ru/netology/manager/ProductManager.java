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
        Product[] arrayMatches = new Product[0];

        for (Product product : repository.findAll()) {
            if (product.matches(request)) {
                Product[] tmp = new Product[arrayMatches.length + 1];
                System.arraycopy(arrayMatches, 0, tmp, 0, arrayMatches.length);
                tmp[arrayMatches.length] = product;
                arrayMatches = tmp;
            }
        }

        return arrayMatches;
    }
}
