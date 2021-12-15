package repository;

import model.Book;

import java.util.List;

public interface IBookRepository {
    public List<Book> getAllBook();
    public Book getBook(String id);
    public void addBook(Book book);
    public void deleteBook(int id);
    public void updateBook(Book book);
    public List<Book> searchBook(String name);
}
