package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductRepository productRepository = new ProductRepository();
    ProductManager productManager = new ProductManager(productRepository);

    private final Product product1 = new Product(1, "product1", 1);
    private final Product product21 = new Book(2, "book1", 2, "author1");
    private final Product product22 = new Book(4, "book2", 2, "author1");
    private final Product product3 = new Smartphone(3, "smartphone1", 3, "manufacturer1");
    private final Book book1 = new Book(5, "book3", 2, "author1");
    private final Smartphone smartphone1 = new Smartphone(6, "smartphone2", 2, "manufacturer2");

    @BeforeEach
    void setUp() {
        productManager.add(product1);
        productManager.add(product21);
        productManager.add(product22);
        productManager.add(product3);
        productManager.add(book1);
        productManager.add(smartphone1);
    }

    @Test
    void shouldSearchByIfRequestEmpty() {
        String request = "";

        Product[] expected = {};
        Product[] actual = productManager.searchBy(request);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByByNameProduct() {
        String request = "product1";

        Product[] expected = {product1};
        Product[] actual = productManager.searchBy(request);

        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldSearchByByNameBook() {
        String request = "book3";

        Product[] expected = {book1};
        Product[] actual = productManager.searchBy(request);

        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldSearchByByNameSmartphone() {
        String request = "smartphone2";

        Product[] expected = {smartphone1};
        Product[] actual = productManager.searchBy(request);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByIfNoElemInRepository() {
        String request = "mustn't find anything";

        Product[] expected = {};
        Product[] actual = productManager.searchBy(request);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByIfOneElemInRepository() {
        String request = "manufacturer1";

        Product[] expected = {product3};
        Product[] actual = productManager.searchBy(request);


        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldSearchByIfMoreThenOneElemInRepository() {
        String request = "author1";

        Product[] expected = {product21, product22, book1};
        Product[] actual = productManager.searchBy(request);

        Set<Product> expectedSet = new HashSet<>(Arrays.asList(expected));
        Set<Product> actualSet = new HashSet<>(Arrays.asList(actual));

        assertEquals(expectedSet, actualSet);
    }


}