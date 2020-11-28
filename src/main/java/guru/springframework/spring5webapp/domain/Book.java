package guru.springframework.spring5webapp.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Book {


   @Id
   @GeneratedValue(strategy= GenerationType.AUTO)
   private long id;
   private String title;
   private String isbn;

   @ManyToOne
   private Publisher publisher;

   public Publisher getPublisher() {
      return publisher;
   }

   public void setPublisher(Publisher publisher) {
      this.publisher = publisher;
   }

   @ManyToMany
   @JoinTable(name="author.book",joinColumns=@JoinColumn(name="book.id"),
   inverseJoinColumns = @JoinColumn(name="author.id"))
   private Set<Author> authors=new HashSet<>();

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public Set<Author> getAuthors() {
      return authors;
   }

   public void setAuthors(Set<Author> authors) {
      this.authors = authors;
   }

   public Book() {
   }

   public Book(String title, String isbn,Set<Author> authors){
      this.title=title;
      this.isbn=isbn;
      this.authors=authors;
   }
   public Book(String title, String isbn){
      this.title=title;
      this.isbn=isbn;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public String getIsbn() {
      return isbn;
   }

   public void setIsbn(String isbn) {
      this.isbn = isbn;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      Book book = (Book) o;

      return id == book.id;
   }

   @Override
   public int hashCode() {
      return (int) (id ^ (id >>> 32));
   }

   @Override
   public String toString() {
      return "Book{" +
              "id=" + id +
              ", title='" + title + '\'' +
              ", isbn='" + isbn + '\'' +
           //   ", authors=" + authors +
              '}';
   }
}
