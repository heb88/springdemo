package de.heb.springdemo.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Publisher
{
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   private String name;

   @OneToMany
   @JoinColumn(name = "publisher_id")
   Set<Book> books = new HashSet<>();

   public Publisher()
   {
   }

   public Publisher(String name)
   {
      this.name = name;
   }

   public Long getId()
   {
      return id;
   }

   public void setId(Long id)
   {
      this.id = id;
   }

   public String getName()
   {
      return name;
   }

   public void setName(String name)
   {
      this.name = name;
   }

   public Set<Book> getBooks()
   {
      return books;
   }

   public void setBooks(Set<Book> books)
   {
      this.books = books;
   }

   @Override
   public String toString()
   {
      return "Publisher{" +
             "id=" + id +
             ", name='" + name + '\'' +
             '}';
   }

   @Override
   public boolean equals(Object o)
   {
      if( this == o )
      {
         return true;
      }
      if( o == null || getClass() != o.getClass() )
      {
         return false;
      }

      Publisher publisher = (Publisher) o;

      return Objects.equals(id, publisher.id);
   }

   @Override
   public int hashCode()
   {
      return id != null ? id.hashCode() : 0;
   }
}
