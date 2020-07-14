package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
    protected long id;
    protected String name;
    protected int price;

    public boolean matches(String text) {
        if (text.equalsIgnoreCase(""))
            return false;
        if (text.equalsIgnoreCase(name))
            return true;
        return false;
    }
}
