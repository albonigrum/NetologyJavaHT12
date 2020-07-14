package ru.netology.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Book extends Product {
    private String author;

    public Book() {
        super();
    }

    public Book(long id, String name, int price, String author) {
        super(id, name, price);
        this.author = author;
    }

    @Override
    public boolean matches(String text) {
        if (super.matches(text))
            return true;
        if (text.equalsIgnoreCase(author))
            return true;
        return false;
    }
}
