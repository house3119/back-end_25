package bookstore.bookstore.model;

public class Book {
  String title, author, publicationYear, isbn, price;

  public String getTitle() {
    return title;
  }

  public Book(String title, String author, String publicationYear, String isbn, String price) {
    this.title = title;
    this.author = author;
    this.publicationYear = publicationYear;
    this.isbn = isbn;
    this.price = price;
  }

  public Book() {
  }

  public String getAuthor() {
    return author;
  }

  public String getPublicationYear() {
    return publicationYear;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public void setPublicationYear(String publicationYear) {
    this.publicationYear = publicationYear;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public String getPrice() {
    return price;
  }

  @Override
  public String toString() {
    return "Book [title=" + title + ", author=" + author + ", publicationYear=" + publicationYear + ", isbn=" + isbn
        + ", price=" + price + "]";
  }
  
}
