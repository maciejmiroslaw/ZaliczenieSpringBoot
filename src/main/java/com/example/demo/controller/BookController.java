package com.example.demo.controller;

import com.example.demo.entity.Ksiazka;
import com.example.demo.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    @GetMapping("/")
    public String index(Model model){
        return "index";
    }
    @GetMapping("/lista")
    public String listBook(Model model){
        ArrayList<Ksiazka> books = (ArrayList<Ksiazka>) bookService.getBooks();
        model.addAttribute("books",books);
        return "bookslist";
    }
    @GetMapping("/access-denied")
    public String denied(Model model){
        return "access-denied";
    }
    @GetMapping("/formadd")
    public String addForm(Model model){
        Ksiazka book = new Ksiazka();
        model.addAttribute("book", book);
        return "addbookform";
    }
    @PostMapping("/formadd")
    public String saveBook(@ModelAttribute("book") Ksiazka ksiazka){
        bookService.saveBook(ksiazka);
        return "redirect:/lista";
    }
    @GetMapping("/delete/{id}")
    public String removeBook(@PathVariable("id") int id){
        bookService.deleteBook(id);
        return "redirect:/lista";
    }
    @GetMapping("/update/{id}")
    public String getUpdate(@PathVariable("id") int id, @ModelAttribute("book") Ksiazka ksiazka, Model model){
        model.addAttribute("book", ksiazka);
        return "update";
    }
    @PostMapping("/update/{id}")
    public String updateBook(@PathVariable("id") int id, @ModelAttribute("book") Ksiazka ksiazka){
        bookService.updateBook(id, ksiazka);
        return "redirect:/lista";
    }
}
