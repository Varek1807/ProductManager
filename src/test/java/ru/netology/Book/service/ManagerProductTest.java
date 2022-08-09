package ru.netology.Book.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ManagerProductTest {
    Repository repo = new Repository();
    ManagerProduct manager = new ManagerProduct(repo);
    Book book1 = new Book(1, "Book1", 100, "Autor1");
    Book book2 = new Book(2, "Book2", 200, "Autor2");
    Book book3 = new Book(3, "Book3", 300, "Autor3");
    Book book4 = new Book(4, "Magazine", 300, "Autor3");

    @Test
    public void bookTestSetAuthor() {
        this.book3.setAuthor("Author2222");
        String actual = this.book3.getAuthor();
        String expected = "Author2222";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSearchByText() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        Product[] expected = {book1, book2, book3};
        Product[] actual = manager.searchBy("Book");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchSingleWord() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        Product[] expected = {book1};
        Product[] actual = manager.searchBy("Book1");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchMissingWord() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        Product[] expected = {};
        Product[] actual = manager.searchBy("Book1111");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveById() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        Product[] expected = {book1, book3, book4};
        manager.removeById(book2.getId());
        Product[] actual = manager.repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

}