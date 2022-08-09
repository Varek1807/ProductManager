package ru.netology.Book.service;

public class ManagerProduct {
    Repository repository;

    public ManagerProduct(Repository repository) {
        this.repository = repository;

    }

    public void add(Product product) {
        repository.add(product);
    }

    public void removeById(int removeId) {
        repository.removeById(removeId);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        for (Product product : repository.findAll()) {
            if (product.getName().contains(text)) {
                // "добавляем в конец" массива result продукт product
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

}
