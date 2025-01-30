package bookstore.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import bookstore.bookstore.model.Book;
import bookstore.bookstore.model.BookRepository;


@Controller
public class BookstoreController {

  private BookRepository bookRepository;

  public BookstoreController(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }


  @RequestMapping(value="booklist", method=RequestMethod.GET)
  public String booklist(Model model) {
    model.addAttribute("books", bookRepository.findAll());
    return "booklist";
  }

  
  @RequestMapping(value="addbook", method=RequestMethod.GET)
  public String addBook(Model model) {
    model.addAttribute("book", new Book());
    return "addbook";
  }
  

  @RequestMapping(value="addbook", method=RequestMethod.POST)
  public String saveBook(Book book) {
    bookRepository.save(book);
    return "redirect:/booklist";
  }

  
  @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
  public String deleteBook(@PathVariable("id") Long bookId, Model model) {
    bookRepository.deleteById(bookId);
    return "redirect:../booklist";
  }


  @RequestMapping(value="index", method=RequestMethod.GET)
  public String getIndex() {
    return "redirect:/booklist";
  }


  @RequestMapping(value="*", method=RequestMethod.GET)
  public String toIndex() {
    return "redirect:/index";
  }
  
}
