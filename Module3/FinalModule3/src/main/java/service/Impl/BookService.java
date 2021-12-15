package service.Impl;

import model.Book;
import repository.IBookRepository;
import repository.Impl.BookRepository;
import service.IBookService;

import java.util.List;

public class BookService implements IBookService {
    IBookRepository bookRepository = new BookRepository();

    @Override
    public List<Book> getAllBook() {
        return this.bookRepository.getAllBook();
    }

    @Override
    public Book getBook(String id) {
        return this.bookRepository.getBook(id);
    }

    @Override
    public void addBook(Book book) {
        this.bookRepository.addBook(book);
    }

    @Override
    public void deleteBook(int id) {
        this.bookRepository.deleteBook(id);
    }

    @Override
    public void updateBook(Book book) {
        this.bookRepository.updateBook(book);
    }

    @Override
    public List<Book> searchBook(String name) {
        return this.bookRepository.searchBook(name);
    }
}
