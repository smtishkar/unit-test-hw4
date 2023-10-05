import org.junit.jupiter.api.Test;
import seminars.fourth.book.Book;
import seminars.fourth.book.BookRepository;
import seminars.fourth.book.BookService;

import java.util.List;

//import static javafx.beans.binding.Bindings.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BookServiceTest {

    @Test
    void checkBookById() {
        BookRepository repo = mock(BookRepository.class);
        BookService bookService = new BookService(repo);

        when(repo.findById("1")).thenReturn(new Book("1", "Book1", "Author1"));
        Book result = bookService.findBookById("1");

        assertEquals("Book1", result.getTitle());
        assertEquals("Author1", result.getAuthor());
    }

    @Test
    void getAllBooks() {
        BookRepository repo = mock(BookRepository.class);
        BookService bookService = new BookService(repo);
        when(repo.findAll()).thenReturn(List.of(new Book("1", "Book1", "Author1")));
        List<Book> booksList = bookService.findAllBooks();
        assertEquals(1, booksList.size());

    }
}
