package bookstore.bookstore.web;

import org.springframework.web.bind.annotation.RestController;

import bookstore.bookstore.model.Book;
import bookstore.bookstore.model.BookRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
public class BookstoreRestController {

  private BookRepository bookRepository;

  public BookstoreRestController(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @RequestMapping(value="books", method=RequestMethod.GET)
  public List<Book> getAllBooks() {
      return (List<Book>) bookRepository.findAll();
  }
  
  @RequestMapping(value="books/{id}", method=RequestMethod.GET)
  public Optional<Book> getBookById(@PathVariable(required = true) Long id) {
      return bookRepository.findById(id);
  }
  
}
