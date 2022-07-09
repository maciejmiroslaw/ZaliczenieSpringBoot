package com.example.demo.services;


import com.example.demo.entity.Ksiazka;

import java.util.List;

public interface BookService {
    List<Ksiazka> getBooks();
    public void saveBook(Ksiazka ksiazka);
    public void deleteBook(int id);
    public void updateBook(int id, Ksiazka ksiazka);
}
