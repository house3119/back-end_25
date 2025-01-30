package bookstore.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bookstore.bookstore.model.Book;
import bookstore.bookstore.model.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookStoreRunner(BookRepository bookRepository) {
		return(args) -> {

			log.info("Add some demo books to db...");

			bookRepository.save(new Book("Lord of the Rings: The Two Towers", "J.R.R. Tolkien", "1954", "978-951-0-33337-2", "24.00"));
			bookRepository.save(new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", "1997", "951-31-1146-6", "19.00"));

			log.info("Printing list of books...");

			for (Book book: bookRepository.findAll()) {
				log.info(book.toString());
			}

		};
		
	}

}
