package com.example.demo.services;

import com.example.demo.dao.BookDAO;
import com.example.demo.entity.Ksiazka;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDAO bookDAO;

    @Override
    @Transactional
    public List<Ksiazka> getBooks(){
        List<Ksiazka> books = bookDAO.getBooks();
        return books;
    }

    @Override
    @Transactional
    public void saveBook(Ksiazka ksiazka){
        bookDAO.saveBook(ksiazka);
    }

    @Override
    @Transactional
    public void deleteBook(int id){
        bookDAO.deleteBook(id);
    }
    @Override
    @Transactional
    public void updateBook(int id, Ksiazka ksiazka){
        bookDAO.updateBook(id, ksiazka);
    }
}
