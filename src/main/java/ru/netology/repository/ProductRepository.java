package ru.netology.repository;

import ru.netology.domain.Product;

public class ProductRepository {
    private Product[] products = new Product[0];

    public Product[] findAll() {
        return products;
    }

    public void save(Product product) {
        Product[] tmp = new Product[products.length + 1];
        System.arraycopy(products, 0, tmp, 0, products.length);
        tmp[products.length] = product;
        products = tmp;
    }

/*
    public void removeById(long id) {
        boolean isElemExist = false;
        for (Product product : products)
            if (product.getId() == id) {
                isElemExist = true;
                break;
            }
        if (isElemExist) {
            Product[] tmp = new Product[products.length - 1];
            for (int i = 0, j = 0; i < products.length; ++i) {
                if (products[i].getId() != id)
                    tmp[j++] = products[i];
            }
            products = tmp;
        }
    }
*/
}
