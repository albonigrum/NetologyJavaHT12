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

    private boolean matches(Product product, String text) {
        if (text.isEmpty())
            return false;
        if (product.getName().equalsIgnoreCase(text))
            return true;
        if (product instanceof Book && ((Book) product).getAuthor().equalsIgnoreCase(text))
            return true;
        if (product instanceof Smartphone && ((Smartphone) product).getManufacturer().equalsIgnoreCase(text))
            return true;
        return false;

    }

    public Product[] searchBy(String request) {
        ArrayList<Product> matches = new ArrayList<>();

        for (Product product : repository.findAll()) {
            if (matches(product, request))
                matches.add(product);
        }

        return matches.toArray(new Product[0]);
    }
}
