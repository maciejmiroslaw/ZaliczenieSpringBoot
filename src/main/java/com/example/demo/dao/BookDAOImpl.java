package com.example.demo.dao;

import com.example.demo.entity.Ksiazka;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Ksiazka> getBooks() {
        Session currentSession = sessionFactory.openSession();
        Query<Ksiazka> query = currentSession.createQuery(" from Ksiazka", Ksiazka.class);
        List<Ksiazka> books = query.getResultList();
        return books;
    }
    @Override
    public void saveBook(Ksiazka ksiazka){
        Session session = sessionFactory.openSession();
        session.save(ksiazka);
    }

    @Override
    public void deleteBook(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Ksiazka ksiazka = (Ksiazka)session.load(Ksiazka.class, id);
        session.delete(ksiazka);
        session.getTransaction().commit();
    }
    @Override
    public void updateBook(int id, Ksiazka ksiazka){
        Session session = sessionFactory.openSession();
        Ksiazka old = (Ksiazka)session.load(Ksiazka.class, id);
        old.setAutor(ksiazka.getAutor());
        old.setCena(ksiazka.getCena());
        old.setNazwa(ksiazka.getNazwa());
        old.setWydawnictwo(ksiazka.getWydawnictwo());
        session.update(old);
    }
}
