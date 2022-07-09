package com.example.demo.dao;


import com.example.demo.entity.Ksiazka;


import java.util.List;

public interface BookDAO{
    public List<Ksiazka> getBooks();

    public void saveBook(Ksiazka ksiazka);
    public void deleteBook(int id);
    public void updateBook(int id, Ksiazka ksiazka);
}
