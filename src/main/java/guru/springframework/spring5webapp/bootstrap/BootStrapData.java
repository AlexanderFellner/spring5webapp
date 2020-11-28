package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
// Spring Management Component
// When Spring implements this component,it's going to bring it into the Spring context,
// it will do DI into the constructor for this components
// Inmem database available at jdbc:h1:mem:testdb
// h2 console URL at http:://localhost/h2-console


@Component
public class BootStrapData implements CommandLineRunner {
    @Autowired
    private final AuthorRepository authorRepository;
    @Autowired
    private final BookRepository bookRepository;
    @Autowired
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository=publisherRepository;
    }

    @Override

    public void run(String... args) throws Exception {

      Publisher publisher=new Publisher("Alex","Vienna");

      publisherRepository.save(publisher);

      Author author=new Author("Evans","Eric");
      Book book=new Book("Domain Driven Design","1233");
      author.getBooks().add(book);
      book.getAuthors().add(author);
      book.setPublisher(publisher);
      publisher.getBooks().add(book);

      authorRepository.save(author);
      bookRepository.save(book);
      publisherRepository.save(publisher);

      Book book2=new Book("Design Patterns","32434");
      author.getBooks().add(book2);
      book2.getAuthors().add(author);
      book2.setPublisher(publisher);
      publisher.getBooks().add(book2);

      authorRepository.save(author);
      bookRepository.save(book2);
      publisherRepository.save(publisher);

      System.out.println(author.getBooks());






      Author rod=new Author("Rod","Johnson"); // Spring creator
      Book noEJB=new Book("J2EE Development without EJB","234235");
      rod.getBooks().add(noEJB);
      noEJB.getAuthors().add(rod);

      noEJB.setPublisher(publisher);
      publisher.getBooks().add(noEJB);

      authorRepository.save(rod);
      bookRepository.save(noEJB);
      publisherRepository.save(publisher);

      System.out.println("Started in Bootstrap");
      System.out.println("Number of authors "+authorRepository.count());
      System.out.println("Number of books "+bookRepository.count());
      System.out.println("Publisher number of books "+publisher.getBooks().size());
      System.out.println("Number of publishers ");
      publisherRepository.findAll().forEach(System.out::println);


    }
}
