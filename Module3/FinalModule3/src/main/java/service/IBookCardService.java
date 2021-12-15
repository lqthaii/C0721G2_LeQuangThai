package repository;

import model.Book;
import model.BookCard;

import java.util.List;

public interface IBookCardRepository {
    public List<BookCard> getAllBookCard();
    public BookCard getBookCard(String id);
    public void addBookCard(BookCard bookCard);
    public void deleteBookCard(int id);
    public void updateBookCard(BookCard bookCard);
    public List<Book> searchBookCard(String name);
}
