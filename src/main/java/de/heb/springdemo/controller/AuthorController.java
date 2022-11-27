package de.heb.springdemo.controller;

import de.heb.springdemo.repository.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController
{
   AuthorRepository authorRepository;

   public AuthorController(AuthorRepository authorRepository)
   {
      this.authorRepository = authorRepository;
   }

   @RequestMapping("/authors")
   private String getAuthors(Model model)
   {
      model.addAttribute("authors", authorRepository.findAll());

      return "authors/list";
   }
}
