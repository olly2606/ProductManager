package ProductManagerTest;

import ProductManager.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManagerTest {

    @Test
    public void testAdd() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(1, "Hello", 120, "Helen");
        Book book2 = new Book(2, "Hey", 100, "Hix");
        Book book3 = new Book(3, "Hi", 80, "Hox");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, book3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchWhenFewProductsFound() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(1, "Hello", 120, "Helen");
        Book book2 = new Book(2, "Hey", 100, "Hix");
        Book book3 = new Book(3, "Hi", 80, "Hox");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = manager.searchBy("Hello");
        Product[] expected = {book1};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchWhenAllProductsFound() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(1, "Hello", 100, "Helen");
        Book book2 = new Book(2, "Hey", 100, "Hix");
        Book book3 = new Book(3, "Hi", 100, "Hox");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = manager.searchBy("H");
        Product[] expected = {book1, book2, book3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchWhenNoneProductsFound() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(1, "Hello", 120, "Helen");
        Book book2 = new Book(2, "Hey", 100, "Hix");
        Book book3 = new Book(3, "Hi", 80, "Hox");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = manager.searchBy("hey");
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveById() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(1, "Hello", 120, "Helen");
        Book book2 = new Book(2, "Hey", 100, "Hix");
        Book book3 = new Book(3, "Hi", 80, "Hox");
        Smartphone smartphone1 = new Smartphone(4, "Nokia 3100", 300, "Nokia");

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.add(smartphone1);

        repo.removeById(3);
        repo.removeById(1);

        Product[] actual = repo.findAll();
        Product[] expected = {book2, smartphone1};

        Assertions.assertArrayEquals(expected, actual);
    }
}
