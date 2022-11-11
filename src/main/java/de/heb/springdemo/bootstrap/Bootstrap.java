package de.heb.springdemo.bootstrap;


import de.heb.springdemo.model.Author;
import de.heb.springdemo.model.Book;
import de.heb.springdemo.model.Publisher;
import de.heb.springdemo.repository.AuthorRepository;
import de.heb.springdemo.repository.BookRepository;
import de.heb.springdemo.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner
{
   private final AuthorRepository authorRepository;
   private final BookRepository bookRepository;

   private final PublisherRepository publisherRepository;

   public Bootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository)
   {
      this.authorRepository = authorRepository;
      this.bookRepository = bookRepository;
      this.publisherRepository = publisherRepository;
   }

   @Override
   public void run(String... args) throws Exception
   {
      System.out.println("# Bootstrap started");
      Author ericAuthor = new Author("Eric", "Evans");
      Book ericsBook = new Book("EricsBook", "123456");
      ericAuthor.getBooks().add(ericsBook);
      ericsBook.getAuthors().add(ericAuthor);

      Author nickAuthor = new Author("Nick", "Fury");
      Book nicksBook = new Book("NicksBook", "321654");
      nickAuthor.getBooks().add(nicksBook);
      nicksBook.getAuthors().add(nickAuthor);

      authorRepository.save(ericAuthor);
      authorRepository.save(nickAuthor);

      bookRepository.save(ericsBook);
      bookRepository.save(nicksBook);


      Publisher piggybackPublisher = new Publisher("Piggyback");
      publisherRepository.save(piggybackPublisher);

      System.out.println("Amount of Books: " + bookRepository.count());
      System.out.println("Amount of Authors: " + authorRepository.count());
      System.out.println("Amount of Publisher: " + publisherRepository.count());

      System.out.println("# Bootstrap done");
   }
}
