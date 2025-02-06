package bookstore.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bookstore.bookstore.model.Book;
import bookstore.bookstore.model.BookRepository;
import bookstore.bookstore.model.CategoryRepository;


@Controller
public class BookstoreController {

  private BookRepository bookRepository;
  private CategoryRepository categoryRepository;

  public BookstoreController(BookRepository bookRepository, CategoryRepository categoryRepository) {
    this.bookRepository = bookRepository;
    this.categoryRepository = categoryRepository;
  }


  @RequestMapping(value="booklist", method=RequestMethod.GET)
  public String booklist(Model model) {
    model.addAttribute("books", bookRepository.findAll());
    return "booklist";
  }

  
  @RequestMapping(value="addbook", method=RequestMethod.GET)
  public String addBook(Model model) {
    model.addAttribute("book", new Book());
    model.addAttribute("categories", categoryRepository.findAll());
    return "addbook";
  }
  

  // Used to save books from either creating a new book or editing an existing one
  @RequestMapping(value={"/savebook","/savebook/{id}"}, method=RequestMethod.POST)
  public String saveBook(Book book, @PathVariable(required = false) Long id) {

    // ID not in request, so should be a new book. Save it to DB
    if (id == null) {
      System.out.println("Uusi kirja");
      bookRepository.save(book);

    // ID in request, so should be editing of existing book
    } else {
      System.out.println("Vanha kirja");

      // Try to find existing book. If can't find it, redirect to booklist
      Book oldBook = bookRepository.findById(id).orElse(null);
      if (oldBook == null) {
        return "redirect:/booklist";
      }

      // Book found found. Update all values..
      oldBook.setTitle(book.getTitle());
      oldBook.setAuthor(book.getAuthor());
      oldBook.setIsbn(book.getIsbn());
      oldBook.setPublicationYear(book.getPublicationYear());
      oldBook.setPrice(book.getPrice());
      oldBook.setCategory(book.getCategory());
      bookRepository.save(oldBook);
    }
    return "redirect:/booklist";
  }

  
  @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
  public String deleteBook(@PathVariable("id") Long bookId) {
    bookRepository.deleteById(bookId);
    return "redirect:../booklist";
  }


  @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
  public String editBook(@PathVariable("id") Long bookId, Model model) {
    Book editBook = bookRepository.findById(bookId).orElse(null);
    System.out.println(editBook);
    
    if (editBook == null) {
      return "redirect:../booklist";
    } else {
      model.addAttribute("book", editBook);
      model.addAttribute("categories", categoryRepository.findAll());
      return "editbook";
    }
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
