package com.example.demo.dao;

import com.example.demo.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> getUsers() {
        Session session = sessionFactory.openSession();
        Query<User> query = session.createQuery(" FROM User", User.class);
        List<User> users = query.getResultList();
        return users;
    }

    @Override
    public void saveUser(User user) {
        Session session = sessionFactory.openSession();
        session.save(user);
    }

    @Override
    public User getUser(String username) {
        Session session = sessionFactory.openSession();
        User user = (User)session.load(User.class, username);
        return user;
    }
}
